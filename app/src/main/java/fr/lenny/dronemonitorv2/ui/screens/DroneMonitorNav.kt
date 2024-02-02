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
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@Composable
fun DroneMonitorNav() {
    Row(Modifier.fillMaxSize()) {
        NavBar(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.25f)
        )
        Surface(Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.75f)
        ) {

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