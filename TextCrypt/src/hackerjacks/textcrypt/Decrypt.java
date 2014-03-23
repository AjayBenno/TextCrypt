

package hackerjacks.textcrypt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
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
		showDecryption =(TextView) findViewById(R.id.showDecryption);		
	}
	public void decryptn(View v){
		String decryption = enterDecrypt.getText().toString();
		int length = decryption.length() /2;
		String key = decryption.substring(length);
		String message = decryption.substring(0,length);
		showDecryption.setText(OneTimePad.decrypt(message, key));
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.decrypt, menu);
		return true;
	}

}
