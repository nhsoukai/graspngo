package yumyum;
import com.example.test.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;

public class Menu extends Activity {
	ListView foodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);

        foodList = (ListView)findViewById(R.id.foodlist);

        String[] listeStrings = {"Food 1","Food 2","Food 3"};

       foodList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,listeStrings));
    }
    public void getPrice(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//EditText editText = (EditText) findViewById(R.id.edit_message);
    	//String message = editText.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
}
