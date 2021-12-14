package com.example.composerecipeapp.presentation.ui.recipe

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composerecipeapp.presentation.components.CircularIndeterminateProgressBar
import com.example.composerecipeapp.presentation.components.RecipeView
import com.example.composerecipeapp.presentation.theme.AppTheme


@Composable
fun RecipeScreen(
    isDarkTheme: Boolean,
    viewModel: RecipeViewModel = hiltViewModel(),
    recipeId: Int?
) {
    if(recipeId != null) {
        viewModel.onTriggerEvent(RecipeEvent.GetRecipeEvent(recipeId))
    }
    val loading = viewModel.loading.value
    val recipe = viewModel.recipe.value

    AppTheme(darkTheme = isDarkTheme) {
        RecipeView(recipe = recipe)
        CircularIndeterminateProgressBar(isDisplayed = loading)
    }
}