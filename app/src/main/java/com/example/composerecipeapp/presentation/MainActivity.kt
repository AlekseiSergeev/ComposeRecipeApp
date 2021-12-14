package com.example.composerecipeapp.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composerecipeapp.datastore.SettingsDataStore
import com.example.composerecipeapp.presentation.navigation.Screen
import com.example.composerecipeapp.presentation.ui.recipe.RecipeScreen
import com.example.composerecipeapp.presentation.ui.recipe_list.RecipeListScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var settingsDataStore: SettingsDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.RecipeList.route
            ) {
                composable(route = Screen.RecipeList.route) {
                    RecipeListScreen(
                        navController = navController,
                        isDarkTheme = settingsDataStore.isDark.value,
                        onToggleTheme = settingsDataStore::toggleTheme
                    )
                }
                composable(route = Screen.RecipeDetail.route +
                        "?recipeId={recipeId}",
                    arguments = listOf(
                        navArgument(name = "recipeId") {
                            type = NavType.IntType
                        }
                    )
                ) {
                    val recipeId = it.arguments?.getInt("recipeId")
                    RecipeScreen(
                        recipeId = recipeId,
                        isDarkTheme = settingsDataStore.isDark.value
                    )
                }
            }
        }

    }
}