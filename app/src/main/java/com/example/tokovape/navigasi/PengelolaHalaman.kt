package com.example.tokovape.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tokovape.R
import com.example.tokovape.ui.theme.Halaman.DestinasiEntry
import com.example.tokovape.ui.theme.Halaman.DestinasiHome
import com.example.tokovape.ui.theme.Halaman.DestinasiLogin
import com.example.tokovape.ui.theme.Halaman.DetailDestination
import com.example.tokovape.ui.theme.Halaman.DetailScreen
import com.example.tokovape.ui.theme.Halaman.EntryTokoScreen
import com.example.tokovape.ui.theme.Halaman.HalamanLogin
import com.example.tokovape.ui.theme.Halaman.HomeScreen
import com.example.tokovape.ui.theme.Halaman.ItemEditDestination
import com.example.tokovape.ui.theme.Halaman.ItemEditScreen

@Composable
fun TokoApp(navController: NavHostController= rememberNavController()){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TokoTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController=navController,
        startDestination = DestinasiLogin.route,
        modifier = Modifier )
    {

        composable(route = DestinasiLogin.route) {
            HalamanLogin (
                onNextButtonClicked = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }

        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {
                    navController.navigate("${DetailDestination.route}/$it")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntryTokoScreen(navigateBack = { navController.popBackStack()})
        }

        composable(
            DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.tokoIdArg) {
                type = NavType.IntType
            })
        ){
            DetailScreen(
                navigateToEditItem = {
                    navController.navigate("${ItemEditDestination.route}/$it")
                },
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(
            ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}

