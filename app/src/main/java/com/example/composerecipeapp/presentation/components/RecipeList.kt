package com.example.composerecipeapp.presentation.components

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composerecipeapp.R
import com.example.composerecipeapp.domain.model.Recipe
import com.example.composerecipeapp.presentation.navigation.Screen
import com.example.composerecipeapp.presentation.ui.recipe_list.PAGE_SIZE

@Composable
fun RecipeList(
    loading: Boolean,
    recipes: List<Recipe>,
    onChangeRecipeScrollPosition: (Int) -> Unit,
    page: Int,
    onTriggerNextPage: () -> Unit,
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        if(loading && recipes.isEmpty()) {
            LoadingRecipeListShimmer(cardHeight = 250.dp)
        }
        else {
            LazyColumn {
                itemsIndexed(
                    items = recipes
                ) { index, recipe ->
                    onChangeRecipeScrollPosition(index)
                    if((index + 1) >= (page * PAGE_SIZE) && !loading){
                        onTriggerNextPage()
                    }
                    RecipeCard(recipe = recipe, onClick = {
                        if(recipe.id != null) {
                            navController.navigate(
                                Screen.RecipeDetail.route +
                                        "?recipeId=${recipe.id}"
                            )
                        }
                    })
                }
            }
        }
        CircularIndeterminateProgressBar(isDisplayed = loading)
    }
}