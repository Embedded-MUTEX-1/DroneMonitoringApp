package fr.lenny.dronemonitorv2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.lenny.dronemonitorv2.data.remote.udp.DroneDataSource
import fr.lenny.dronemonitorv2.data.remote.udp.UdpDroneDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {
    @Singleton
    @Binds
    abstract fun bindUdpDataSource(dataSource: UdpDroneDataSource): DroneDataSource
}