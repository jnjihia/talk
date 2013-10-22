package com.example.talk;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
	private Thread mthread;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mthread = new Thread(){
        	public void run(){
        		try {
					synchronized (this) {
						wait(2000);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				finish();
				Intent myintent = new Intent(MainActivity.this, Second.class);
				startActivity(myintent);
        	}
        	
        };
        mthread.start();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
