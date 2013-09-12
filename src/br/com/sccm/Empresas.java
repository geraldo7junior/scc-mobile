package br.com.sccm;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Empresas extends BaseMenu {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.empresas);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}