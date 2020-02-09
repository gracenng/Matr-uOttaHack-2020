package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.mqtt.MqttClientHelper
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_question_2.*
import kotlinx.android.synthetic.main.content_question_2.*
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import java.util.*
import kotlin.concurrent.schedule
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

class question_2 : AppCompatActivity() {
    companion object {
        const val TAG = "question2Activity"

        // Define these values in res/values/strings.xml
        const val TOPIC = "Answers"
        var MSG="9"
    }

    val mqttClient by lazy {
        MqttClientHelper(this)
    }
    var data: EditText? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_2)
        setMqttCallBack()
        setSupportActionBar(toolbar)
        data = findViewById(R.id.editText)

        EditText1.setText("")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // pub fab button
        fab.setOnClickListener { view ->
            var snackbarMsg : String
            try {
//                Log.(question_2.TOPIC)
//                Log.println(question_2.MSG)
                mqttClient.publish("Answers", "9")
                snackbarMsg = "Submitted!"
            } catch (ex: MqttException) {
                snackbarMsg = "Error publishing to topic: ${question_2.TOPIC}!"
            }
            Snackbar.make(view, snackbarMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        Timer("CheckMqttConnection", false).schedule(3000) {
            if (!mqttClient.isConnected()) {
                Snackbar.make(EditText1, "Failed to connect to: '$SOLACE_MQTT_HOST' within 3 seconds", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Action", null).show()
            }
        }
    }

    private fun setMqttCallBack() {
        mqttClient.setCallback(object : MqttCallbackExtended {
            override fun connectComplete(b: Boolean, s: String) {
                Log.w("Debug", "Connected to host '$SOLACE_MQTT_HOST'.")
            }
            override fun connectionLost(throwable: Throwable) {
                Log.w("Debug", "Connected to host '$SOLACE_MQTT_HOST' lost.")
            }
            @Throws(Exception::class)
            override fun messageArrived(topic: String, mqttMessage: MqttMessage) {
                Log.w("Debug", "Message received from host '$SOLACE_MQTT_HOST': $mqttMessage")
                EditText1.setText("${EditText1.text.toString().toInt() + 1}")

            }

            override fun deliveryComplete(iMqttDeliveryToken: IMqttDeliveryToken) {
                Log.w("Debug", "Message published to host '$SOLACE_MQTT_HOST'")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        mqttClient.destroy()
        super.onDestroy()
    }


    /*Sentiment fun sentiment(){
        LanguageServiceClient.create { language ->

            // The text to analyze
            val text = "Hello, world!"
            val doc = Document.newBuilder()
                .setContent(text).setType(Type.PLAIN_TEXT).build()

            // Detects the sentiment of the text
            Sentiment sentiment = language.analyzeSentiment(doc).documentSentiment

            System.out.printf("Text: %s%n", text)
            System.out.printf("Sentiment: %s, %s%n", sentiment.score, sentiment.magnitude)
            return sentiment;
        }

    }*/
}

private fun Button.setOnClickListener(any: Any, any1: Any) {

}




