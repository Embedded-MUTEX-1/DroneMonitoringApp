package fr.lenny.dronemonitorv2.ui.screens.monitoring

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import fr.lenny.dronemonitorv2.R
import fr.lenny.dronemonitorv2.model.TelemetryData
import fr.lenny.dronemonitorv2.listOfStatus
import fr.lenny.dronemonitorv2.ui.composables.RealTimeChart
import fr.lenny.dronemonitorv2.ui.composables.TextValue
import fr.lenny.dronemonitorv2.ui.screens.app_nav.NavBarViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MonitoringScreen(
    modifier: Modifier = Modifier,
    viewModel: MonitoringViewModel = hiltViewModel(),
) {
    val telemetryValues = viewModel.telemetryValues.collectAsState()
    
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f / 3f)
                .padding(10.dp)
        ) {
            RealTimeChart(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                data = "",
                telemetryValues.value.minX,
                telemetryValues.value.maxX,
                -180f,
                180f,
                dataSets = telemetryValues.value.listOfLineDataSetAngles
            )
            
            Spacer(modifier = Modifier.width(20.dp))

            RealTimeChart(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                data = "",
                telemetryValues.value.minX,
                telemetryValues.value.maxX,
                1000f,
                2000f,
                dataSets = telemetryValues.value.listOfLineDataSetMotors
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f / 3f)
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "Roll", value = telemetryValues.value.telemetryData.roll.toString())
                TextValue(Modifier.weight(1f/4f), name = "M0T1", value = telemetryValues.value.telemetryData.mot[0].toString())
                TextValue(Modifier.weight(1f/4f), name = "MOT2", value = telemetryValues.value.telemetryData.mot[1].toString())
                TextValue(Modifier.weight(1f/4f), name = "Timestamp", value = telemetryValues.value.telemetryData.timestamp.toString())
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "Pitch", value = telemetryValues.value.telemetryData.pitch.toString())
                TextValue(Modifier.weight(1f/4f), name = "NA", value = "NA")
                TextValue(Modifier.weight(1f/4f), name = "NA", value = "NA")
                TextValue(Modifier.weight(1f/4f), name = "NA", value = "NA")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "Yaw", value = telemetryValues.value.telemetryData.yaw.toString())
                TextValue(Modifier.weight(1f/4f), name = "MOT3", value = telemetryValues.value.telemetryData.mot[2].toString())
                TextValue(Modifier.weight(1f/4f), name = "MOT4", value = telemetryValues.value.telemetryData.mot[3].toString())
                TextValue(Modifier.weight(1f/4f), name = "NA", value = "NA")
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f / 3f)
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "CH1", value = telemetryValues.value.telemetryData.ch[0].toString())
                TextValue(Modifier.weight(1f/4f), name = "CH4", value = telemetryValues.value.telemetryData.ch[3].toString())
                TextValue(Modifier.weight(1f/4f), name = "Loop Time", value = telemetryValues.value.telemetryData.loopTime.toString())
                TextValue(Modifier.weight(1f/4f), name = "Latitude", value = telemetryValues.value.telemetryData.lat.toString())
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "CH2", value = telemetryValues.value.telemetryData.ch[1].toString())
                TextValue(Modifier.weight(1f/4f), name = "CH5", value = telemetryValues.value.telemetryData.ch[4].toString())
                TextValue(Modifier.weight(1f/4f), name = "Altitude", value = telemetryValues.value.telemetryData.alt.toString())
                TextValue(Modifier.weight(1f/4f), name = "Longitude", value = telemetryValues.value.telemetryData.lon.toString())
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "CH3", value = telemetryValues.value.telemetryData.ch[2].toString())
                TextValue(Modifier.weight(1f/4f), name = "CH6", value = telemetryValues.value.telemetryData.ch[5].toString())
                TextValue(Modifier.weight(1f/4f), name = "Battery", value = String.format("%.2f" ,telemetryValues.value.telemetryData.vBat))
                TextValue(Modifier.weight(1f/4f), name = "Status", value = listOfStatus[telemetryValues.value.telemetryData.status])
            }
        }
    }
}