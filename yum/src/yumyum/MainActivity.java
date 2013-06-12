package yumyum;

import com.example.test.R;
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
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;

/*
 * Author: N.H Soukaina
 */

public  class MainActivity extends Activity implements OnClickListener {
	
	//Fields of the UI
	EditText etUser, etPass;
	Button bLogin;
	
	//password and username to verify
	String password, username;
	
	//prepare for HTTP request
	HttpClient httpclient;
	HttpPost httppost;
	
	//Create an array list for the input data to be sent
    ArrayList<NameValuePair> nameValuePairs;

    //Create a HTTP Response and HTTP Entity
    HttpResponse response;
    HttpEntity entity;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
    }


    private void initialise() {
		
    	//retrieve username and password entered by the user
    	etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        bLogin = (Button) findViewById(R.id.bSubmit);
        //Now to set an onClickListener
        bLogin.setOnClickListener(this);
		
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   

	@Override
	public void onClick(View arg0) {
		// to make the connections in the background
		new MyAsyncTask(this).execute();
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

private class MyAsyncTask extends AsyncTask<Void, Void, Boolean>
{
	private static final int REGISTRATION_TIMEOUT = 3 * 1000;
    private static final int WAIT_TIMEOUT = 30 * 1000;
    private final HttpClient httpclient = new DefaultHttpClient();
    private Activity activity;
    
    public MyAsyncTask(Activity activity){
    this.activity=activity;
    }
    	//progress dialog for waiting
        ProgressDialog mProgressDialog;
        Boolean logged;
        @Override
        protected void onPostExecute(Boolean result) {
        	
        	mProgressDialog.dismiss();
        	// if match
        	if (result){
        		
        		Toast.makeText(getBaseContext(), "Successful authentication", Toast.LENGTH_SHORT).show();
        		Intent intent = new Intent(activity, DisplayMessageActivity.class);
        		finish();
        		//go to next activity 
        		activity.startActivity(intent);
        		}
        		
        	else
        		Toast.makeText(getBaseContext(), "unSuccessful", Toast.LENGTH_SHORT).show();
        	
            
        }

        @Override
        protected void onPreExecute() {
            mProgressDialog = ProgressDialog.show(MainActivity.this, "Connecting...", "Please wait...");
        }

        @Override
        protected Boolean doInBackground(Void... params) {
        	String jsonstring=null;

        	

            //Assign input text to strings
            username = etUser.getText().toString();
            password = etPass.getText().toString();



            //Next block of code needs to be surrounded by try/catch block for it to work
            try {
            	final HttpParams params1 = httpclient.getParams();
            	HttpConnectionParams.setConnectionTimeout(params1, REGISTRATION_TIMEOUT);
                HttpConnectionParams.setSoTimeout(params1, WAIT_TIMEOUT);
                ConnManagerParams.setTimeout(params1, WAIT_TIMEOUT);
                //Create new HTTP POST with URL to php file as parameter
                httppost = new HttpPost("http://10.0.2.2:8888/yumyum/andlogin.php"); 
                //Create new Array List
                nameValuePairs = new ArrayList<NameValuePair>(2);

                //place them in an array list
                nameValuePairs.add(new BasicNameValuePair("user", username));
                nameValuePairs.add(new BasicNameValuePair("pass", password));

                //Add array list to http post
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


                //assign executed form container to response
                response = httpclient.execute(httppost); //response from the PHP file

                //check status code, need to check status code 200
                if(response.getStatusLine().getStatusCode() == 200){

                    //assign response entity to http entity
                    entity = response.getEntity();

                    //check if entity is not null
                    if(entity != null){


                        //Create new input stream with received data assigned
                        InputStream instream = entity.getContent();
                        jsonstring=convertStreamToString(instream);
                        
    
                        //Validate login
                        if( !jsonstring.equals("") ){ //Check whether 'retUser' and 'retPass' matches username/password 

                            //Display a Toast saying login was a success
                            
                            logged=true;

                        } else {
                            //Display a Toast saying it failed.

                            logged=false;
                        }

                    }


                }


            } catch(Exception e){

                e.printStackTrace();
                //connection error
                
               logged=false;
            }
            //true is match
			return logged;
       
        }
    }

}
