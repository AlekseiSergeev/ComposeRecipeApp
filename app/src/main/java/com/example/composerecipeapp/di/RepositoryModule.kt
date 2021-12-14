package com.example.composerecipeapp.di

import com.example.composerecipeapp.data.network.RecipeService
import com.example.composerecipeapp.data.network.model.RecipeDtoMapper
import com.example.composerecipeapp.domain.repository.RecipeRepository
import com.example.composerecipeapp.data.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeService, recipeDtoMapper)
    }
}