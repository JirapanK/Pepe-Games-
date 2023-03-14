package com.example.prototypr_2_final.ui.home

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.media.*
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.prototypr_2_final.MainActivity
import com.example.prototypr_2_final.R
import com.example.prototypr_2_final.ui.notifications.NotificationsFragment
import com.example.prototypr_2_final.ui.notifications.game_storyScreen
import java.io.*

class AndroidAudioRecordActivity : Activity() {
    var freqText =
        arrayOf("Slow", "Normal", "Fast", "Fast & Furious LOL")
    var freqset = arrayOf(11025, 16000, 22050, 44100)
    private var adapter: ArrayAdapter<String>? = null
    var spFrequency: Spinner? = null
    var startRec: Button? = null
    var stopRec: Button? = null
    var playBack: Button? = null
    var recording: Boolean? = null
    var back: Button? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        startRec = findViewById<View>(R.id.startrec) as Button
        stopRec = findViewById<View>(R.id.stoprec) as Button
        playBack = findViewById<View>(R.id.playback) as Button
        back = findViewById<View>(R.id.btn_Back) as Button
        startRec!!.setOnClickListener(startRecOnClickListener)
        stopRec!!.setOnClickListener(stopRecOnClickListener)
        playBack!!.setOnClickListener(playBackOnClickListener)
        spFrequency = findViewById<View>(R.id.frequency) as Spinner
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, freqText)
        adapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spFrequency!!.adapter = adapter
        stopRec!!.isEnabled = false

        back!!.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    var startRecOnClickListener = View.OnClickListener {
        val recordThread = Thread {
            recording = true
            startRecord()
        }
        recordThread.start()
        startRec!!.isEnabled = false
        stopRec!!.isEnabled = true
    }
    var stopRecOnClickListener = View.OnClickListener {
        recording = false
        startRec!!.isEnabled = true
        stopRec!!.isEnabled = false
    }
    var playBackOnClickListener = View.OnClickListener { playRecord() }
    private fun startRecord() {
        val file = File(Environment.getExternalStorageDirectory(), "test.pcm")
        val selectedPos = spFrequency!!.selectedItemPosition
        val sampleFreq = freqset[selectedPos]
        val promptStartRecord = """
            startRecord()
            ${file.absolutePath}
            ${spFrequency!!.selectedItem as String}
            """.trimIndent()
        runOnUiThread {
            Toast.makeText(
                this@AndroidAudioRecordActivity,
                promptStartRecord,
                Toast.LENGTH_LONG
            ).show()
        }
        try {
            file.createNewFile()
            val outputStream: OutputStream = FileOutputStream(file)
            val bufferedOutputStream = BufferedOutputStream(outputStream)
            val dataOutputStream = DataOutputStream(bufferedOutputStream)
            val minBufferSize = AudioRecord.getMinBufferSize(
                sampleFreq,
                AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT
            )
            val audioData = ShortArray(minBufferSize)
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.RECORD_AUDIO
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            val audioRecord = AudioRecord(
                MediaRecorder.AudioSource.MIC,
                sampleFreq,
                AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT,
                minBufferSize
            )
            audioRecord.startRecording()
            while (recording!!) {
                val numberOfShort = audioRecord.read(audioData, 0, minBufferSize)
                for (i in 0 until numberOfShort) {
                    dataOutputStream.writeShort(audioData[i].toInt())
                }
            }
            audioRecord.stop()
            dataOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun playRecord() {
        val file = File(Environment.getExternalStorageDirectory(), "test.pcm")
        val shortSizeInBytes = java.lang.Short.SIZE / java.lang.Byte.SIZE
        val bufferSizeInBytes = (file.length() / shortSizeInBytes).toInt()
        val audioData = ShortArray(bufferSizeInBytes)
        try {
            val inputStream: InputStream = FileInputStream(file)
            val bufferedInputStream = BufferedInputStream(inputStream)
            val dataInputStream = DataInputStream(bufferedInputStream)
            var i = 0
            while (dataInputStream.available() > 0) {
                audioData[i] = dataInputStream.readShort()
                i++
            }
            dataInputStream.close()
            val selectedPos = spFrequency!!.selectedItemPosition
            val sampleFreq = freqset[selectedPos]
            val promptPlayRecord = """
                PlayRecord()
                ${file.absolutePath}
                ${spFrequency!!.selectedItem as String}
                """.trimIndent()
            Toast.makeText(
                this@AndroidAudioRecordActivity,
                promptPlayRecord,
                Toast.LENGTH_LONG
            ).show()
            val audioTrack = AudioTrack(
                AudioManager.STREAM_MUSIC,
                sampleFreq,
                AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT,
                bufferSizeInBytes,
                AudioTrack.MODE_STREAM
            )
            audioTrack.play()
            audioTrack.write(audioData, 0, bufferSizeInBytes)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}