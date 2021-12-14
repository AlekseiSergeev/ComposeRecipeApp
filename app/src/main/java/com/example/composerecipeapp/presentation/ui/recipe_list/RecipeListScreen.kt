package com.example.composerecipeapp.presentation.ui.recipe_list

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composerecipeapp.presentation.components.RecipeList
import com.example.composerecipeapp.presentation.components.SearchAppBar
import com.example.composerecipeapp.presentation.theme.AppTheme


@ExperimentalComposeUiApi
@Composable
fun RecipeListScreen (
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    navController: NavController,
    viewModel: RecipeListViewModel = hiltViewModel()
){
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()

    val recipes = viewModel.recipes.value
    val query = viewModel.query.value
    val selectedCategory = viewModel.selectedCategory.value
    val loading = viewModel.loading.value
    val page = viewModel.page.value

    AppTheme(darkTheme = isDarkTheme) {
        Scaffold(
            topBar = {
                SearchAppBar(
                    query = query,
                    keyboardController = keyboardController,
                    scrollState = scrollState,
                    onQueryChanged = viewModel::onQueryChanged,
                    onExecuteSearch = {viewModel.onTriggerEvent(RecipeListEvent.NewSearchEvent)},
                    scrollPosition = viewModel.categoryScrollPosition,
                    selectedCategory = selectedCategory,
                    onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                    onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                    onToggleTheme = {
                        onToggleTheme()
                    }
                )
            },
            scaffoldState = scaffoldState,
            snackbarHost = { scaffoldState.snackbarHostState }
        ) {
            RecipeList(
                loading = loading,
                recipes = recipes,
                onChangeRecipeScrollPosition = viewModel::onChangeRecipeScrollPosition,
                page = page,
                onTriggerNextPage = { viewModel.onTriggerEvent(RecipeListEvent.NextPageEvent) },
                navController = navController
            )
        }
    }
}