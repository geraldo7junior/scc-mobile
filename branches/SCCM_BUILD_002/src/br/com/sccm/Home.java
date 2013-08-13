package br.com.sccm;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class Home extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		
		Button apontamentos = (Button) findViewById(R.id.btnapontamentos);
		
		apontamentos.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				chamaApontamentos();
			}
		});
	}
	
	public void mensagemExibir(String titulo,String texto){
		AlertDialog.Builder mensagem = new AlertDialog.Builder(Home.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("Ok",null);
		mensagem.show();
	}
	
	public void chamaApontamentos(){
		setContentView(R.layout.apontamentos);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

