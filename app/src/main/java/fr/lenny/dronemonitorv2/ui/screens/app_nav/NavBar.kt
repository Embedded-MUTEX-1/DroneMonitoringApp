package fr.lenny.dronemonitorv2.ui.screens.app_nav

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.LocalSee
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import fr.lenny.dronemonitorv2.R
import fr.lenny.dronemonitorv2.ui.composables.NavButton
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(
    viewModel: NavBarViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onNavToCamera: () -> Unit,
    onNavToMonitoring: () -> Unit,
    onNavToConfig: () -> Unit,
    onNavToGps: () -> Unit,
) {
    val ipAddr = viewModel.ipAddrText.collectAsState()
    val buttonState = viewModel.buttonState.collectAsState()
    val event = viewModel.event.collectAsState()

    if(event.value == EventType.JSON_ERR)
        Toast.makeText(LocalContext.current, stringResource(R.string.recv_data_error), Toast.LENGTH_SHORT).show()
    else if(event.value == EventType.TIMEOUT_ERR)
        Toast.makeText(LocalContext.current, stringResource(R.string.recv_data_timeout), Toast.LENGTH_SHORT).show()

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.onSurface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Surface(
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )

        NavButton(
            icon = Icons.Outlined.LocalSee,
            iconDescription = stringResource(R.string.camera_button),
            text = stringResource(R.string.cameraText),
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            onClicked = onNavToCamera
        )

        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )

        NavButton(
            icon = Icons.Outlined.BarChart,
            iconDescription = stringResource(R.string.monitoring_button),
            text = stringResource(R.string.monitoringText),
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            onClicked = onNavToMonitoring
        )

        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )

        NavButton(
            icon = Icons.Outlined.Build,
            iconDescription = stringResource(R.string.config_button),
            text = stringResource(R.string.configText),
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            onClicked = onNavToConfig
        )

        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )

        NavButton(
            icon = Icons.Outlined.LocationOn,
            iconDescription = stringResource(R.string.gps_button),
            text = stringResource(R.string.gpsText),
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            onClicked = onNavToGps
        )

        Divider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = ipAddr.value,
            onValueChange = { newText -> viewModel.updateTextField(newText) },
            modifier = Modifier
                .fillMaxWidth(0.93f),
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = MaterialTheme.colorScheme.background),
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text(text = stringResource(R.string.enter_drone_ip)) },
        )

        Spacer(modifier = Modifier.height(10.dp))
        
        Button(
            onClick = { viewModel.setDroneIpaddr() },
            modifier = Modifier
                .fillMaxWidth(0.93f),
        ) {
            Text(
                text = if (buttonState.value) stringResource(R.string.stop) else stringResource(R.string.start),
                fontSize = 25.sp
            )
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
                .width(200.dp)
                .fillMaxHeight(),
            { },
            { },
            { },
            { }
        )
    }
}