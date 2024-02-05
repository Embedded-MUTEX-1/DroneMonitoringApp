package fr.lenny.dronemonitorv2.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigTextField(modifier: Modifier = Modifier, configValue: String, onValueChanged: (newValue: String) -> Unit) {
    Box(modifier = modifier
        .width(100.dp)
        .height(35.dp)
        .background(MaterialTheme.colorScheme.background, RoundedCornerShape(50.dp))
        .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(50.dp))
        .clip(RoundedCornerShape(50.dp)),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = configValue,
            onValueChange = onValueChanged,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
        )
    }
}

@Preview
@Composable
fun ConfigTextFieldPreview() {
    DroneMonitorV2Theme {
        ConfigTextField(configValue = "1.0", onValueChanged = { })
    }
}