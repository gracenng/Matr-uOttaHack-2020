package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_question_1.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_question_1.*
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.cloud.language.v1.Document
import com.google.cloud.language.v1.Document.Type
import com.google.cloud.language.v1.LanguageServiceClient
import com.google.cloud.language.v1.Sentiment

class question_1 : AppCompatActivity() {
    //    var button: Button? = null
    var counter = 0 //to count SeekBars output

//    var test = "ALICE was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into"



    override fun onCreate(savedInstanceState: Bundle?) {
//        NLP.getSentiment(test)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_1)
        setSupportActionBar(toolbar)

//        button = findViewById(R.id.next)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        next.setOnClickListener{
            val intent = Intent (this, question_2::class.java)
            startActivity(intent)
        }
    }

}
