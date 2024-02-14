package fr.lenny.dronemonitorv2.model

data class TelemetryConfig(
    val isInitConfig: Int = 0,
    val roll: Double = 0.0,
    val pitch: Double = 0.0,
    val yaw: Double = 0.0,
    val proll: Double = 0.0,
    val ppitch: Double = 0.0,
    val pyaw: Double = 0.0,
    val iroll: Double = 0.0,
    val ipitch: Double = 0.0,
    val iyaw: Double = 0.0,
    val droll: Double = 0.0,
    val dpitch: Double = 0.0,
    val dyaw: Double = 0.0,
    val pAlt: Double = 0.0,
    val iAlt: Double = 0.0,
    val dAlt: Double = 0.0,
    val pnav: Double = 0.0,
    val inav: Double = 0.0,
    val dnav: Double = 0.0,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val param1: Double = 0.0,
    val param2: Double = 0.0,
    val status: Int = 0,
    val mot: List<Long> = arrayListOf(1000, 1000, 1000, 1000, 1000, 1000)
)
