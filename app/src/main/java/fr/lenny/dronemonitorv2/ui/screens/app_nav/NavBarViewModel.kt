package fr.lenny.dronemonitorv2.ui.screens.app_nav

import android.app.usage.UsageEvents
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.google.gson.JsonSyntaxException
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.lenny.dronemonitorv2.DRONE_UDP_PORT
import fr.lenny.dronemonitorv2.data.repository.drone.DroneRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class NavBarViewModel @Inject constructor(
    private val droneRepository: DroneRepository
): ViewModel() {
    val _ipAddrText = MutableStateFlow("192.168.1.113")
    val ipAddrText = _ipAddrText.asStateFlow()
    val _buttonState = MutableStateFlow(false)
    val buttonState = _buttonState.asStateFlow()
    var isRunning = false
    var isReceiving = false
    val _event = MutableStateFlow(EventType.NONE)
    val event = _event.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                if(isRunning) {
                    try {
                        isReceiving = true
                        droneRepository.processData()
                        isReceiving = false
                    } catch (e: JsonSyntaxException) {
                        _event.emit(EventType.JSON_ERR)
                        _buttonState.value = false
                        isRunning = false
                        isReceiving = false
                        droneRepository.closeSocket()
                    } catch (e: SocketTimeoutException) {
                        _event.emit(EventType.TIMEOUT_ERR)
                        _buttonState.value = false
                        isRunning = false
                        isReceiving = false
                        droneRepository.closeSocket()
                    }

                }
                delay(100)
            }
        }
    }
    fun updateTextField(text: String) {
        _ipAddrText.value = text
    }

    fun setDroneIpaddr() {
        viewModelScope.launch(Dispatchers.IO) {
            if(!_buttonState.value) {
                droneRepository.setDroneIpAndPort(ipAddrText.value)
                _buttonState.value = true
                isRunning = true
            } else {
                while(isReceiving);
                isRunning = false
                droneRepository.closeSocket()
                _buttonState.value = false
            }
        }
    }
}