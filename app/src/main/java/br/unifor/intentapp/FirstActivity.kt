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

class FirstActivity : AppCompatActivity(), View.OnClickListener {

    private val CAMERA_REQUEST = 1;

    private lateinit var fPhotoView: ImageView;
    private lateinit var fPhotoCapture: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        fPhotoView = findViewById(R.id.first_imageview_photo);

        fPhotoCapture = findViewById(R.id.first_button_capture);
        fPhotoCapture.setOnClickListener(this)
    }

     override fun onClick(v: View?) {
        when (v?.id){
            R.id.first_button_capture -> {
                val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                if(it.resolveActivity(packageManager) != null) {
                    startActivityForResult(it, CAMERA_REQUEST)
                }
                else {
                    Toast.makeText(
                            this,
                            "não foi possível atender a esta solicitação",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);

        when(requestCode) {
            CAMERA_REQUEST -> {
                if(resultCode == RESULT_OK) {
                    val image: Bitmap? = data?.getParcelableExtra("data");
                    fPhotoView.setImageBitmap(image);
                }
            }
        }


    }

}