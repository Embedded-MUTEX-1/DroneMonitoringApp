package fr.lenny.dronemonitorv2.ui.screens.app_nav

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.lenny.dronemonitorv2.data.repository.drone.DroneRepository
import javax.inject.Inject

@HiltViewModel
class NavBarViewModel @Inject constructor(
    private val droneRepository: DroneRepository
): ViewModel() {

}