package com.example.composerecipeapp.data.repository

import com.example.composerecipeapp.domain.model.Recipe
import com.example.composerecipeapp.data.network.RecipeService
import com.example.composerecipeapp.data.network.model.RecipeDtoMapper
import com.example.composerecipeapp.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {

    override suspend fun searchRecipes(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun getRecipe(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }
}