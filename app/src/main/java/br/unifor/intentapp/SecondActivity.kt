package br.unifor.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

 class SecondActivity : AppCompatActivity(), View.OnClickListener, SeekBar.OnSeekBarChangeListener {


    private val MESSAGE = "Criado pelo app intent"
    private lateinit var sCreateAlarm: Button;
    private lateinit var sHourBar: SeekBar;
    private lateinit var sMinutesBar: SeekBar;
    private lateinit var sHourText: TextView;
    private lateinit var sMinutesText: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sCreateAlarm = findViewById(R.id.second_button_createalarm);
        sCreateAlarm.setOnClickListener(this);

        sHourBar = findViewById(R.id.second_seekbar_hour);
        sHourBar.setOnSeekBarChangeListener(this);
        sHourBar.progress = 0;

        sMinutesBar = findViewById(R.id.second_seekbar_minutes);
        sMinutesBar.setOnSeekBarChangeListener(this);
        sMinutesBar.progress = 0;

        sHourText = findViewById(R.id.second_textview_hour);
        sMinutesText = findViewById(R.id.second_textview_minutes);

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if(fromUser){
            var Hour = sHourBar.progress;
            var Minutes = sMinutesBar.progress;

            sHourText.text = "$Hour"
            sMinutesText.text = "$Minutes"

        }
    }

     override fun onStartTrackingTouch(seekBar: SeekBar?) {
         when(seekBar?.id) {
             R.id.second_seekbar_hour -> {
                 Log.i("App", "Start touch1!")
             }
         }
         when(seekBar?.id) {
             R.id.second_seekbar_minutes -> {
                 Log.i("App", "Start touch2!")
             }
         }
     }

     override fun onStopTrackingTouch(seekBar: SeekBar?) {
         when(seekBar?.id) {
             R.id.second_seekbar_hour -> {
                 Log.i("App", "Stop touch1!")
             }
         }
         when(seekBar?.id) {
             R.id.second_seekbar_minutes -> {
                 Log.i("App", "Stop touch2!")
             }
         }
     }


     override fun onClick(v: View?){
        when(v?.id){
            R.id.second_button_createalarm -> {
                    val it = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                        putExtra(AlarmClock.EXTRA_MESSAGE, MESSAGE);
                        putExtra(AlarmClock.EXTRA_HOUR, sHourBar.progress);
                        putExtra(AlarmClock.EXTRA_MINUTES, sMinutesBar.progress);
                    }

                    if(it.resolveActivity(packageManager) != null){
                        startActivity(it)
                    }

            }
        }
    }

}


