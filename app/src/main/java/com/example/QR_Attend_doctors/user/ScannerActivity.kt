package com.example.QR_Attend_doctors.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.QR_Attend_doctors.R

class ScannerActivity : AppCompatActivity() {
    lateinit var coedScanner: CodeScanner
    lateinit var codeScannerView: CodeScannerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)
        codeScannerView = findViewById<CodeScannerView>(R.id.scan_block)
    codeScanner()
    }
    private fun codeScanner(){
        coedScanner = CodeScanner(this,codeScannerView)
        coedScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats= CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode= ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false
            decodeCallback = DecodeCallback {
                runOnUiThread{
                }
            }
            errorCallback = ErrorCallback {
                runOnUiThread{
                    Log.e("scannerActivitiy","error in scanActivity ${it.message} ")
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        coedScanner.startPreview()
    }

    override fun onPause() {
        coedScanner.releaseResources()
        super.onPause()
    }


}