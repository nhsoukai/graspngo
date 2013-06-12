package yumyum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.List;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;

import org.json.JSONObject;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import android.net.ParseException;
import android.util.Log;

import food.Food;


/*
 * Author: N.H Soukaina
 */

public class MyParser {
	private final HttpClient httpclient = new DefaultHttpClient();
	Food objItem;
	List<Food> listArray;
	String result;
    private ArrayList<Food> menu=new ArrayList<Food>();

	public List<Food> getData(String url) {

		InputStream instream = null;
        
        try {
       
       
           //Create new HTTP POST with URL to php file as parameter
           HttpPost httppost = new HttpPost("http://10.0.2.2:8888/yumyum/getmenu.php"); 
           
           

           //assign executed form container to response
           HttpResponse response = httpclient.execute(httppost); //response from the PHP file

           //check status code, need to check status code 200
           if(response.getStatusLine().getStatusCode() == 200){

               //assign response entity to http entity
               HttpEntity entity = response.getEntity();

               //check if entity is not null
               if(entity != null){


                   //Create new input stream with received data assigned
                   instream = entity.getContent();
                   
                       
               }
           }
           
       
           
       		try
               {
                BufferedReader reader = new BufferedReader(new InputStreamReader(instream,"UTF-8"));
                
                StringBuilder sb  = new StringBuilder();
                
                String line = null;
                
                while ((line = reader.readLine()) != null) 
                {
                sb.append(line + "\n");
                }
                
                instream.close();
                
                result = sb.toString();
               }
               catch(Exception e)
               {
                
               }
               //recuperation des donnees json
               try{
                 JSONArray jArray = new JSONArray(result);
                   
                   
					for(int i=0;i<jArray.length();i++)
                    {
                   
                          JSONObject json_data = jArray.getJSONObject(i);
                          
                          String fid=json_data.getString("id");
                          String fname=json_data.getString("name");
                          String ftype=json_data.getString("type");
                          String fprice=json_data.getString("price");
                          menu.add(new Food(fid,fname,ftype,fprice));
                          //donnees.add(json_data.getString("price"));
                          
                      }
               
                
       } catch(Exception e){

           e.printStackTrace();
           //Display toast when there is a connection error
           //Change message to something more friendly

     
       }

		  }
      catch (ParseException e) {
       Log.i("tagjsonpars",""+e.toString());
 } catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
                  

       return menu;
	}

	@SuppressWarnings("unused")
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();

	}
}
