package br.unifor.intentapp

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mFirstButton: Button;
    private lateinit var mSecondButton: Button;
    private lateinit var mThirdButton: Button;

    private val CAMERA_REQUEST = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mFirstButton = findViewById(R.id.main_button_first);
        mFirstButton.setOnClickListener(this)

        mSecondButton = findViewById(R.id.main_button_second);
        mSecondButton.setOnClickListener(this)

        mThirdButton = findViewById(R.id.main_button_third);
        mThirdButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {

            R.id.main_button_first -> {
                val it = Intent(this, FirstActivity::class.java);
                startActivity(it);
            }
            R.id.main_button_second -> {
                val it = Intent(this, SecondActivity::class.java);
                startActivity(it);
            }
            R.id.main_button_third -> {
                val it = Intent(this, ThirdActivity::class.java);
                startActivity(it);
            }

        }
    }



}