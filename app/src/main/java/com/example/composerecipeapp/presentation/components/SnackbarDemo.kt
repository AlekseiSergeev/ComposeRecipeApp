package com.example.composerecipeapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun DecoupledSnackbarDemo(
    snackbarHostState: SnackbarHostState
){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val snackbar = createRef()
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.constrainAs(snackbar) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            snackbar = {
                Snackbar(action = {
                    TextButton(onClick = {
                        snackbarHostState.currentSnackbarData?.dismiss()
                    }) {
                        Text(text = "Hide")
                    }
                } 
                ) {
                    Text(text = "Hey look a snackbar")
                }
            }
        )
    }

}
