package br.com.sccm;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;




public class Home extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
	}
	
	//#################ROBSON##############
	public void loadPage(){
		setContentView(R.layout.apontamentos);
	}
	//####################FIM##############
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

