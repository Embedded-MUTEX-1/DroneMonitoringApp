package fr.lenny.dronemonitorv2.data.repository.drone

import fr.lenny.dronemonitorv2.model.TelemetryConfig
import fr.lenny.dronemonitorv2.model.TelemetryData
import fr.lenny.dronemonitorv2.data.remote.udp.DroneDataSource
import fr.lenny.dronemonitorv2.util.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.sync.Mutex
import javax.inject.Inject

class DroneRepositoryImpl @Inject constructor(
    private val droneDataSource: DroneDataSource
): DroneRepository {
    override val telemetryValues = droneDataSource.telemetryValues
    override val telemetryConfig = droneDataSource.telemetryConfig

    override suspend fun setDroneIpAndPort(ip: String) {
        droneDataSource.init(ip)
    }

    override suspend fun closeSocket() {
        droneDataSource.close()
    }

    override suspend fun getConfigFromDrone() {
        droneDataSource.requestConfig()
    }

    override suspend fun sendConfigToDrone(telemetryCommand: TelemetryConfig) {
        droneDataSource.sendConfig(telemetryCommand)
    }

    override suspend fun processData() {
        droneDataSource.process()
    }

}