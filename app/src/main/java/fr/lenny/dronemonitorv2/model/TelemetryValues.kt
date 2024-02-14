package fr.lenny.dronemonitorv2.model

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet

data class TelemetryValues(
    val telemetryData: TelemetryData = TelemetryData(),
    val listOfLineDataSetAngles: ArrayList<LineDataSet> = arrayListOf(LineDataSet(arrayListOf(Entry(0f, 0f)), "")),
    val listOfLineDataSetGyro: ArrayList<LineDataSet> = arrayListOf(LineDataSet(arrayListOf(Entry(0f, 0f)), "")),
    val listOfLineDataSetAccel: ArrayList<LineDataSet> = arrayListOf(LineDataSet(arrayListOf(Entry(0f, 0f)), "")),
    val listOfLineDataSetMotors: ArrayList<LineDataSet> = arrayListOf(LineDataSet(arrayListOf(Entry(0f, 0f)), "")),
    val minX: Float = 0f,
    val maxX: Float = 0f
)
