package fr.lenny.dronemonitorv2.ui.screens.camera_preview

import android.content.Context
import android.graphics.Color
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.Toast
import androidx.camera.camera2.interop.Camera2CameraInfo
import androidx.camera.camera2.interop.ExperimentalCamera2Interop
import androidx.camera.core.CameraSelector
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.jiangdg.ausbc.CameraClient
import com.jiangdg.ausbc.camera.CameraUvcStrategy
import com.jiangdg.ausbc.camera.bean.CameraRequest
import fr.lenny.dronemonitorv2.R
import fr.lenny.dronemonitorv2.ui.theme.DroneMonitorV2Theme

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPreviewScreen(modifier: Modifier = Modifier) {
    val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }
    val previewView: PreviewView = remember { PreviewView(context) }
    val processCameraProvider = ProcessCameraProvider.getInstance(context).get()
    val selector = selectExternalOrBestCamera(processCameraProvider)

    cameraController.bindToLifecycle(lifecycleOwner)

    if (selector != null)
        cameraController.cameraSelector = selector
    else
        Toast.makeText(context, stringResource(R.string.camera_not_found), Toast.LENGTH_SHORT).show()

    previewView.controller = cameraController

    if(!cameraPermissionState.status.isGranted) {
        Toast.makeText(context, stringResource(R.string.permission_text), Toast.LENGTH_SHORT).show()
    }

    Surface(modifier
        .padding(all = 20.dp)
    ) {
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp)),
            factory = { previewView }
        )
    }


}

@androidx.annotation.OptIn(ExperimentalCamera2Interop::class) @Composable
fun selectExternalOrBestCamera(provider: ProcessCameraProvider):CameraSelector? {
    val cam2Infos = provider.availableCameraInfos.map {
        Camera2CameraInfo.from(it)
    }.sortedByDescending {
        // HARDWARE_LEVEL is Int type, with the order of:
        // LEGACY < LIMITED < FULL < LEVEL_3 < EXTERNAL
        it.getCameraCharacteristic(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)
    }

    return when {
        cam2Infos.isNotEmpty() -> {
            CameraSelector.Builder()
                .addCameraFilter {
                    it.filter { camInfo ->
                        // cam2Infos[0] is either EXTERNAL or best built-in camera
                        val thisCamId = Camera2CameraInfo.from(camInfo).cameraId
                        thisCamId == cam2Infos[0].cameraId
                    }
                }.build()
        }
        else -> null
    }
}
@Composable
@Preview
fun CameraPreviewScreenPreview() {
    DroneMonitorV2Theme {
        CameraPreviewScreen()
    }
}