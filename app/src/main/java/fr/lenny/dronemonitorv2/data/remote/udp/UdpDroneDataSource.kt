package fr.lenny.dronemonitorv2.data.remote.udp

import fr.lenny.dronemonitorv2.DRONE_UDP_PORT
import fr.lenny.dronemonitorv2.model.TelemetryConfig
import fr.lenny.dronemonitorv2.model.TelemetryData
import fr.lenny.dronemonitorv2.util.JsonToObject
import fr.lenny.dronemonitorv2.util.ObjectToJson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.sync.Mutex
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketTimeoutException
import javax.inject.Inject

class UdpDroneDataSource @Inject constructor(): DroneDataSource {
    override val telemetryValues = MutableStateFlow(TelemetryData())
    override val telemetryConfig = MutableStateFlow(TelemetryConfig())
    private lateinit var udpSocket: DatagramSocket
    private lateinit var ipAddress: InetAddress
    private var mutex = Mutex()
    private var port = DRONE_UDP_PORT
    private var dataType: DataType = DataType.NO_DATA
    private var isSending = false

    override suspend fun init(ipAddress: String) {
        if(mutex.isLocked)
            mutex.unlock()
        udpSocket = DatagramSocket(port)
        this.ipAddress = InetAddress.getByName(ipAddress)
        sendData("OK\n")
    }

    override suspend fun close() {
        udpSocket.close()
    }

    override suspend fun requestConfig() {
        mutex.lock()
        sendData("OK\n")
        mutex.unlock()
    }

    override suspend fun sendConfig(data: TelemetryConfig) {
        mutex.lock()
        sendData(ObjectToJson(data))
        mutex.unlock()
    }

    private suspend fun readData(): String {
        val message = ByteArray(1500)
        val packet = DatagramPacket(message, message.size)
        udpSocket.soTimeout = 3000
        udpSocket.receive(packet)
        return String(message, 0, packet.length)
    }

    private suspend fun sendData(data: String) {
        val packet = DatagramPacket(data.toByteArray(charset = Charsets.UTF_8), data.length, ipAddress, port)
        udpSocket.send(packet)
    }

    override suspend fun process() {
        val jsonText: String?
        mutex.lock()
        jsonText = readData()
        mutex.unlock()

        if(jsonText.contains("isInitConfig")) {
            telemetryConfig.value = JsonToObject(jsonText, TelemetryConfig::class.java)
            dataType = DataType.CONFIG
        } else {
            telemetryValues.value = JsonToObject(jsonText, TelemetryData::class.java)
            dataType = DataType.TELEMETRY
        }
    }
}