package com.example.arnab_gupta.qr

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import net.glxn.qrgen.android.QRCode

class MainActivity : AppCompatActivity() {
    private var mEditCode: EditText? = null
    private var mButtonCreate: Button? = null
    private var mImagePreview: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditCode = findViewById<EditText>(R.id.editCode)
        mButtonCreate = findViewById<Button>(R.id.buttonCreate)
        mImagePreview = findViewById<ImageView>(R.id.imagePreview)

        (mButtonCreate as Button).setOnClickListener {
            val textx = (mEditCode as EditText).text.toString()

            if (textx.isEmpty()) {
            //    Toast.makeText(this, getString(R.string.textx),
            //            Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            /*
            * Generate bitmap from the text provided,
            * The QR code can be saved using other methods such as stream(), file(), to() etc.
            * */
            val bitmap = QRCode.from(textx).withSize(1000, 1000).bitmap()
            (mImagePreview as ImageView).setImageBitmap(bitmap)
            hideKeyboard()
        }
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}