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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import fr.lenny.dronemonitorv2.R
import fr.lenny.dronemonitorv2.ui.composables.RealTimeChart
import fr.lenny.dronemonitorv2.ui.composables.TextValue

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MonitoringScreen(modifier: Modifier = Modifier) {

    val lineDataSet = LineDataSet(arrayListOf(Entry(500f, 100f), Entry(600f, 100f), Entry(700f, 100f)), "test")
    lineDataSet.setDrawCircles(false)
    lineDataSet.setDrawValues(false)
    lineDataSet.color = ContextCompat.getColor(LocalContext.current, R.color.red)
    
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
                0f,
                1000f,
                -200f,
                200f,
                dataSets = arrayListOf(lineDataSet)
            )
            
            Spacer(modifier = Modifier.width(20.dp))

            RealTimeChart(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                data = "",
                0f,
                1000f,
                -200f,
                200f,
                dataSets = arrayListOf(lineDataSet)
            )
        }
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
                0f,
                1000f,
                -200f,
                200f,
                dataSets = arrayListOf(lineDataSet)
            )

            Spacer(modifier = Modifier.width(20.dp))

            RealTimeChart(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                data = "",
                0f,
                1000f,
                -200f,
                200f,
                dataSets = arrayListOf(lineDataSet)
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
                TextValue(Modifier.weight(1f/4f), name = "CH1", value = "1000")
                TextValue(Modifier.weight(1f/4f), name = "CH4", value = "1000")
                TextValue(Modifier.weight(1f/4f), name = "Loop Time", value = "4")
                TextValue(Modifier.weight(1f/4f), name = "Latitude", value = "48.0000000")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "CH2", value = "1000")
                TextValue(Modifier.weight(1f/4f), name = "CH5", value = "1000")
                TextValue(Modifier.weight(1f/4f), name = "Altitude", value = "4")
                TextValue(Modifier.weight(1f/4f), name = "Longitude", value = "48.0000000")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f / 3f)
            ) {
                TextValue(Modifier.weight(1f/4f), name = "CH3", value = "1000")
                TextValue(Modifier.weight(1f/4f), name = "CH6", value = "1000")
                TextValue(Modifier.weight(1f/4f), name = "Battery", value = "4")
                TextValue(Modifier.weight(1f/4f), name = "Status", value = "48.0000000")
            }
        }
    }
}