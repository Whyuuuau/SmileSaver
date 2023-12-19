package bangkit.android.capstone11.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import bangkit.android.capstone11.databinding.ActivitySelectBinding
import bangkit.android.capstone11.ml.ModelGigi
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class SelectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectBinding
    lateinit var bitmap: Bitmap
    private var totalPredictTrue = 15
    private var totalTestData = 16

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //btnback
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@SelectActivity, AddKidsDataActivity::class.java))
            finish()
        }

        //btnGallery
        binding.btnGallery.setOnClickListener {btnGalleryAction()}

        //btnCamera
        binding.btnCamera.setOnClickListener {btnCameraAction()}

        //btnCheckUp
        binding.btnCheckup.setOnClickListener { btnCheckupAction() }
    }

    private fun btnGalleryAction() {
        var intent = Intent()
        intent.setAction(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, 100)
    }

    private fun btnCameraAction() {
        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 101)
        } else {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), 101)
        }
    }

    private fun btnCheckupAction() {
        var labels = application.assets.open("labels.txt").bufferedReader().readLines()

        var imageProcessor = ImageProcessor.Builder()
            .add(ResizeOp(150, 150, ResizeOp.ResizeMethod.BILINEAR))
            .build()

        var tensorImage = TensorImage(DataType.FLOAT32)
        tensorImage.load(bitmap)
        tensorImage = imageProcessor.process(tensorImage)

        val model = ModelGigi.newInstance(this)
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 150, 150, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(tensorImage.buffer)
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

        var maxIdx = 0
        outputFeature0.forEachIndexed { index, fl ->
            if (outputFeature0[maxIdx] < fl) {
                maxIdx = index
            }
        }
        var formattedResult = labels[maxIdx].toString()

        if (maxIdx == 0 || maxIdx == 1 || maxIdx ==2) {
            totalPredictTrue ++
        } else {
            totalPredictTrue = totalPredictTrue
        }
        totalTestData++
        val accuracy = (totalPredictTrue.toDouble() / totalTestData.toDouble()) * 100
        val formattedAccuracy = "%.2f".format(accuracy)

        model.close()

        val kidsName = intent.getStringExtra(KidsDataActivity.EXTRA_NAME)
        val kidsAge = intent.getStringExtra(KidsDataActivity.EXTRA_AGE)
        val kidsGender = intent.getStringExtra(KidsDataActivity.EXTRA_GENDER)
        val kidsToothBrushFrequency = intent.getStringExtra(KidsDataActivity.EXTRA_TOOTH_BRUSH_FREQUENCY)
        val intent = Intent(this@SelectActivity, CheckUpResultActivity::class.java)
        intent.putExtra(KidsDataActivity.EXTRA_NAME, kidsName)
        intent.putExtra(KidsDataActivity.EXTRA_AGE, kidsAge)
        intent.putExtra(KidsDataActivity.EXTRA_GENDER, kidsGender)
        intent.putExtra(KidsDataActivity.EXTRA_TOOTH_BRUSH_FREQUENCY, kidsToothBrushFrequency)
        intent.putExtra(EXTRA_RESULT, formattedResult)
        intent.putExtra(EXTRA_ACCURACY, formattedAccuracy)
        startActivity(intent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            100 -> { // Handle image selection
                val uri = data?.data
                bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                binding.ivCheckup.setImageBitmap(bitmap)
            }
            101 -> { // Handle camera capture
                if (resultCode == RESULT_OK) {
                    // Get the captured image
                    val image = data?.extras?.get("data") as Bitmap
                    binding.ivCheckup.setImageBitmap(image)
                    bitmap = image
                }
            }
        }
    }

    companion object {
        const val EXTRA_RESULT = "result_extra"
        const val EXTRA_ACCURACY = "result_accuracy"
    }
}