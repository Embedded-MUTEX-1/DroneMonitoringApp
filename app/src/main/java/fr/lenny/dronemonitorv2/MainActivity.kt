package fr.lenny.dronemonitorv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import fr.lenny.dronemonitorv2.ui.screens.DroneMonitorNav
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DroneMonitorV2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DroneMonitorNav()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = "id:Raspberry Pi",
    showSystemUi = true,
    apiLevel = 33,
)
@Composable
fun MainPreview() {
    DroneMonitorV2Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DroneMonitorNav()
        }
    }
}