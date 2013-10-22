package com.example.talk;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Second extends Activity{
	TextToSpeech tts;
	static final String[ ]  tetxts= {"hey guyz", "kitu yoyote", "niko njaa"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		Button b = (Button) findViewById(R.id.b1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts = new TextToSpeech(Second.this, new TextToSpeech.OnInitListener() {
					
					@Override
					public void onInit(int status) {
						// TODO Auto-generated method stub
						Random r = new Random();
						String random = tetxts[r.nextInt(3)];
						tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
						if (status != TextToSpeech.ERROR){
							tts.setLanguage(Locale.US);
						}
					}
				});
			}
			
		});
		
	}
	

}
