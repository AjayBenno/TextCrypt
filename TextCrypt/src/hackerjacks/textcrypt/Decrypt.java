package hackerjacks.textcrypt;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Decrypt extends Activity {

	EditText enterDecrypt;
	TextView showDecryption;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decrypt);
		enterDecrypt = (EditText) findViewById(R.id.enterDecrypt);
		showDecryption = (TextView) findViewById(R.id.showDecryption);
		ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            Intent intent = new Intent(this, TextCrypt.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	
	public void decryptn(View v) {
	/*	String first= enterDecrypt.getText().toString().substring(2,3);
		try{			
			int number=Integer.parseInt(first);
			String decryption = enterDecrypt.getText().toString();
			int length = decryption.length() / 2;
			String key = decryption.substring(length);
			String message = decryption.substring(0, length);
			showDecryption.setText(OneTimePad.decrypt(message, key));
		}
			
		catch(Exception e){
			String decryption = enterDecrypt.getText().toString();
			showDecryption.setText(OtherEncrypt.decrypt(decryption));
		}*/
		if (SMS.getAjays()) {
			String decryption = enterDecrypt.getText().toString();
			int length = decryption.length() / 2;
			String key = decryption.substring(length);
			String message = decryption.substring(0, length);
			showDecryption.setText(OneTimePad.decrypt(message, key));
		}
		else{
			String decryption = enterDecrypt.getText().toString();
			showDecryption.setText(OtherEncrypt.decrypt(decryption));
		}
	}

}

