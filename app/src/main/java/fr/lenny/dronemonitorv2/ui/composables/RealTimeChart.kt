package fr.lenny.dronemonitorv2.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import fr.lenny.dronemonitorv2.MAX_DATASET_LEN
import fr.lenny.dronemonitorv2.R
import fr.lenny.dronemonitorv2.listOfColors
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme


@Composable
fun RealTimeChart(
    modifier: Modifier,
    data: String,
    minX: Float,
    maxX: Float,
    minY: Float,
    maxY: Float,
    dataSets: List<LineDataSet>
) {

    for (i in 0..dataSets.size - 1) {
        dataSets[i].apply {
            setDrawCircles(false)
            setDrawValues(false)
            color = getColor(LocalContext.current, listOfColors[i])
        }
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .border(3.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 5.dp, top = 10.dp, bottom = 10.dp, end = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                LineChart(context).apply {
                    setData(LineData(dataSets))
                    setTouchEnabled(true)
                    setPinchZoom(false)
                    isDoubleTapToZoomEnabled = false
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    xAxis.axisMinimum = minX
                    xAxis.axisMaximum = maxX
                    xAxis.mAxisRange = MAX_DATASET_LEN.toFloat()
                    axisLeft.axisMinimum = minY
                    axisLeft.axisMaximum = maxY
                    axisLeft.setDrawZeroLine(true)
                    axisLeft.zeroLineWidth = 1f
                    axisLeft.zeroLineColor = getColor(getContext() ,R.color.black)
                    axisRight.isEnabled = false
                    invalidate()
                }
            },
            update = {
                it.apply {
                    setData(LineData(dataSets))
                    setTouchEnabled(true)
                    setPinchZoom(false)
                    isDoubleTapToZoomEnabled = false
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    xAxis.axisMinimum = minX
                    xAxis.axisMaximum = maxX
                    xAxis.mAxisRange = MAX_DATASET_LEN.toFloat()
                    axisLeft.axisMinimum = minY
                    axisLeft.axisMaximum = maxY
                    axisLeft.setDrawZeroLine(true)
                    axisLeft.zeroLineWidth = 1f
                    axisLeft.zeroLineColor = getColor(getContext() ,R.color.black)
                    axisRight.isEnabled = false
                    invalidate()
                }
            }
        )
    }
}

@Preview
@Composable
fun RealTimeChartPreview() {
    val lineDataSet = LineDataSet(arrayListOf(Entry(500f, 100f), Entry(600f, 100f), Entry(700f, 100f)), "test")
    lineDataSet.setDrawCircles(false)
    lineDataSet.setDrawValues(false)
    lineDataSet.color = getColor(LocalContext.current ,R.color.red)

    DroneMonitorV2Theme {
        RealTimeChart(
            modifier = Modifier
                .width(400.dp)
                .height(170.dp),
            data = "",
            0f,
            1000f,
            -200f,
            200f,
            dataSets = arrayListOf(lineDataSet)
        )
    }
}