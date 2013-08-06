package br.com.sccm;

import br.com.sccm.database.Activities;
import br.com.sccm.database.Addresses;
import android.database.sqlite.SQLiteDatabase; //armazena as informações dentro do banco de dados
import android.database.Cursor; //Manipula os dados
import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog; //
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
		openOrCreateDatabase(); //chamada para o método de abertura do banco
		
		
		
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
	
	//Banco de dados SQLite
	

	
	SQLiteDatabase Database = null;
	Cursor Cursor;
	String Name = "swsdb";
	
	public void messages (String Title, String Text) {
		
		AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
		message.setTitle(Title);
		message.setMessage(Text);
		message.setNeutralButton("OK", null);
		message.show();
		
		
	}
	
	//método para abertura ou criação dos banco de dados
	
	public void openOrCreateDatabase () {
		
		try {
			//Criação do banco de dados
			SQLiteDatabase.openOrCreateDatabase(Name, null );
			
			//Início da criação das tabelas
			String Activities = "Create if not exists table  Activities("+ 
	                " _id integer primary key auto_increment, not null" +
	                " start_hours  text time(timestring, modifier, modifier) not null" +
	                " end_hours  text time (timestring, modifier, modifier) not null"+
	                " Date text date (timestring, modifier, modifier) not null"+
	                " Observations text not null"+
	                " Description  text not null"+
	                " Status text not null" +
	                " Consultant1_id integer not null"+
	                " Consultant2_id integer not null"+
	                " Consultant3_id integer not null"+
	                " Consultant4_id integer not null "+
	                " Removed Integer not null ";
			Database.execSQL(Activities);
			
			String Consultants = "CREATE TABLE IF NOT EXISTS Consultants (_id PRIMARY KEY NOT NULL AUTO_INCREMENT, Cpf "+
					"INTEGER NOT NULL, Name TEXT NOT NULL, Acronym TEXT NOT NULL, Acronym_color"+ 
					"TEXT NOT NULL, Phone1  INTEGER NOT NULL, Phone2 INTEGER NOT NULL, Email"+ 
					"TEXT NOT NULL, Removed INTEGER NOT NULL, Photo BLOB NOT NULL )";
			Database.execSQL(Consultants);
			
			String Activities_consultants = "Create if not exists Activities_consultants (_id  INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, Consultant_id"+ 
					"INTEGER NOT NULL, Activity_id INTEGER NOT NULL CONSTRAINT,Activity_id references Activities (_id), CONSTRAINT Consultant_id " +
					"references Consultants (_id))";
			Database.execSQL(Activities_consultants);
			
			String Addresses = "Create TABLE IF NOT EXISTS Addresses (_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,Address" + 
				"TEXT NOT NULL,  Number  TEXT, Neighborhood TEXT, City  TEXT, State  TEXT, Consultant_id" + 
				"INTEGER NOT NULL, Company_id  INTEGER NOT NULL, CONSTRAINT Consultant_id references Consultants (_id)";
			Database.execSQL(Addresses);
			
			String Attachments = " CREATE TABLE IF NOT EXISTS Attachments (_id INTEGER PRIMARY KEY AUTO_INCREMENT" +
				" Name  TEXT, Email TEXT, Phone INTEGER )";
			Database.execSQL(Attachments);
			
			String Owners = "CREATE TABLE IF NOT EXISTS Owners (_id INTEGER PRIMARY KEY AUTO_INCREMENT, Name TEXT," +
					"Email TEXT, PHONE TEXT, DATE TEXT)";
			Database.execSQL(Owners);
			
			String Companies = "CREATE IF NOT EXISTS TABLE Companies (_id INTEGER PRIMAY KEY AUTO_INCREMENT NOT NULL, Cnpj"+
				" INTEGER NOT NULL, Name TEXT NOT NULL, Acronym TEXT NOT NULL, Phone1 INTEGER, Phone2"+
				" INTEGER, Logo  TEXT, Removed  TEXT, Fundation TEXT, Owner_id INTEGER)";
			Database.execSQL(Companies);
			
			String Companies_bank_infos = "CREATE IF NOT EXISTS TABLE Companies_bank_infos  (_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, Name_bank"+
				" TEXT, Number_agency INTEGER, Number_account INTEGER, Company_id INTEGER, CONSTRAINT Company_id REFERENCES Companies (_id)"; 
			Database.execSQL( Companies_bank_infos);
			
			String Companies_contacts = "CREATE IF NOT EXISTS TABLE Companies_contacts(_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, Name"+
    			" TEXT, Email TEXT, Function TEXT, Telephone INTEGER,  Company_id"+ 
    			" INTEGER, CONSTRAINT company_ id REFERENCES companies(_id)";
			Database.execSQL( Companies_contacts);
			
			String Consultants_bank_infos = "CREATE IF NOT EXISTS TABLE Consultants_bank_infos  (_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, Name_bank"+
					" TEXT, Number_agency INTEGER, Number_account INTEGER, Consultant_id INTEGER, CONSTRAINT Consultant_id REFERENCES consultants(_id)"; 
			Database.execSQL( Consultants_bank_infos);
			
			String Entries = "CREATE IF NOT EXISTS TABLE Entries  ( _id INTEGER PRIMARY KEY AUTO_INCREMENTNOT NULL, Date"+ 
				" TEXT NOT NULL, Type_consulting TEXT NOT NULL, Type TEXT NOT NULL Hours_worked TEXT NOT NULL," +
						" Observations TEXT, Consultant_id INTEGER NOT NULL, Activity_id INTEGER NOT NULL, Approved"+ 
						"INTEGER NOT NULL, Removed INTEGER NOT NULL, CONSTRAINT Activity_id REFERENCES Activities(_id), CONSTRAINT Consultant_id REFERENCES Consultants(_id))";
			
			Database.execSQL(Entries);
				
			String Projects = "CREATE IF NOT EXISTS TABLE Projects (_id INTEGER NOT NULL PRIMARY_KEY AUTO_INCREMENT, Name"+
 				" TEXT NOT NULL, Description TEXT NOT NULL, Acronym TEXT NOT NULL, A_hours_individual REAL, B_hours_individual REAL, C_hours_individual, REAL, A_hours_group"+ 
 				"REAL, B_hours_group REAL, C_hours_group REAL, Consultant_id  INTEGER, Parent_project_id INTEGER, Company_id"+
 				" INTEGER NOT NULL, Removed INTEGER NOT NULL, CONSTRAINT Company_id REFERENCES Companies(_id), CONSTRAINT Consultant_id REFERENCES Consultants(_id)";
 		   
			Database.execSQL(Projects);
 		   
 		   String Expenses = "CREATE IF NOT EXISTS TABLE Expenses" +
					"(_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, Description"+ 
					"TEXT NOT NULL, Value REAL NOT NULL, Type  TEXT, Project_id"+ 
					" INTEGER NOT NULL, Attachments BLOB, File" +
					"BLOB, Type_expenses TEXT, CONSTRAINT Project_id references Projects (_id))";
 		   
 		   Database.execSQL(Expenses);
 		   
 		   String Financials = "CREATE IF NOT EXISTS TABLE Financials ( _id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, Name"+
 	    			" TEXT, Phone1 TEXT, Phone2 TEXT, Email TEXT, Company_id INTEGER, CONSTRAINT Company_id REFERENCES COMPANIES (_id))";

 		  Database.execSQL(Financials);
 		  
 		   String Projects_Consultants = " _id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,  Project_id INTEGER NOT NULL"+
 				                         "Project_id INTEGER NOT NULL, Value_hour_a_individual REAL,Value_hour_b_individual REAL" +
 				                         "Value_hour_c_individual REAL,Value_hour_a_group REAL, Value_hour_b_group REAL, Value_hour_c_group REAL," +
 				                         "CONSTRAINT Consultant_id REFERENCES Consultants(_id), CONSTRAINT Project_id REFERENCES Projects(_id))";
  		  Database.execSQL(Projects_Consultants);
  		  
  		  
  		  String Sepgs = "CREATE IF NOT EXISTS TABLE Segps(_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, Name TEXT, Phone1 TEXT" +
  		                 "Phone2 TEXT, EMAIL TEXT, Company_id INTEGER, CONSTRAINT Company_id REFERENCES Companies (_id))";
                         
                         
  		  Database.execSQL(Sepgs);
  		  
  		  String Sponsors = "CREATE IF NOT EXISTS TABLE Segps(_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, Name TEXT, Phone1 TEXT" +
	                 "Phone2 TEXT, EMAIL TEXT, Company_id INTEGER, CONSTRAINT Company_id REFERENCES Companies (_id))";
                  
			
			
		 String Users = "CREATE IF NOT EXISTS TABLE Segps(_id INTEGER NOT NULLAUTO_INCREMENT, Username TEXT PRIMARY KEY," +
		 		"Password TEXT, Type TEXT, Consultant_id INTEGER";
		 
		 //Fim da criação das tabelas
		 Database.execSQL(Users);
		 messages("Sucesso!","Banco de dados criado corretamente");
				
		}catch (Exception Erro) {
			messages("Erro!","Falha ao criar ou abrir o banco de dados!"+Erro.getMessage());
				}
	
		}

		
	
	public void closeDatabase () {
		
		try {
			Database.close();
			messages ("Sucesso!","Banco de dados finalizado corretamente.");
			
		}catch (Exception Erro) {
			messages ("Erro!","Falha ao finalizar banco de dados!"+Erro.getMessage());
			
		}
	}
	
}
