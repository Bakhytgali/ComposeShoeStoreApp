package com.example.shoe_store.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoe_store.components.AppTopBar
import com.example.shoe_store.components.RatingStars
import com.example.shoe_store.components.ShoeCharacsRow
import com.example.shoe_store.components.ShoeReviewsColumn
import com.example.shoe_store.components.ShopItemPageSectionHeader
import com.example.shoe_store.data.ShoeModel
import com.example.shoe_store.data.ShoeOperations
import com.example.shoe_store.data.ShoeStore
import com.example.shoe_store.viewModels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopItemPage(
    user: UserViewModel,
    itemId: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var shoe: ShoeModel? by remember {
        mutableStateOf(null)
    }
    LaunchedEffect(Unit) {
        shoe = ShoeStore.getShoeById(itemId)
    }

    Scaffold(
        topBar = {
            AppTopBar(
                navIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(Modifier.height(20.dp))
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 15.dp, horizontal = 20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        shoe?.let {
                            Image(
                                painter = painterResource(it.shoeImg),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(300.dp)
                            )

                            Text(
                                text = it.shoeName,
                                style = MaterialTheme.typography.headlineLarge
                            )

                            Spacer(Modifier.height(10.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(15.dp),
                                verticalAlignment = Alignment.Bottom
                            ){
                                Text(
                                    text = "${it.shoePrice}$",
                                    style = MaterialTheme.typography.bodyLarge,
                                )

                                RatingStars(
                                    rating = if(shoe != null) ShoeOperations.countAvgReview(shoe!!) else 0.0
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))

                ShopItemPageSectionHeader(header = "Metrics")
                Spacer(Modifier.height(10.dp))
                ShoeCharacsRow(
                    characteristic = if(shoe != null) shoe!!.characteristics else emptyList()
                )

                Spacer(Modifier.height(20.dp))
                ShopItemPageSectionHeader(header = "Reviews")
                Spacer(Modifier.height(10.dp))

                ShoeReviewsColumn(
                    reviews = if(shoe != null) shoe!!.reviews else emptyList()
                )
            }
        }
    }
}