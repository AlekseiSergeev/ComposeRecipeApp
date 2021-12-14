package com.example.composerecipeapp.domain.repository

import com.example.composerecipeapp.domain.model.Recipe

interface RecipeRepository {

    suspend fun searchRecipes (token: String, page: Int, query: String): List<Recipe>

    suspend fun getRecipe (token: String, id: Int): Recipe
}