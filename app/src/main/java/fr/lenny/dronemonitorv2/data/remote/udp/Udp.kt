package fr.lenny.dronemonitorv2.data.remote.udp

interface Udp {
    suspend fun init(ipAddress: String, port: Int)
    suspend fun readData(): String
    suspend fun sendData(data: String)
}