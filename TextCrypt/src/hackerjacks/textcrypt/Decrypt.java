<<<<<<< HEAD

package hackerjacks.textcrypt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Decrypt extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decrypt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.decrypt, menu);
		return true;
	}

}
=======
package hackerjacks.textcrypt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
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



>>>>>>> 948dd5438f9471677555c0d5209a7cf6f314976d
