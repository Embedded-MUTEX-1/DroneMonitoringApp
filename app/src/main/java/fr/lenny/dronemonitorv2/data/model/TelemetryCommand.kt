package fr.lenny.dronemonitorv2.data.model

data class TelemetryCommand(
    val roll: Double,
    val pitch: Double,
    val yaw: Double,
    val proll: Double,
    val ppitch: Double,
    val pyaw: Double,
    val iroll: Double,
    val ipitch: Double,
    val iyaw: Double,
    val droll: Double,
    val dpitch: Double,
    val dyaw: Double,
    val pAlt: Double,
    val iAlt: Double,
    val dAlt: Double,
    val pNav: Double,
    val iNav: Double,
    val dNav: Double,
    val vBat: Double,
    val lat: Double,
    val lon: Double,
    val param1: Double,
    val param2: Double,
    val status: String,
    val mot: List<Long>
)
