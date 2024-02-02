package fr.lenny.dronemonitorv2.data.repository.drone

import fr.lenny.dronemonitorv2.data.model.TelemetryCommand
import fr.lenny.dronemonitorv2.data.model.TelemetryData

interface DroneRepository {
    suspend fun setDroneIpAndPort(ip: String, port: Int)
    suspend fun getDataFromDroneTelemetry(): TelemetryData
    suspend fun sendConfigToDrone(telemetryCommand: TelemetryCommand)
}