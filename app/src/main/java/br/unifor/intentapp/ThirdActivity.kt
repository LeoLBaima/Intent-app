package br.unifor.intentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ThirdActivity : AppCompatActivity(), View.OnClickListener {
    private val SUBJECT = "Intent app"
    private lateinit var tSendEmail: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        tSendEmail = findViewById(R.id.third_button_send);
        tSendEmail.setOnClickListener(this);


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.third_button_send -> {
                val it = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:leobaima50@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT, SUBJECT); //N funciona no gmail, por algum motivo
                }
                if(it.resolveActivity(packageManager) != null){
                    startActivity(it);
                }
            }
        }
    }


}


