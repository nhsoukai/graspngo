package yumyum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;




import com.example.test.R;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;

/*
 * Author: N.H Soukaina
 */
//last activity
public class Reservation extends Activity implements OnClickListener{
	ArrayList<NameValuePair> nameValuePairs;
	String[] idlist;
	String jsonstring ;
	private Button btn;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.reservation);
	        btn = (Button) findViewById(R.id.finish);
			btn.setOnClickListener(this);
	        Bundle bundle = this.getIntent().getExtras();
	    	String id = bundle.getString("id");
	    	//for connections 
	        new MyAsyncTaskRes(id).execute();
	        
	        

	   }
	 public void viewMenu(View view) {
	        
	    	Intent intent = new Intent(this, Menu.class);
	    	
	    	startActivity(intent);
	    }
	
	
	
	public static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}
	
	
	private class MyAsyncTaskRes extends AsyncTask<Void, Void, String>
    {
		String id;
		ProgressDialog mProgressDialog;
		private final HttpClient httpclient = new DefaultHttpClient();
		public MyAsyncTaskRes(String id){
	        this.id=id;
	        }
		
		protected void onPostExecute(String result) {
			mProgressDialog.dismiss();
			
        	super.onPostExecute(result);
        	TextView text = (TextView) findViewById(R.id.time);
        	//show the estimated time
	        text.setText(result);
        }
		 @Override
	        protected void onPreExecute() {
	            mProgressDialog = ProgressDialog.show(Reservation.this, "Connecting...", "Data is Loading...");
	        }
		@Override
		protected String doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			
			  try {
			       
			       	//for(String id:idlist){
			           //Create new HTTP POST with URL to php file as parameter
			           HttpPost httppost = new HttpPost("http://10.0.2.2:8888/yumyum/reserve.php"); 
			           nameValuePairs = new ArrayList<NameValuePair>(2);
			           
		                //place them in an array list
		                nameValuePairs.add(new BasicNameValuePair("id", id));
		         

		                //Add array list to http post
		                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			           

			           //assign executed form container to response
			           HttpResponse response = httpclient.execute(httppost); //response from the PHP file
			           
			           //if(response.getStatusLine().getStatusCode() == 200){

		                    //assign response entity to http entity
		                    HttpEntity entity = response.getEntity();
		                    if(entity != null){


		                        //Create new input stream with received data assigned
		                        InputStream instream = entity.getContent();
		                        jsonstring = convertStreamToString(instream);
		                        
			          // }
			          }
			  }
			           catch(Exception e){

		           e.printStackTrace();
		        

		     
		       }
			return jsonstring;
			  
    }
    }
	//exit
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		finish();
	}
}


