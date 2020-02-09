package com.example.myapplication;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

public class NLP {
    public static Sentiment getSentiment(String data) throws java.io.IOException{
         LanguageServiceClient language = LanguageServiceClient.create() ;

            // The text to analyze
//            String text = "Hello, world!";
            Document doc = Document.newBuilder()
                    .setContent(data).setType(Type.PLAIN_TEXT).build();

            // Detects the sentiment of the text
            Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();
            System.out.printf("Text: %s%n", data);
            System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
            return sentiment;


    }



}
