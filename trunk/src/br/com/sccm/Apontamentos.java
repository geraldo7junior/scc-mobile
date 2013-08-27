package br.com.sccm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Apontamentos extends Activity {
	Spinner sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apontamentos);
		
		sp=(Spinner) findViewById(R.id.spinner1);
		
		ArrayAdapter<CharSequence> ar= ArrayAdapter.createFromResource(this, R.array.projeto, android.R.layout.simple_list_item_1);
		
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		
		sp=(Spinner) findViewById(R.id.spinner2);
		
		ArrayAdapter<CharSequence> arr= ArrayAdapter.createFromResource(this, R.array.atividades, android.R.layout.simple_list_item_1);
		
		arr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(arr);
		
	}

}
