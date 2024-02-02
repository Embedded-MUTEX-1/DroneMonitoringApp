package fr.lenny.dronemonitorv2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@Composable
fun NavBar(
    viewModel: NavBarViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.onSurface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface {

        }
    }
}

@Preview
@Composable
fun NavBarPreview() {
    DroneMonitorV2Theme {
        NavBar(
            viewModel = hiltViewModel(),
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight())
    }
}