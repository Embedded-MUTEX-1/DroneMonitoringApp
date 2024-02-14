package fr.lenny.dronemonitorv2.ui.screens.monitoring

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.lenny.dronemonitorv2.MAX_DATASET_LEN
import fr.lenny.dronemonitorv2.model.TelemetryData
import fr.lenny.dronemonitorv2.data.repository.drone.DroneRepository
import fr.lenny.dronemonitorv2.model.TelemetryValues
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MonitoringViewModel @Inject constructor(
    private val droneRepository: DroneRepository
): ViewModel() {
    private val _telemetryValues = MutableStateFlow(TelemetryValues())
    val telemetryValues get() = _telemetryValues.asStateFlow()

    private var rollListOfEntry: MutableList<Entry> = mutableListOf()
    private var pitchListOfEntry: MutableList<Entry> = mutableListOf()
    private var yawListOfEntry: MutableList<Entry> = mutableListOf()

    private var gyroRollListOfEntry: MutableList<Entry> = mutableListOf()
    private var gyroPitchListOfEntry: MutableList<Entry> = mutableListOf()
    private var gyroYawListOfEntry: MutableList<Entry> = mutableListOf()

    private var accRollListOfEntry: MutableList<Entry> = mutableListOf()
    private var accPitchListOfEntry: MutableList<Entry> = mutableListOf()
    private var accYawListOfEntry: MutableList<Entry> = mutableListOf()

    private var motor1ListOfEntry: MutableList<Entry> = mutableListOf()
    private var motor2ListOfEntry: MutableList<Entry> = mutableListOf()
    private var motor3ListOfEntry: MutableList<Entry> = mutableListOf()
    private var motor4ListOfEntry: MutableList<Entry> = mutableListOf()
    private var motor5ListOfEntry: MutableList<Entry> = mutableListOf()
    private var motor6ListOfEntry: MutableList<Entry> = mutableListOf()

    private var minX = 0f
    private var maxX = MAX_DATASET_LEN - 1f
    private var isFirstValues = true
    private var xValue = 0
    init {
        viewModelScope.launch(Dispatchers.IO) {

            droneRepository.telemetryValues.drop(1).collect {

                if(xValue > MAX_DATASET_LEN) {
                    minX = (xValue - MAX_DATASET_LEN).toFloat()
                    maxX = xValue.toFloat() - 1
                }

                if(rollListOfEntry.size > MAX_DATASET_LEN) {
                    rollListOfEntry.removeFirst()
                    pitchListOfEntry.removeFirst()
                    yawListOfEntry.removeFirst()

                    gyroRollListOfEntry.removeFirst()
                    gyroPitchListOfEntry.removeFirst()
                    gyroYawListOfEntry.removeFirst()

                    accRollListOfEntry.removeFirst()
                    accPitchListOfEntry.removeFirst()
                    accYawListOfEntry.removeFirst()

                    motor1ListOfEntry.removeFirst()
                    motor2ListOfEntry.removeFirst()
                    motor3ListOfEntry.removeFirst()
                    motor4ListOfEntry.removeFirst()
                }

                rollListOfEntry.add(Entry(xValue.toFloat(), it.roll.toFloat()))
                pitchListOfEntry.add(Entry(xValue.toFloat(), it.pitch.toFloat()))
                yawListOfEntry.add(Entry(xValue.toFloat(), it.yaw.toFloat()))

                gyroRollListOfEntry.add(Entry(xValue.toFloat(), it.gyroRoll.toFloat()))
                gyroPitchListOfEntry.add(Entry(xValue.toFloat(), it.gyroPitch.toFloat()))
                gyroYawListOfEntry.add(Entry(xValue.toFloat(), it.gyroYaw.toFloat()))

                accRollListOfEntry.add(Entry(xValue.toFloat(), it.accRoll.toFloat()))
                accPitchListOfEntry.add(Entry(xValue.toFloat(), it.accPitch.toFloat()))
                accYawListOfEntry.add(Entry(xValue.toFloat(), it.accYaw.toFloat()))


                motor1ListOfEntry.add(Entry(xValue.toFloat(), it.mot[0].toFloat()))
                motor2ListOfEntry.add(Entry(xValue.toFloat(), it.mot[1].toFloat()))
                motor3ListOfEntry.add(Entry(xValue.toFloat(), it.mot[2].toFloat()))
                motor4ListOfEntry.add(Entry(xValue.toFloat(), it.mot[3].toFloat()))

                _telemetryValues.value = TelemetryValues(
                    it,
                    arrayListOf(
                        LineDataSet(rollListOfEntry, "Roll"),
                        LineDataSet(pitchListOfEntry, "Pitch"),
                        LineDataSet(yawListOfEntry, "Yaw")
                    ),
                    arrayListOf(
                        LineDataSet(gyroRollListOfEntry, "gyroRoll"),
                        LineDataSet(gyroPitchListOfEntry, "gyroPitch"),
                        LineDataSet(gyroYawListOfEntry, "gyroYaw")
                    ),
                    arrayListOf(
                        LineDataSet(accRollListOfEntry, "accRoll"),
                        LineDataSet(accPitchListOfEntry, "accPitch"),
                        LineDataSet(accYawListOfEntry, "accYaw")
                    ),
                    arrayListOf(
                        LineDataSet(motor1ListOfEntry, "mot1"),
                        LineDataSet(motor2ListOfEntry, "mot2"),
                        LineDataSet(motor3ListOfEntry, "mot3"),
                        LineDataSet(motor4ListOfEntry, "mot4")
                    ),
                    minX,
                    maxX)

                xValue++

                isFirstValues = false
            }
        }
    }
}