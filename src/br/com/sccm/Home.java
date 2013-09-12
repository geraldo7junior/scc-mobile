package br.com.sccm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;
import android.view.View;




public class Home extends BaseMenu {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ImageButton apontar = (ImageButton) findViewById(R.id.btnapontamentos);		
		apontar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaApontar();
			}
		});
		ImageButton consultores = (ImageButton) findViewById(R.id.btnconsultores);		
		consultores.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaConsultores();
				
			}
		});
		ImageButton agenda = (ImageButton) findViewById(R.id.btnagenda);		
		agenda.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaAgenda();
				
			}
		});
		ImageButton empresas = (ImageButton) findViewById(R.id.btnempresas);		
		empresas.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaEmpresas();
				
			}
		});
		ImageButton projetos = (ImageButton) findViewById(R.id.btnprojetos);		
		projetos.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaProjetos();
				
			}
		});
	}
	
	
	//#################ROBSON##############
	public void loadPage(){
		setContentView(R.layout.apontamentos);
	}
	//####################FIM##############
	
	public void chamaApontar(){
		Intent entra = new Intent(this, Apontamentos.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaAgenda(){
		Intent entra = new Intent(this, Agenda.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaConsultores(){
		Intent entra = new Intent(this, Consultores.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaEmpresas(){
		Intent entra = new Intent(this, Empresas.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaProjetos(){
		Intent entra = new Intent(this, Projetos.class);
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

