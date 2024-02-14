package fr.lenny.dronemonitorv2.data.repository.drone

import fr.lenny.dronemonitorv2.model.TelemetryConfig
import fr.lenny.dronemonitorv2.model.TelemetryData
import kotlinx.coroutines.flow.MutableStateFlow

interface DroneRepository {
    val telemetryValues: MutableStateFlow<TelemetryData>
    val telemetryConfig: MutableStateFlow<TelemetryConfig>
    suspend fun setDroneIpAndPort(ip: String)
    suspend fun closeSocket()
    suspend fun getConfigFromDrone()
    suspend fun sendConfigToDrone(telemetryCommand: TelemetryConfig)
    suspend fun processData()
}