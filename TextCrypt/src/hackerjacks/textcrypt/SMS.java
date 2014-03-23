package hackerjacks.textcrypt;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//VARUN'S EDIT ----- TEST ------ TEST ---- TEST ----- TEST
//test 3

public class SMS extends Activity {
	Button btnSendSMS;
	EditText txtPhoneNo;
	EditText txtMessage;

	static boolean Ajays = false;
	//static String OET2 = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
		txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
		txtMessage = (EditText) findViewById(R.id.txtMessage);

		/*
		 * Intent sendIntent = new Intent(Intent.ACTION_VIEW);
		 * sendIntent.putExtra("sms_body", "Content of the SMS goes here...");
		 * sendIntent.setType("vnd.android-dir/mms-sms");
		 * startActivity(sendIntent);
		 */

		btnSendSMS.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (Ajays) {
					String phoneNo = txtPhoneNo.getText().toString();
					String message = txtMessage.getText().toString();
					String encryption = OneTimePad.genKey(message.length());
					String encrypt = OneTimePad.encrypt(message, encryption);
					encrypt += encryption;
					if (phoneNo.length() > 0 && message.length() > 0)
						sendSMS(phoneNo, encrypt);
					else
						Toast.makeText(getBaseContext(),
								"Please enter both phone number and message.",
								Toast.LENGTH_SHORT).show();
				} else {
					String phoneNo = txtPhoneNo.getText().toString();
					String message = txtMessage.getText().toString();
					String OtherEncrypted = OtherEncrypt.encrypt(message);
					
					//OET2 = OtherEncrypted;
					if (phoneNo.length() > 0 && message.length() > 0)
						sendSMS(phoneNo, OtherEncrypted);
					else
						Toast.makeText(getBaseContext(),
								"Please enter both phone number and message.",
								Toast.LENGTH_SHORT).show();

				}
			}
		});
	}
	
	
	
	

	public void displayContacts(View v) {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		// BoD con't: CONTENT_TYPE instead of CONTENT_ITEM_TYPE
		intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
		startActivityForResult(intent, 1);
	}

	public void decrypt(View v) {
		
			Intent intent = new Intent(this, Decrypt.class);
			startActivity(intent);
		
		

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null) {
			Uri uri = data.getData();

			if (uri != null) {
				Cursor c = null;
				try {
					c = getContentResolver()
							.query(uri,
									new String[] {
											ContactsContract.CommonDataKinds.Phone.NUMBER,
											ContactsContract.CommonDataKinds.Phone.TYPE },
									null, null, null);

					if (c != null && c.moveToFirst()) {
						String number = c.getString(0);
						int type = c.getInt(1);
						txtPhoneNo.setText(number);
					}
				} finally {
					if (c != null) {
						c.close();
					}
				}
			}
		}
	}

	// ---sends a SMS message to another device---
	private void sendSMS(String phoneNumber, String message) {
		/*
		 * PendingIntent pi = PendingIntent.getActivity(this, 0, new
		 * Intent(this, test.class), 0); SmsManager sms =
		 * SmsManager.getDefault(); sms.sendTextMessage(phoneNumber, null,
		 * message, pi, null);
		 */

		String SENT = "SMS_SENT";
		String DELIVERED = "SMS_DELIVERED";

		PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(
				SENT), 0);

		PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
				new Intent(DELIVERED), 0);

		// ---when the SMS has been sent---
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS sent",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					Toast.makeText(getBaseContext(), "Generic failure",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(getBaseContext(), "No service",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(getBaseContext(), "Null PDU",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					Toast.makeText(getBaseContext(), "Radio off",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}, new IntentFilter(SENT));

		// ---when the SMS has been delivered---
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS delivered",
							Toast.LENGTH_SHORT).show();
					break;
				case Activity.RESULT_CANCELED:
					Toast.makeText(getBaseContext(), "SMS not delivered",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}, new IntentFilter(DELIVERED));

		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
	}

	public static boolean getAjays() {
		
		return Ajays;
	}
}