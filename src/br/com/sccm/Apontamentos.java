package br.com.sccm;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Apontamentos extends Activity {
	Spinner sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apontamentos);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		sp=(Spinner) findViewById(R.id.listprojetos);
		
		ArrayAdapter<CharSequence> ar= ArrayAdapter.createFromResource(this, R.array.projeto, android.R.layout.simple_list_item_1);
		
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		
		sp=(Spinner) findViewById(R.id.listatividades);
		
		ArrayAdapter<CharSequence> arr= ArrayAdapter.createFromResource(this, R.array.atividades, android.R.layout.simple_list_item_1);
		
		arr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(arr);
		
	}
	
	public void onRadioButtonClicked(View view) {
		//Tá selecionado?
		boolean checked = ((RadioButton) view).isChecked();
		
		//Selecionada cada botao quando clicado
		switch(view.getId()) {
			case R.id.tipoa:
				if (checked)
					//Tipo A
					Toast.makeText(Apontamentos.this, "Tipo A", Toast.LENGTH_SHORT).show();
				break;
			case R.id.tipob:
				if (checked)
					//Tipo B
					Toast.makeText(Apontamentos.this, "Tipo B", Toast.LENGTH_SHORT).show();
				break;
			case R.id.tipoc:
				if (checked)
					//Tipo C
					Toast.makeText(Apontamentos.this, "Tipo C", Toast.LENGTH_SHORT).show();
				break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu (Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.enviar, menu);
		return super.onCreateOptionsMenu(menu);
	}

}
