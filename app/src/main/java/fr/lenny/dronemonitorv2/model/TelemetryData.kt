package fr.lenny.dronemonitorv2.model

import java.sql.Timestamp

data class TelemetryData(
    val roll: Double = 0.0,
    val pitch: Double = 0.0,
    val yaw: Double = 0.0,
    val gyroRoll: Double = 0.0,
    val gyroPitch: Double = 0.0,
    val gyroYaw: Double = 0.0,
    val accRoll: Double = 0.0,
    val accPitch: Double = 0.0,
    val accYaw: Double = 0.0,
    val proll: Double = 0.0,
    val ppitch: Double = 0.0,
    val pyaw: Long = 0,
    val iroll: Double = 0.0,
    val ipitch: Double = 0.0,
    val iyaw: Long = 0,
    val droll: Long = 0,
    val dpitch: Long = 0,
    val dyaw: Long = 0,
    val pAlt: Double = 0.0,
    val iAlt: Double = 0.0,
    val dAlt: Double = 0.0,
    val pNav: Double = 0.0,
    val iNav: Double = 0.0,
    val dNav: Double = 0.0,
    val param1: Double = 0.0,
    val param2: Double = 0.0,
    val loopTime: Long = 0,
    val alt: Long = 0,
    val vBat: Double = 0.0,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val status: Int = 0,
    val timestamp: Int = 0,
    val mot: List<Long> = arrayListOf(1000, 1000, 1000, 1000, 1000, 1000),
    val ch: List<Long> = arrayListOf(1000, 1000, 1000, 1000, 1000, 1000)
)
