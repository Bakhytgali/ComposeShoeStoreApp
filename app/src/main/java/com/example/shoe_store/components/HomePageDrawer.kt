package com.example.shoe_store.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shoe_store.R

@Composable
fun HomePageDrawer(
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet(
        drawerContainerColor = MaterialTheme.colorScheme.onBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.nike_logo),
                contentDescription = "Nike White Logo",
                colorFilter = ColorFilter.tint(
                    color = Color.White,
                    blendMode = BlendMode.SrcIn
                ),
                modifier = Modifier.width(200.dp)
            )

            Column {
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Home",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.background
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.background
                        )
                    },
                    onClick = {

                    }
                )

                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.background
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.background
                        )
                    },
                    onClick = {

                    }
                )
            }

            NavigationDrawerItem(
                label = {
                    Text(
                        text = "Log Out",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                },
                selected = false,
                icon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                },
                onClick = {

                }
            )
        }
    }
}