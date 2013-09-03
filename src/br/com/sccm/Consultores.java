package br.com.sccm;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Consultores extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consultor);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
