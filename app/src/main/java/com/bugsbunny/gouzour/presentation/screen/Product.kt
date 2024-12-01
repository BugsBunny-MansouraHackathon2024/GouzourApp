package com.bugsbunny.gouzour.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bugsbunny.gouzour.presentation.viewmodel.ProductListViewModel


@Composable
fun ProductListScreen(navController: NavController, viewModel: ProductListViewModel) {
    Text(
        text = "CropListScreen",
        fontSize = 20.sp
    )
}