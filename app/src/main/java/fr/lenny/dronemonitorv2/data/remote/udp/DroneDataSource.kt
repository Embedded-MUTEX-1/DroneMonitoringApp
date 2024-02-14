package fr.lenny.dronemonitorv2.data.remote.udp

import fr.lenny.dronemonitorv2.model.TelemetryConfig
import fr.lenny.dronemonitorv2.model.TelemetryData
import kotlinx.coroutines.flow.MutableStateFlow

interface DroneDataSource {
    val telemetryValues: MutableStateFlow<TelemetryData>
    val telemetryConfig: MutableStateFlow<TelemetryConfig>
    suspend fun init(ipAddress: String)
    suspend fun close()
    suspend fun requestConfig();
    suspend fun sendConfig(data: TelemetryConfig)
    suspend fun process()
}