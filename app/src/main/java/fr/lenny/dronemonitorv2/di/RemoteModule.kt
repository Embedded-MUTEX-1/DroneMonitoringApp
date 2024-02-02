package fr.lenny.dronemonitorv2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.lenny.dronemonitorv2.data.remote.udp.Udp
import fr.lenny.dronemonitorv2.data.remote.udp.UdpDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {
    @Singleton
    @Binds
    abstract fun bindUdpDataSource(udp: UdpDataSource): Udp
}