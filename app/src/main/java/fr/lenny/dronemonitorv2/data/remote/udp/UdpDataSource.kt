package fr.lenny.dronemonitorv2.data.remote.udp

import android.util.Log
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import javax.inject.Inject

class UdpDataSource @Inject constructor(): Udp {
    lateinit var udpSocket: DatagramSocket
    lateinit var ipAddress: InetAddress
    var port: Int = 0
    override suspend fun init(ipAddress: String, port: Int){
        udpSocket = DatagramSocket(port)
        this.port = port
        this.ipAddress = InetAddress.getByName(ipAddress)
    }

    override suspend fun readData(): String {
        val message = ByteArray(1024)
        val packet = DatagramPacket(message, message.size)

        udpSocket.soTimeout = 1000
        udpSocket.receive(packet)

        return String(message, 0, packet.length)
    }

    override suspend fun sendData(data: String) {
        val packet = DatagramPacket(data.toByteArray(charset = Charsets.UTF_8), data.length, ipAddress, port)
        udpSocket.send(packet)
    }
}