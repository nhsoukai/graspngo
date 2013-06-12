package yumyum;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import android.app.AlertDialog;


import com.example.test.R;

import food.Food;


import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.ListView;

import android.app.Activity;
import android.app.ProgressDialog;

import android.content.DialogInterface;
import android.content.Intent;

/*
 * Author: N.H Soukaina
 */

public class DisplayMessageActivity extends Activity implements OnClickListener{
	
	//this allows to start new intent outside the activity
	public Activity a =this;
	ListView lvListe;
	//list of the command 
	public List<String> reservList = new ArrayList<String>();
	private List<Food> menu;
	private MyAdapter objAdapter = null;
	String idres = null;
	String ido;

	public List<String>getreserL(){
		return reservList;
		
	}
	private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		setContentView(R.layout.activity_display_message);
		//interface 
		lvListe = (ListView) findViewById(R.id.lvlist);
		btn = (Button) findViewById(R.id.orderButton);
		btn.setOnClickListener(this);

		
        new MyAsyncTask(this).execute();
   }
    
    public void viewMenu(View view) {
        
    	Intent intent = new Intent(this, Menu.class);
    	
    	startActivity(intent);
    }
    
    //for the connections
    private class MyAsyncTask extends AsyncTask<Void, Void, Void>
    {
    	
  
        ProgressDialog mProgressDialog;
      
        @SuppressWarnings("unused")
		private Activity activity;
       
       
      


        
        public MyAsyncTask(Activity activity){
        this.activity=activity;
        }
       
            @Override
            protected void onPostExecute(Void result) {
            	setAdapterToListview();
            	mProgressDialog.dismiss();
            	super.onPostExecute(result);
            }
            
            public void setAdapterToListview() {

        		// Sort Data Alphabatical order
        		Collections.sort(menu, new Comparator<Food>() {

        			@Override
        			public int compare(Food lhs, Food rhs) {
        				return lhs.getName().compareTo(rhs.getName());
        			}
        		});
        		//for retrieving the values of the checkboxes
        		objAdapter = new MyAdapter(DisplayMessageActivity.this, menu);
        		lvListe.setAdapter(objAdapter);
        		lvListe.setOnItemClickListener(new OnItemClickListener() {

        			@Override
        			public void onItemClick(AdapterView<?> parent, View view,
        					int position, long id) {

        				CheckBox chk = (CheckBox) view.findViewById(R.id.checkBox1);
        				Food bean = menu.get(position);
        				if (bean.isSelected()) {
        					bean.setSelected(false);
        					chk.setChecked(false);
        				} else {
        					bean.setSelected(true);
        					chk.setChecked(true);
        				}

        			}
        		});

        	}
            	
            @Override
            protected void onPreExecute() {
                mProgressDialog = ProgressDialog.show(DisplayMessageActivity.this, "Loading menu...", "Data is Loading...");
            }

            
          
            @Override
    		protected Void doInBackground(Void... params) {
    			menu = new MyParser().getData("http://10.0.2.2:8888/yumyum/getmenu.php");
    			return null;
    		}


	
	
	
    }
    
    String id;
    @Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();

		// Retrive Data from list
		double i=0;
		for (Food food : menu) {
			
			if (food.isSelected()) {
				//name and price of checked items to be shown 
				String price = food.getPrice();
				id=food.getId();
				sb.append(food.getName());
				sb.append(":");
				sb.append(price);
				sb.append("$");
				sb.append("\n");
				int p;
				p = Integer.parseInt(price); 
				i+=p;
				
				
			}
			
		}
		sb.append("Total:");
		sb.append(i);
		sb.append("$");
		

		showAlertView(sb.toString().trim());
	}
    @SuppressWarnings("deprecation")
	private void showAlertView(String str) {
		AlertDialog alert = new AlertDialog.Builder(this).create();
		if (TextUtils.isEmpty(str)) {
			alert.setTitle("Not Selected");
			alert.setMessage("No One is Seleceted!!!");
		} else {
			// Remove , end of the name
			String strContactList = str.substring(0, str.length() - 1);

			alert.setTitle("Your ordered");
			alert.setMessage(strContactList);
		}
		
		alert.setButton("Confirm", new DialogInterface.OnClickListener() {
			//String  time;
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.dismiss();
				
					
        		Bundle bundle = new Bundle();
        		
        		//send the food id as a parameter to the next activity
        		bundle.putString("id", id);
        		Intent intent = new Intent(a, Reservation.class);
        		intent.putExtras(bundle);
        		finish();
        		a.startActivityForResult(intent, 0);
				
        		
			}
		});
		alert.show();
	}
}









