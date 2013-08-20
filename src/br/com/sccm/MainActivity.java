package br.com.sccm;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EnterProcess startProcess = new EnterProcess(this);
		
		final EditText etUsuario = (EditText) findViewById(R.id.usuario);
		final EditText etSenha = (EditText) findViewById(R.id.senha);
		Button entrar = (Button) findViewById(R.id.entrar); 
		
		etUsuario.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				etUsuario.setText("");
			}
		});
		
		etSenha.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				etSenha.setText("");
			}
		});
		
		entrar.setOnClickListener(new View.OnClickListener() {
			final EditText etUsuario = (EditText) findViewById(R.id.usuario);
			final EditText etSenha = (EditText) findViewById(R.id.senha);
			
			@Override
			public void onClick(View v) {		
				
				startProcess.execute(etUsuario,etSenha);
				
				try {
					if (startProcess.get()==1){
						Toast.makeText(MainActivity.this, "Bem vindo!", Toast.LENGTH_SHORT).show();
						//mensagemExibir("Login","Usuário válido!");
						chamaHome();
						ImageButton apontar = (ImageButton) findViewById(R.id.btnapontamentos);		
						apontar.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								chamaApontar();
							}
						});
					}
					else
						Toast.makeText(MainActivity.this, "Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();
						//mensagemExibir("Login","Usuário ou senha inválidos!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
		
	}
	
	
	public void mensagemExibir(String titulo,String texto){
		AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("Ok",null);
		mensagem.show();
	}
	
	public void chamaHome(){
		setContentView(R.layout.home);
	}
	
	public void chamaApontar(){
		Intent entra = new Intent(this, Apontamentos.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
