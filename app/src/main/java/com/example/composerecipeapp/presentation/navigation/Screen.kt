package com.example.composerecipeapp.presentation.navigation

sealed class Screen ( val route: String){
    object RecipeList: Screen("recipe_list_screen")
    object RecipeDetail: Screen("recipe_screen")
}
