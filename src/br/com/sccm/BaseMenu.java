package br.com.sccm;

import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



public class BaseMenu extends Activity {
	
	public class base extends Activity {
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch(item.getItemId()) {
		    case R.id.logout:
		    	Log.i("tag", "msg");
		    	return true;
		    default: 
		    	return super.onOptionsItemSelected(item);
		     
		}
			
		}
		
		

	}


}