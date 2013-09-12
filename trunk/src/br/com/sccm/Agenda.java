package br.com.sccm;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Agenda extends BaseMenu {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agenda);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
