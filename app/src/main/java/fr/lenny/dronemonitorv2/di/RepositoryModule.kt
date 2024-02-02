package fr.lenny.dronemonitorv2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.lenny.dronemonitorv2.data.repository.drone.DroneRepository
import fr.lenny.dronemonitorv2.data.repository.drone.DroneRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindDroneRepository(repository: DroneRepositoryImpl): DroneRepository
}