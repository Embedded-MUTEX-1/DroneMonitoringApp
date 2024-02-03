package fr.lenny.dronemonitorv2.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.lenny.dronemonitorv2.ui.screens.camera_preview.CameraPreviewScreen
import fr.lenny.dronemonitorv2.ui.screens.config.ConfigSreen
import fr.lenny.dronemonitorv2.ui.screens.gps.GpsScreen
import fr.lenny.dronemonitorv2.ui.screens.monitoring.MonitoringScreen
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@Composable
fun DroneMonitorNav() {
    val navController = rememberNavController()

    Row(Modifier.fillMaxSize()) {
        NavBar(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.25f),
            onNavToCamera = { navController.navigate(NavRoutes.CAMERA.name) },
            onNavToMonitoring = { navController.navigate(NavRoutes.MONITORING.name) },
            onNavToConfig = { navController.navigate(NavRoutes.CONFIG.name) },
            onNavToGps = { navController.navigate(NavRoutes.GPS.name) }
        )
        Surface(Modifier
            .fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = NavRoutes.CAMERA.name,
            ) {
                composable(NavRoutes.CAMERA.name) { CameraPreviewScreen(Modifier.fillMaxSize()) }
                composable(NavRoutes.MONITORING.name) { MonitoringScreen() }
                composable(NavRoutes.CONFIG.name) { ConfigSreen() }
                composable(NavRoutes.GPS.name) { GpsScreen() }
            }
        }
    }
}

@Preview
@Composable
fun DroneMonitorPreview() {
    DroneMonitorV2Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DroneMonitorNav()
        }
    }
}