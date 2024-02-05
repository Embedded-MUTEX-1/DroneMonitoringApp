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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fr.lenny.dronemonitorv2.R
import fr.lenny.dronemonitorv2.ui.composables.ConfigTextField

@Composable
fun ConfigSreen(modifier: Modifier = Modifier) {
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
                        configValue = "1000",
                        onValueChanged = { },
                        modifier = Modifier.align(Alignment.CenterStart)
                    )

                    ConfigTextField(
                        configValue = "1000",
                        onValueChanged = { },
                        modifier = Modifier.align(Alignment.TopStart)
                    )

                    ConfigTextField(
                        configValue = "1000",
                        onValueChanged = { },
                        modifier = Modifier.align(Alignment.TopEnd)
                    )

                    ConfigTextField(
                        configValue = "1000",
                        onValueChanged = { },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )

                    ConfigTextField(
                        configValue = "1000",
                        onValueChanged = { },
                        modifier = Modifier.align(Alignment.BottomEnd)
                    )

                    ConfigTextField(
                        configValue = "1000",
                        onValueChanged = { },
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
                    ConfigTextField(configValue = "1.0", onValueChanged = {  })
                    ConfigTextField(configValue = "1.0", onValueChanged = {  })
                    ConfigTextField(configValue = "1.0", onValueChanged = {  })
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
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    Text(text = "Param1", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
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
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Yaw", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Altitude", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Navigation", modifier.width(100.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                    ConfigTextField(configValue = "0.3", onValueChanged = { })
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(text = "DISARMED")
        }
    }
}