package br.com.sccm;

import java.util.concurrent.ExecutionException;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends BaseMenu {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		final EnterProcess startProcess = new EnterProcess(this);
		
		//final EditText etUsuario = (EditText) findViewById(R.id.usuario);
		//final EditText etSenha = (EditText) findViewById(R.id.senha);
		Button entrar = (Button) findViewById(R.id.entrar); 
		
		entrar.setOnClickListener(new View.OnClickListener() {
			final EditText etUsuario = (EditText) findViewById(R.id.usuario);
			final EditText etSenha = (EditText) findViewById(R.id.senha);
			
			@Override
			public void onClick(View v) {		
				
				startProcess.execute(etUsuario,etSenha);
				
				try {
					if (startProcess.get()==1){
						Toast.makeText(MainActivity.this, "Bem-vindo!", Toast.LENGTH_SHORT).show();
						//mensagemExibir("Login","Usuário válido!");
						chamaHome();
						openOrCreateDatabase();
					}
					else
						Toast.makeText(MainActivity.this, "Usu�rio ou senha inv�lidos!", Toast.LENGTH_LONG).show();
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
	
	//public void chamaHome(){
	//	setContentView(R.layout.home);
	//}
	public void chamaHome(){
		Intent entra = new Intent(this, Home.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
      //banco local
	
	SQLiteDatabase database = null;
	Cursor cursor;
	
	
	public void openOrCreateDatabase () {
		try {
			String name = "swsdb";
			database = openOrCreateDatabase(name, SQLiteDatabase.CREATE_IF_NECESSARY, null);
				//mensagemExibir("Banco de dados", "Banco de dados funcionando corretamente");
		}catch (Exception error) {
				//mensagemExibir("Banco de dados", "Erro ao criar banco de dados: " +error.getMessage());
			
		}
		
		try {
			String CreateTableConsultants = Consultants.CreateTableConsultants;
			database.execSQL(CreateTableConsultants);
				//mensagemExibir ("Banco de dados", "Tabela Consultants criada corretamente");
		}catch (Exception error) {
				// mensagemExibir("Banco de dados", "Erro ao criar Tabela Consultants: " +error.getMessage());
			
		}
		try {
			String CreateTablesProjects = Projects.CreateTableProjects;
			database.execSQL(CreateTablesProjects);
				//mensagemExibir ("Banco de dados", "Tabela Projects corretamente");
		}catch (Exception error) {
				// mensagemExibir("Banco de dados", "Erro ao criar Tabela Projects: " +error.getMessage());
		}
		try {		
			String CreateTableActivities = Activities.CreateTableActivities;
			database.execSQL(CreateTableActivities);
				//mensagemExibir("Banco de dados", "Tabela Activities criada corretamente");
		}catch (Exception error) {
				// mensagemExibir("Banco de dados", "Erro ao criar tabela CreateTableActivities: " +error.getMessage());
		}
		try {
			String CreateTableProjects_consultants = Project_consultants.CreateTableProject_consultants;
			database.execSQL(CreateTableProjects_consultants);
				//mensagemExibir("Banco de dados", "Tabela Projects_consultants criada corretamente");
		}catch (Exception error) {
				// mensagemExibir("Banco de dados", "Erro ao criar tabela Projects_consultants: " +error.getMessage());
		}
		
		
		
	}
	
	
	
	public void cursorDatabase () {
		cursor = database.query("Consultants", 
			new String [] {"Id","Nome","UserName", "Password"}, 
					null, //selection, 
					null, //selectionArgs, 
					null,//groupBy, 
					null,//having, 
					null);//orderBy);
if (cursor.getCount() == 0) {
	String PopulatedTableConsultants = Consultants.PopulatedTableConsultants;
	database.execSQL(PopulatedTableConsultants);
}else
cursor.moveToFirst();

cursor = database.query("Projects", 
	new String [] {"Id","Name"}, 
					null, //selection, 
					null, //selectionArgs
					null, //groupBy
					null, //having
					null); //orderBy
if(cursor.getCount () == 0) {
	String PopulatedTableProjects = Projects.PopulatedTablesProjects;
	database.execSQL(PopulatedTableProjects);
}else 
cursor.moveToFirst();
cursor = database.query("Activities", 
	new String [] {"Id","Name","Id_project"}, 
					null, //selection, 
					null, //selectionArgs, 
					null,//groupBy, 
					null,//having, 
					null);//orderBy);
if (cursor.getCount() == 0) {
	String PopulatedTableActivities = Activities.PopulatedTableActivities;
	database.execSQL(PopulatedTableActivities);
}else
cursor.moveToFirst();

}

}
