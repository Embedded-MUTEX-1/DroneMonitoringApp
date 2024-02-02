package fr.lenny.dronemonitorv2.data.repository.drone

import fr.lenny.dronemonitorv2.data.model.TelemetryCommand
import fr.lenny.dronemonitorv2.data.model.TelemetryData
import fr.lenny.dronemonitorv2.data.remote.udp.Udp
import fr.lenny.dronemonitorv2.util.*
import javax.inject.Inject

class DroneRepositoryImpl @Inject constructor(
    private val udp: Udp
): DroneRepository {
    override suspend fun setDroneIpAndPort(ip: String, port: Int) {
        udp.init(ip, port)
    }

    override suspend fun getDataFromDroneTelemetry(): TelemetryData {
        return JsonToObject(udp.readData(), TelemetryData::class.java)
    }

    override suspend fun sendConfigToDrone(telemetryCommand: TelemetryCommand) {
        udp.sendData(ObjectToJson(telemetryCommand))
    }

}