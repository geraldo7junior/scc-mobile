package br.com.sccm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		final EditText usuario = (EditText) findViewById(R.id.usuario);
		final EditText senha = (EditText) findViewById(R.id.senha);
		Button entrar = (Button) findViewById(R.id.entrar); 
		
		entrar.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				
				
				
				String logincerto = "admin";
				String senhacerta = "admin";
				String strLogin = usuario.getText().toString();
				String strSenha = senha.getText().toString();
				
				if (strLogin.equals(logincerto) && strSenha.equals(senhacerta)){
					Toast.makeText(MainActivity.this, "Login com Sucesso!", Toast.LENGTH_SHORT).show();
					chamaHome();
				}else{
					Toast.makeText(MainActivity.this, "Login e/ou Senha Incorretos!", Toast.LENGTH_SHORT).show();
					
				}
				
			}
		});


	}
	public void chamaHome(){
		setContentView(R.layout.home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
