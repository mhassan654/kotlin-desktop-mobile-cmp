package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject_mobile_desk.composeapp.generated.resources.Res
import kotlinproject_mobile_desk.composeapp.generated.resources.compose_multiplatform
import org.example.project.viewModels.HomeViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {

    }
}

@Composable
fun AppContent(homeViewModel: HomeViewModel){
    val products = homeViewModel.products.collectAsState()

    BoxWithConstraints {
        val scope =this

        var cols = 2
        var modifier = Modifier.fillMaxWidth()
        if (maxWidth > 840.dp){
            cols=3
            modifier = Modifier.widthIn(max=1080.dp)
        }

        val scollState = rememberLazyGridState()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(cols),
                state = scollState, contentPadding = PaddingValues(16.dp)
            ){
               items(items=products.value,key={product->product.id.toString()}){
                   Card(shape = RoundedCornerShape(15.dp),
                       modifier = Modifier.padding(8.dp).fillMaxWidth(),
                       elevation = 2.dp) {
                       Column(
                           verticalArrangement = Arrangement.Center,
                           horizontalAlignment = Alignment.CenterHorizontally,
                       ){}

                   }

               }

            }

        }
    }
}