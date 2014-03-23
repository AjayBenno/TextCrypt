

package hackerjacks.textcrypt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Decrypt2 extends Activity {

	EditText enterDecrypt1;
	TextView showDecryption1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decrypt);
		enterDecrypt1 = (EditText) findViewById(R.id.enterDecrypt);
		showDecryption1 =(TextView) findViewById(R.id.showDecryption);
		String ArrayOfDubsAsString = SMS.getOET2();
	}
	public void decryptn(View v){
		String decryption = enterDecrypt1.getText().toString();
		int length = decryption.length() /2;
		String key = decryption.substring(length);
		String message = decryption.substring(0,length);
		showDecryption1.setText(OneTimePad.decrypt(message, key));
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.decrypt, menu);
		return true;
	}

}
