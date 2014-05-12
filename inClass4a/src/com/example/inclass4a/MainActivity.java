//Robert Payne
//inclass 4a
package com.example.inclass4a;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	Button button1;
	TextView textView1;
	ProgressDialog.Builder pDialog; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		textView1 = (TextView) findViewById(R.id.textView);
		
	}
	
	
	  private class SimulateTask extends AsyncTask<String, Integer,String> {
        protected  String doInBackground(String... s) {
        
           return (String.valueOf(HeavyWork.getNumber())); 
        	
        }
        protected void onProgressUpdate(Integer... progress) {
        //	pDialog.setProgress((int)HeavyWork.COUNT /900);
        }
        protected void onPostExecute(String result) {
           textView1.setText(result);
           
       
        }
   }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		pDialog = new ProgressDialog.Builder(this);
		pDialog.getContext();
		pDialog.create();
		pDialog.setTitle("Doing Work...");
		pDialog.show();

		
	}

}
