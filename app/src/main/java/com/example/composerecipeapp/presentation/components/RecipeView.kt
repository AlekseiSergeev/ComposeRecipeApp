package com.example.composerecipeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.composerecipeapp.domain.model.Recipe
import com.example.composerecipeapp.util.DEFAULT_RECIPE_IMAGE
import com.example.composerecipeapp.util.loadPicture

const val IMAGE_HEIGHT = 250
@Composable
fun RecipeView(
    recipe: Recipe?
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colors.background)
    ) {
        recipe?.featuredImage?.let { url ->
            val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
            image?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Recipe image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(IMAGE_HEIGHT.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        recipe?.title?.let { title ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground
                )
                val rank = recipe.rating.toString()
                Text(
                    text = rank,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary
                )
              }
            }
        Spacer(modifier = Modifier.padding(8.dp))
        recipe?.publisher?.let { publisher ->
            val updated = recipe.dateUpdated
            Text(
                text = if(updated != null) {
                    "Updated ${updated} by ${publisher}"
                }
                else {
                    "By ${publisher}"
                },
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        recipe?.ingredients?.let { list ->
            list.forEach {
                Text(
                    text = it,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, bottom = 6.dp),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        recipe?.sourceUrl?.let {
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colors.onBackground)) {
                    append("Source Url: ")
                }
                pushStringAnnotation(tag = "link", annotation = "$it")
                withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
                    append("link here")
                }
                pop()
            }
            val uriHandler = LocalUriHandler.current
            ClickableText(
                text = annotatedString,
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp),
                style = MaterialTheme.typography.body2,
                onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "link", start = offset, end = offset)
                    .firstOrNull()?.let {
                        uriHandler.openUri(it.item)
                }
            })
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
