package hackerjacks.textcrypt;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TextCrypt extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

          
	}
	public void goToMain(View v){
        Intent intent = new Intent(this, SMS.class);
        startActivity(intent);
	}
	
	public void about(View v){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
	}
	public void decrypt(View v){
    	Intent intent = new Intent(this, Decrypt.class);
    	startActivity(intent);
    	
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_contacts, menu);
		return true;
	}

}
