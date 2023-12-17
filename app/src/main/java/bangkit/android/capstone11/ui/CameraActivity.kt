package bangkit.android.capstone11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import bangkit.android.capstone11.R
import bangkit.android.capstone11.databinding.ActivityCameraBinding
import bangkit.android.capstone11.ui.user_utils.createFile
import bangkit.android.capstone11.ui.user_utils.showToast
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

//class CameraActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityCameraBinding
//    private lateinit var cameraExecutor: ExecutorService
//    private var cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//    private var imageCapture: ImageCapture? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityCameraBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        cameraExecutor = Executors.newSingleThreadExecutor()
//
//        setAction()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        startCamera()
//    }
//
//    private fun setAction() {
//        binding.exit.setOnClickListener {
//            startActivity(Intent(this, SelectActivity::class.java))
//            finish()
//        }
//        binding.captureImage.setOnClickListener {
//            takePhoto()
//        }
//        binding.switchCamera.setOnClickListener {
//            switchCamera()
//        }
//    }
//
//    private fun startCamera() {
//        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
//
//        cameraProviderFuture.addListener({
//            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
//            val preview = Preview.Builder()
//                .build()
//                .also {
//                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
//                }
//
//            imageCapture = ImageCapture.Builder().build()
//
//            try {
//                cameraProvider.unbindAll()
//                cameraProvider.bindToLifecycle(
//                    this,
//                    cameraSelector,
//                    preview,
//                    imageCapture
//                )
//            } catch (e: Exception) {
//                showToast("Failed to Show Camera")
//            }
//        }, ContextCompat.getMainExecutor(this))
//    }
//
//    private fun switchCamera() {
//        cameraSelector =
//            if (cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) CameraSelector.DEFAULT_FRONT_CAMERA
//            else CameraSelector.DEFAULT_BACK_CAMERA
//        startCamera()
//    }
//
//    private fun takePhoto() {
//        val imageCapture = imageCapture ?: return
//        val photoFile = createFile(application)
//        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
//
//        imageCapture.takePicture(
//            outputOptions,
//            ContextCompat.getMainExecutor(this),
//            object : ImageCapture.OnImageSavedCallback {
//                override fun onError(exc: ImageCaptureException) {
//                    showToast("Failed To Take Image.")
//                }
//                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
//                    val intent = Intent()
//                    intent.putExtra("picture", photoFile)
//                    intent.putExtra(
//                        "isBackCamera",
//                        cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA
//                    )
//                    setResult(SelectActivity.CAMERA_X_RESULT, intent)
//                    finish()
//                }
//            }
//        )
//    }
//
//    @Deprecated("Deprecated in Java")
//    override fun onBackPressed() {
//        super.onBackPressed()
//        startActivity(Intent(this, SelectActivity::class.java))
//    }
//
//}