package fr.lenny.dronemonitorv2.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@Composable
fun NavButton(icon: ImageVector, iconDescription: String,text: String, modifier: Modifier = Modifier, onClicked: () -> Unit) {
    Button(
        onClick = onClicked,
        contentPadding = PaddingValues(
            start = 4.dp,
            top = 0.dp,
            end = 4.dp,
            bottom = 0.dp,
        ),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface),
        shape = RoundedCornerShape(0),
    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = iconDescription, Modifier.size(30.dp))
            Row(
                modifier = Modifier.fillMaxSize(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun NavButtonPreview() {
    DroneMonitorV2Theme {
        NavButton(icon = Icons.Outlined.Camera,
            iconDescription = "Camera icon",
            text = "Camera",
            modifier = Modifier
                .width(200.dp)
                .height(40.dp), onClicked = { })
    }
}