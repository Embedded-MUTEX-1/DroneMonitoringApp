package fr.lenny.dronemonitorv2.ui.screens.config

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import fr.lenny.dronemonitorv2.R
import fr.lenny.dronemonitorv2.ui.composables.ConfigTextField
import fr.lenny.dronemonitorv2.ui.screens.app_nav.NavBarViewModel

@Composable
fun ConfigSreen(
    viewModel: ConfigViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val textFieldValues = viewModel.textFieldValues.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier.size(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = stringResource(R.string.drone_motors),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxSize()
                            .padding(25.dp)
                    )

                    ConfigTextField(
                        configValue = "NA",
                        onValueChanged = { },
                        modifier = Modifier.align(Alignment.CenterStart)
                    )

                    ConfigTextField(
                        configValue = textFieldValues.value[ConfigValueName.MOT1.ordinal],
                        onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.MOT1.ordinal) },
                        modifier = Modifier.align(Alignment.TopStart)
                    )

                    ConfigTextField(
                        configValue = textFieldValues.value[ConfigValueName.MOT2.ordinal],
                        onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.MOT2.ordinal) },
                        modifier = Modifier.align(Alignment.TopEnd)
                    )

                    ConfigTextField(
                        configValue = "NA",
                        onValueChanged = { },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )

                    ConfigTextField(
                        configValue = textFieldValues.value[ConfigValueName.MOT4.ordinal],
                        onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.MOT4.ordinal) },
                        modifier = Modifier.align(Alignment.BottomEnd)
                    )

                    ConfigTextField(
                        configValue = textFieldValues.value[ConfigValueName.MOT3.ordinal],
                        onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.MOT3.ordinal) },
                        modifier = Modifier.align(Alignment.BottomStart)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier.fillMaxWidth(),
                    Arrangement.SpaceAround
                ) {
                    Text(text = "Roll", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Text(text = "Pitch", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Text(text = "Yaw", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier.fillMaxWidth(),
                    Arrangement.SpaceAround
                ) {
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.ROLL.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.ROLL.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.PITCH.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.PITCH.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.YAW.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.YAW.ordinal) })
                }
            }

            Column(
                Modifier.weight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Param1", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.PARAM1.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.PARAM1.ordinal) })
                    Text(text = "Param2", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.PARAM2.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.PARAM2.ordinal) })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(100.dp))
                    Text(text = "P", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Text(text = "I", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Text(text = "D", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Roll & Pitch", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.P_ROLL_PITCH.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.P_ROLL_PITCH.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.I_ROLL_PITCH.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.I_ROLL_PITCH.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.D_ROLL_PITCH.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.D_ROLL_PITCH.ordinal) })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Yaw", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.P_YAW.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.P_YAW.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.I_YAW.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.I_YAW.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.D_YAW.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.D_YAW.ordinal) })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Altitude", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.P_ALT.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.P_ALT.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.I_ALT.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.I_ALT.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.D_ALT.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.D_ALT.ordinal) })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Navigation", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.P_NAV.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.P_NAV.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.I_NAV.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.I_NAV.ordinal) })
                    ConfigTextField(configValue = textFieldValues.value[ConfigValueName.D_NAV.ordinal], onValueChanged = { newText -> viewModel.updateTextFields(newText, ConfigValueName.D_NAV.ordinal) })
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.setDisarmedMode() }) {
                Text(text = "DISARM")
            }

            Button(onClick = { viewModel.setManualMode() }) {
                Text(text = "MANUAL")
            }

            Button(onClick = { viewModel.setAutoMode() }) {
                Text(text = "AUTO")
            }

            Button(onClick = { viewModel.sendConfig() }) {
                Text(text = "CONFIG")
            }

            Button(onClick = { viewModel.getConfig() }) {
                Text(text = "GET CONFIG")
            }
        }
    }
}