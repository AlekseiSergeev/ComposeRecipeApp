package com.example.composerecipeapp.presentation.ui.recipe_list

import com.example.composerecipeapp.presentation.ui.recipe_list.FoodCategory.*

enum class FoodCategory (val value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    PORK("Pork"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllFoodCategories (): List<FoodCategory> {
    return listOf(CHICKEN, BEEF, PORK, SOUP, DESSERT, VEGETARIAN, MILK, VEGAN, PIZZA, DONUT)
}

fun getFoodCategory (value: String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}
