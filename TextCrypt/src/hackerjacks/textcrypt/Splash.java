package hackerjacks.textcrypt;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {
	 private static String TAG = Splash.class.getName();
	 private static long SLEEP_TIME = 3;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 IntentLauncher launcher = new IntentLauncher();
		  launcher.start();
		  setContentView(R.layout.activity_splash);
		
	}
	private class IntentLauncher extends Thread{
		public void run() {
		     try {
		    	 MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.computer);		    	 
		    	 mp.start();
		        Thread.sleep(SLEEP_TIME*1000);
		        
		     } catch (Exception e) {
		        Log.e(TAG, e.getMessage());
		     }

		     // Start main activity
		     Intent intent = new Intent(Splash.this, TextCrypt.class);
		     Splash.this.startActivity(intent);
		     Splash.this.finish();
		  }
		}
	
	

	protected void onDestroy() {
		super.onDestroy();
	}
	
	protected void onPause () {
		super.onPause();
	}
	
	protected void onResume () {
		super.onResume();
	}
	
	protected void onStart () {
		super.onStart();
	}
	
	protected void onStot() {
		super.onStop();
	}
}
