package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.mqtt.MqttClientHelper
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var password: EditText? = null
//    private var next: Button? = null

    //Simple password verification mechanism, to be improved if time allows
    //not used
    fun passwordValidation(test: EditText?) {
        if (test != null) {
            if (test.equals("blueflower"))
                true
            else
                false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        // initialize 'num msgs received' field in the view

        this.password = findViewById(R.id.password)
//        next =findViewById(R.id.enter_button)


        enter_button.setOnClickListener{
            val intent = Intent (this, question_1::class.java)
            startActivity(intent)
        }
        
        /*while (true) {
            Toast.makeText(
                applicationContext,
                "Wrong passphrase, please try again.",
                Toast.LENGTH_LONG
            ).show()
        }*/


        // sub fab button
        /*fab2.setOnClickListener { view ->
            var snackbarMsg : String
            try {
                mqttClient.subscribe(TOPIC)
                snackbarMsg = "Subscribed to topic '$TOPIC'!"
            } catch (ex: MqttException) {
                snackbarMsg = "Error subscribing to topic: $TOPIC!"
            }
            Snackbar.make(view, snackbarMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

    }
}

