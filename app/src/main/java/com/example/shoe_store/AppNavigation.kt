package com.example.shoe_store

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.shoe_store.data.UserViewModel
import com.example.shoe_store.pages.CartPage
import com.example.shoe_store.pages.HomePage
import com.example.shoe_store.pages.SearchPage
import com.example.shoe_store.pages.ShopItemPage
import com.example.shoe_store.pages.WelcomePage
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
    user: UserViewModel,
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(WelcomePage)
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
                            user = user,
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
                            user = user,
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
                            user = user,
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
                            user = user,
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
                            user = user,
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