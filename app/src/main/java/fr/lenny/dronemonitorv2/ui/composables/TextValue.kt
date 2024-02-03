package fr.lenny.dronemonitorv2.ui.composables

import android.graphics.fonts.FontStyle
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun TextValue(modifier: Modifier = Modifier, name: String, value: String) {
    Row(
        modifier = modifier
            .height(35.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background, RoundedCornerShape(50.dp))
            .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(50.dp))
            .clip(RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = value, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun TextValuePreview() {
    DroneMonitorV2Theme {
        TextValue(
            Modifier
                .width(250.dp)
                .background(MaterialTheme.colorScheme.background),
            name = "Longitude", value = "1000"
        )
    }
}