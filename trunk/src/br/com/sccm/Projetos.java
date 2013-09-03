package br.com.sccm;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Projetos extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projetos);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
