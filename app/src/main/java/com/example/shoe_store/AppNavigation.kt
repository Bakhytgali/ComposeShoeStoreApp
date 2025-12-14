package com.example.shoe_store

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.shoe_store.data.User
import com.example.shoe_store.pages.HomePage
import com.example.shoe_store.pages.WelcomePage
import kotlinx.serialization.Serializable

// Welcome Page Data Object
@Serializable
data object WelcomePage : NavKey

// Shop Main Page
@Serializable
data object HomePage : NavKey

// Shoe Page
@Serializable
data class ShopItemPage(val id: String) : NavKey

@Composable
fun AppNavigation(
    user: User,
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
                            onClick = {
                                backStack.add(HomePage)
                            }
                        )
                    }
                is HomePage ->
                    NavEntry(
                        key = key
                    ) {
                        HomePage()
                    }
                else -> throw RuntimeException("Invalid Route")
            }
        }
    )
}