package com.example.shoe_store

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.shoe_store.viewModels.UserViewModel
import com.example.shoe_store.pages.CartPage
import com.example.shoe_store.pages.HomePage
import com.example.shoe_store.pages.SearchPage
import com.example.shoe_store.pages.ShopItemPage
import com.example.shoe_store.pages.WelcomePage
import com.example.shoe_store.viewModels.MainPageViewModel
import com.example.shoe_store.viewModels.SearchViewModel
import kotlinx.serialization.Serializable

// Welcome Page Data Object
@Serializable
data object WelcomePage : NavKey

// Shop Main Page
@Serializable
data object HomePage : NavKey

// Search Page
@Serializable
data object SearchPage : NavKey

// Shoe Page
@Serializable
data class ShopItemPage(val id: String) : NavKey

@Serializable
data object CartPage : NavKey

@Composable
fun AppNavigation(
    userViewModel: UserViewModel,
    mainPageViewModel: MainPageViewModel,
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(WelcomePage)
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            when (key) {
                is WelcomePage ->
                    NavEntry(
                        key = key
                    ) {
                        WelcomePage(
                            user = userViewModel,
                            onClick = {
                                backStack.add(HomePage)
                            }
                        )
                    }

                is HomePage ->
                    NavEntry(
                        key = key
                    ) {
                        HomePage(
                            userViewModel = userViewModel,
                            mainPageViewModel = mainPageViewModel,
                            onNavigateToItem = { itemId ->
                                backStack.add(ShopItemPage(id = itemId))
                            },
                            onNavigateToSearch = {
                                backStack.add(SearchPage)
                            },
                            onNavigateToCart = {
                                backStack.add(CartPage)
                            }
                        )
                    }

                is ShopItemPage ->
                    NavEntry(
                        key = key
                    ) {
                        ShopItemPage(
                            userViewModel = userViewModel,
                            itemId = key.id,
                            onBack = {
                                backStack.removeLastOrNull()
                            }
                        )
                    }

                is SearchPage ->
                    NavEntry(
                        key = key
                    ) {
                        SearchPage(
                            userViewModel = userViewModel,
                            searchViewModel = searchViewModel,
                            onNavigateToShopItem = { itemId ->
                                backStack.add(ShopItemPage(id = itemId))
                            },
                            onBack = {
                                backStack.removeLastOrNull()
                            }
                        )
                    }

                is CartPage ->
                    NavEntry(
                        key = key
                    ) {
                        CartPage(
                            userViewModel = userViewModel,
                            onBack = {
                                backStack.removeLastOrNull()
                            },
                            onNavigateToHome = {
                                backStack.add(HomePage)
                            }
                        )
                    }

                else -> throw RuntimeException("Invalid Route")
            }
        }
    )
}