package fr.lenny.dronemonitorv2.ui.screens.config

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.lenny.dronemonitorv2.data.repository.drone.DroneRepository
import fr.lenny.dronemonitorv2.model.TelemetryConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(
    private val droneRepository: DroneRepository
): ViewModel() {
    private val _textFieldValues = MutableStateFlow(Array(ConfigValueName.values().size){""})
    val textFieldValues = _textFieldValues.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            droneRepository.telemetryConfig.collect { telemetry ->
                var copy = _textFieldValues.value.copyOf()

                copy[ConfigValueName.ROLL.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.roll)
                copy[ConfigValueName.PITCH.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.pitch)
                copy[ConfigValueName.YAW.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.yaw)

                copy[ConfigValueName.PARAM1.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.param1)
                copy[ConfigValueName.PARAM2.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.param2)

                copy[ConfigValueName.P_ROLL_PITCH.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.proll)
                copy[ConfigValueName.I_ROLL_PITCH.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.iroll)
                copy[ConfigValueName.D_ROLL_PITCH.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.droll)

                copy[ConfigValueName.P_YAW.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.pyaw)
                copy[ConfigValueName.I_YAW.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.iyaw)
                copy[ConfigValueName.D_YAW.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.dyaw)

                copy[ConfigValueName.P_ALT.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.pAlt)
                copy[ConfigValueName.I_ALT.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.iAlt)
                copy[ConfigValueName.D_ALT.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.dAlt)

                copy[ConfigValueName.P_NAV.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.pnav)
                copy[ConfigValueName.I_NAV.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.inav)
                copy[ConfigValueName.D_NAV.ordinal] = String.format(Locale.ENGLISH,"%.5f" ,telemetry.dnav)

                copy[ConfigValueName.MOT1.ordinal] = (1000).toString()
                copy[ConfigValueName.MOT2.ordinal] = (1000).toString()
                copy[ConfigValueName.MOT3.ordinal] = (1000).toString()
                copy[ConfigValueName.MOT4.ordinal] = (1000).toString()

                _textFieldValues.value = copy
            }
        }
    }
    fun updateTextFields(text: String, num: Int) {
        var copy = _textFieldValues.value.copyOf()
        copy[num] = text
        _textFieldValues.value = copy
    }

    fun setDisarmedMode() {
        viewModelScope.launch(Dispatchers.IO) {
            droneRepository.sendConfigToDrone(
                TelemetryConfig(
                    0,
                    _textFieldValues.value[ConfigValueName.ROLL.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_NAV.ordinal].toDouble(),
                    0.0,
                    0.0,
                    _textFieldValues.value[ConfigValueName.PARAM1.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PARAM2.ordinal].toDouble(),
                    0, // DISARMED
                    listOf(1000, 1000, 1000, 1000)
                )
            )
        }
    }

    fun setManualMode() {
        viewModelScope.launch(Dispatchers.IO) {
            droneRepository.sendConfigToDrone(
                TelemetryConfig(
                    0,
                    _textFieldValues.value[ConfigValueName.ROLL.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_NAV.ordinal].toDouble(),
                    0.0,
                    0.0,
                    _textFieldValues.value[ConfigValueName.PARAM1.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PARAM2.ordinal].toDouble(),
                    1, // MANUAL
                    listOf(
                        _textFieldValues.value[ConfigValueName.MOT1.ordinal].toLong(),
                        _textFieldValues.value[ConfigValueName.MOT2.ordinal].toLong(),
                        _textFieldValues.value[ConfigValueName.MOT3.ordinal].toLong(),
                        _textFieldValues.value[ConfigValueName.MOT4.ordinal].toLong()
                    )
                )
            )
        }
    }

    fun setAutoMode() {
        viewModelScope.launch(Dispatchers.IO) {
            droneRepository.sendConfigToDrone(
                TelemetryConfig(
                    0,
                    _textFieldValues.value[ConfigValueName.ROLL.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_NAV.ordinal].toDouble(),
                    0.0,
                    0.0,
                    _textFieldValues.value[ConfigValueName.PARAM1.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PARAM2.ordinal].toDouble(),
                    2, // ARMED
                    listOf(1000, 1000, 1000, 1000)
                )
            )
        }
    }

    fun sendConfig() {
        viewModelScope.launch(Dispatchers.IO) {
            droneRepository.sendConfigToDrone(
                TelemetryConfig(
                    0,
                    _textFieldValues.value[ConfigValueName.ROLL.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_YAW.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_ALT.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.P_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.I_NAV.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.D_NAV.ordinal].toDouble(),
                    0.0,
                    0.0,
                    _textFieldValues.value[ConfigValueName.PARAM1.ordinal].toDouble(),
                    _textFieldValues.value[ConfigValueName.PARAM2.ordinal].toDouble(),
                    0, // DISARMED
                    listOf(1000, 1000, 1000, 1000)
                )
            )
        }
    }

    fun getConfig() {
        viewModelScope.launch(Dispatchers.IO) {
            droneRepository.getConfigFromDrone()
        }
    }
}