package com.example.shoe_store.pages

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCartCheckout
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shoe_store.viewModels.MainPageViewModel
import com.example.shoe_store.components.AppTopBar
import com.example.shoe_store.components.CustomNavigationBarItem
import com.example.shoe_store.components.HomePageDrawer
import com.example.shoe_store.components.HomePageSearchBar
import com.example.shoe_store.components.MainPageHotPicksSection
import com.example.shoe_store.viewModels.UserViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    userViewModel: UserViewModel,
    mainPageViewModel: MainPageViewModel,
    onNavigateToSearch: () -> Unit,
    onNavigateToItem: (String) -> Unit,
    onNavigateToCart: () -> Unit,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    var isActive by remember {
        mutableStateOf("Home")
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            HomePageDrawer()
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    navIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.Transparent
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(0.9f),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CustomNavigationBarItem(
                                label = "Home",
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = ""
                                    )
                                },
                                isActive = isActive == "Home",
                                onClick = {
                                    isActive = "Home"
                                }
                            )
                            CustomNavigationBarItem(
                                label = "Cart",
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.ShoppingCartCheckout,
                                        contentDescription = ""
                                    )
                                },
                                isActive = isActive == "Cart",
                                onClick = {
                                    isActive = "Cart"
                                    onNavigateToCart()
                                }
                            )
                        }
                    }
                }
            },
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState)
            }
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
                        .fillMaxWidth(0.9f)
                ) {
                    Spacer(Modifier.height(20.dp))
                    Box(
                        modifier = Modifier.clickable {
                            mainPageViewModel.changeHomePageSearchBarIsActive()
                            onNavigateToSearch()
                        }
                    ) {
                        HomePageSearchBar(
                            isActive = mainPageViewModel.homePageSearchBarIsActive,
                            value = "",
                            onValueChange = {

                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    MainPageHotPicksSection(
                        userViewModel = userViewModel,
                        onAddItemToCart = { shoeId ->
                            val result = userViewModel.addShoeToCart(id = shoeId)
                            if(result == "OK") {
                                scope.launch {
                                    snackBarHostState.showSnackbar("Item added")
                                }
                            } else {
                                scope.launch {
                                    snackBarHostState.showSnackbar("Already in cart")
                                }
                            }
                        },
                        onNavigateToItem = onNavigateToItem,
                        shoes = mainPageViewModel.getHotPicks()
                    )
                }
            }
        }
    }
}