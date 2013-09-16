package br.com.sccm;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
//import android.content.ContentValues;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
//import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
//import android.database.Cursor;

@SuppressLint("CutPasteId")
public class Apontamentos extends BaseMenu {
	MainActivity a = new MainActivity();
	String titulo = "geladeira";
	Spinner sp1;
	Spinner sp2;
	String ProjetoNome;
	String AtividadeNome;
	String radioTipoHora = "";
	String radioTipoConsultoria = "";
	String Hora = "";
	String dataApontamento = "";
	String dataApontamento2 = "";
	EditText edittitulo;
	TextView titledate;
	TextView titletipohora;
	TextView titlehorastrab;
	TextView timeDisplay;
	Button pickTIme;
	//RadioGroup grupotipohora;
	//RadioButton tipoa;
	//RadioButton tipob;
	//RadioButton tipoc;
	//RadioGroup grupotipoconsultoria;
	//RadioButton tipoindividual;
	//RadioButton tipogrupo;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		openOrCreateDatabase ();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apontamentos);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		
		sp1=(Spinner) findViewById(R.id.listprojetos);
		
		ArrayAdapter<CharSequence> ar= ArrayAdapter.createFromResource(this, R.array.projeto, android.R.layout.simple_list_item_1);
		
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp1.setAdapter(ar);
		ProjetoNome =sp1.getSelectedItem().toString();
		
		sp2=(Spinner) findViewById(R.id.listatividades);
		
		ArrayAdapter<CharSequence> arr= ArrayAdapter.createFromResource(this, R.array.atividades, android.R.layout.simple_list_item_1);
		
		arr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp2.setAdapter(arr);
	    AtividadeNome = sp2.getSelectedItem().toString();
	     final EditText edittitulo = (EditText) findViewById(R.id.edittitulo);
	     titulo = edittitulo.getText().toString();
	    
		
		//#########DATA APONTADA#########//
		/** Capture our View elements */
    editdate = (TextView) findViewById(R.id.editdate);
    alterdate = (Button) findViewById(R.id.alterdata);
    
    /** Listener for click event of the button */
    alterdate.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        showDialog(DATE_DIALOG_ID);
      }
    });
    
    /** Display the current time in the TextView */
    updateDate();
        //#########DATA APONTADA - FIM#########//
    
		//#########HORAS APONTADAS#########//
    /** Capture our View elements */
    displayTime = (TextView) findViewById(R.id.timeDisplay);
    pickTime = (Button) findViewById(R.id.pickTime);
    
    /** Listener for click event of the button */
    pickTime.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        showDialog(TIME_DIALOG_ID);
      }
    });
    
    /** Get the current time */
    final Calendar cal = Calendar.getInstance();
    pAno = cal.get(Calendar.YEAR);
    pMes = cal.get(Calendar.MONTH);
    pDia = cal.get(Calendar.DAY_OF_MONTH);
    
    /** Display the current time in the TextView */
    updateDisplay();
      //#########HORAS APONTADAS - FIM#########//
    Button btnApontar = (Button) findViewById(R.id.btnApontar);
	btnApontar.setOnClickListener(new View.OnClickListener() {	
	
		
   	 public void onClick(View v) {
   	
   	 // inicializarObjetos ();

   	  String Sql = null;
   	  try {
   		
   		Sql= "INSERT INTO Entr (project_name, activity_name,title, date, hour, type_hour, type_consultancy) VALUES ('" +
   				ProjetoNome +"','"+
   				AtividadeNome +"','"+
   				edittitulo.getText().toString()+"','"+
   				dataApontamento+"','"+
   				Hora+"','"+
   				radioTipoHora+"','"+
   	            radioTipoConsultoria+"')";
   				
   				database.execSQL(Sql);
   		   		mensagemExibir("Banco de dados","Apontamento gravado com sucesso!");

   				
   		   	
   	  }catch (Exception error) {
   		    mensagemExibir("Erro Banco de dados",Sql);
     		mensagemExibir("Erro Banco de dados",error.getMessage());
     		
   	  }
    	  //testarOBjeto();
      							
       	}
   			
   			});
	
  }
	public void testarOBjeto () {
		if(TextUtils.isEmpty(ProjetoNome.trim())){  
			 mensagemExibir("ProjetoNome", "Vazio ");
			}else{  
				 mensagemExibir("ProjetoNome", "Nao está vazio. Valor:"+ProjetoNome);
			}  
		if(TextUtils.isEmpty(AtividadeNome.trim())){  
			 mensagemExibir("AtividadeNome", "Vazio ");
			}else{  
				 mensagemExibir("AtividadeNome", "Nao esta vazio. Valor:"+AtividadeNome);
			}   
		if(TextUtils.isEmpty(edittitulo.getText().toString().trim())){  
			 mensagemExibir("Titulo", "Vazio ");
			}else{  
				 mensagemExibir("Titulo", "Nao esta vazio. Valor:"+edittitulo.getText().toString());
			}   
		if(TextUtils.isEmpty(dataApontamento.trim())){  
			 mensagemExibir("dataApontamento", "Vazio ");
			}else{  
				 mensagemExibir("dataApontamento", "Nao esta vazio. Valor:"+dataApontamento);
			}   
		if(TextUtils.isEmpty(Hora.trim())){  
			 mensagemExibir("Hora", "Vazio ");
			}else{  
				 mensagemExibir("Hora", "Nao esta vazio. Valor:"+Hora);
			}  
		if(TextUtils.isEmpty(radioTipoHora.trim())){  
			 mensagemExibir("radioTipoHora", "Vazio ");
			}else{  
				 mensagemExibir("radioTipoHora", "Nao esta vazio. Valor:"+radioTipoHora);
			}  
		if(TextUtils.isEmpty( radioTipoConsultoria.trim())){  
			 mensagemExibir("Variavel radioTipoHora", "Vazio ");
			}else{  
				 mensagemExibir(" radioTipoConsultoria", "Nao esta vazio. Valor:"+ radioTipoConsultoria);
			} 
	}
 public void inicializarObjetos (){
	 try{
	 edittitulo = (EditText) findViewById(R.id.edittitulo);
	 titledate = (TextView) findViewById(R.id.titledate);
	  displayTime = (TextView) findViewById(R.id.timeDisplay);
	   alterdate = (Button) findViewById(R.id.alterdata);
	   titletipohora = (TextView) findViewById(R.id.titletipohora);
	   timeDisplay = (TextView) findViewById(R.id.timeDisplay);
	   pickTIme = (Button) findViewById(R.id.pickTime);
	   // grupotipohora =  (RadioGroup) findViewById(R.id.grupotipohora);
	// tipoa =  (RadioButton) findViewById(R.id.tipoa);
	 //tipob =  (RadioButton) findViewById(R.id.tipob);
	 //tipoc =  (RadioButton) findViewById(R.id.tipoc);
	// grupotipoconsultoria =  (RadioGroup) findViewById(R.id.grupotipoconsultoria);
	 //tipoindividual =  (RadioButton) findViewById(R.id.tipoindividual);
	 //tipogrupo =  (RadioButton) findViewById(R.id.tipogrupo);
	  mensagemExibir ("Objetos inicializados corretamento!","tudo ok ok");

	 }catch (Exception error) {
		 mensagemExibir("Banco de dados", "Erro ao salvar dados: " +error.getCause());
		 
	 }
	 
		
	}
 
 
  public void onRadioButtonClicked(View view) {
		//Tá selecionado?
    boolean checked = ((RadioButton) view).isChecked();
    
		//Selecionada cada botao quando clicado
    switch(view.getId()) {
     case R.id.tipoa:
     if (checked)
					//Tipo A
    	 radioTipoHora = "Tipo A";
     Toast.makeText(Apontamentos.this,radioTipoHora, Toast.LENGTH_LONG).show();
     	
     break;
     case R.id.tipob:
     if (checked)
					//Tipo B
    	 radioTipoHora = "Tipo B";
     Toast.makeText(Apontamentos.this,radioTipoHora, Toast.LENGTH_LONG).show();
     break;
     case R.id.tipoc:
     if (checked)
    radioTipoHora = "Tipo C";
     Toast.makeText(Apontamentos.this,radioTipoHora, Toast.LENGTH_LONG).show();
     break;
     
     case R.id.tipoindividual:
    	    if (checked)
    	    radioTipoConsultoria = "Individual";
    	    Toast.makeText(Apontamentos.this,radioTipoConsultoria, Toast.LENGTH_LONG).show();
    	        break;
     case R.id.tipogrupo:
 	   if (checked)
 	    radioTipoConsultoria = "grupo";
 	    Toast.makeText(Apontamentos.this,radioTipoConsultoria, Toast.LENGTH_LONG).show();
 	        break;
   }
    
 }
  
 
 @Override
 public boolean onCreateOptionsMenu (Menu menu) {
  MenuInflater inflater = getMenuInflater();
  inflater.inflate(R.menu.enviar, menu);
  return super.onCreateOptionsMenu(menu);
}

	//#########HORAS APONTADAS#########//	
private TextView displayTime;
private Button pickTime;

private int pHour;
private int pMinute;
/** This integer will uniquely define the dialog to be used for displaying time picker.*/
public static final int TIME_DIALOG_ID = 2;

/** Callback received when the user "picks" a time in the dialog */
private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
 @Override
 public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
   pHour = hourOfDay;
   pMinute = minute;
   updateDisplay();
   
 }
 
};

/** Updates the time in the TextView */
private void updateDisplay() {
  displayTime.setText(
    new StringBuilder()
    .append(pad(pHour)).append(":")
    .append(pad(pMinute)));
  Hora = pad(pHour)+":"+pad(pMinute); 
}

/** Add padding to numbers less than ten */
private static String pad(int c) {
  if (c >= 10)
    return String.valueOf(c);
  else
    return "0" + String.valueOf(c);
}
  //#########HORAS APONTADAS - FIM#########//

  //#########HORAS APONTADAS#########//	
private TextView editdate;
private Button alterdate;

private int pDia;
private int pMes;
private int pAno;
/** This integer will uniquely define the dialog to be used for displaying time picker.*/
public static final int DATE_DIALOG_ID = 1;

/** Callback received when the user "picks" a time in the dialog */
private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
 @Override
 public void onDateSet(DatePicker view, int year, int monthOfYear,
  int dayOfMonth) {
			// TODO Auto-generated method stub
   pDia = dayOfMonth;
   pMes = monthOfYear;
   pAno = year;
   updateDate();
   
   
 }
 
};
/** Updates the time in the TextView */
private void updateDate() {
  if (pMes == 0) {
   editdate.setText(
    new StringBuilder()
    .append(padDate(pDia)).append("/")
    .append(padDate(pMes)).append("/")
    .append(padDate(pAno)));
 }else {
   editdate.setText(
    new StringBuilder()
    .append(padDate(pDia)).append("/")
    .append(padDate(pMes+1)).append("/")
    .append(padDate(pAno)));
 }
  dataApontamento = padDate(pDia)+"/"+padDate(pMes)+"/"+padDate(pAno);
  dataApontamento2 = dataApontamento.toString();
  
}

/** Add padding to numbers less than ten */
private static String padDate(int d) {
  if (d >= 10)
    return String.valueOf(d);
  else
    return "0" + String.valueOf(d);
}

/** Create a new dialog for time picker */

protected Dialog onCreateDialog(int id) {
 AlertDialog myDialog = null;
 
 switch (id) {
  case DATE_DIALOG_ID:
  myDialog = new DatePickerDialog(this, mDateSetListener, pAno, pMes, pDia);
  break;
  
  case TIME_DIALOG_ID:
  myDialog = new TimePickerDialog(this, mTimeSetListener, pHour, pMinute, true);
  break;
  
}
return myDialog;
} 
    //#########HORAS APONTADAS - FIM#########//


public void mensagemExibir(String titulo,String texto){
	AlertDialog.Builder mensagem = new AlertDialog.Builder(Apontamentos.this);
	mensagem.setTitle(titulo);
	mensagem.setMessage(texto);
	mensagem.setNeutralButton("Ok",null);
	mensagem.show();
}

SQLiteDatabase database;






public void openOrCreateDatabase () {
	try {
		String name = "swsdb";
		database = openOrCreateDatabase(name, SQLiteDatabase.CREATE_IF_NECESSARY, null);
		//mensagemExibir("Banco de dados", "Banco de dados funcionando corretamente");
		
	}catch (Exception error) {
			mensagemExibir("Banco de dados", "Erro ao criar banco de dados: " +error.getMessage());
		
	}
	
	try {
		String CreateTableConsultants = Consultants.CreateTableConsultants;
		database.execSQL(CreateTableConsultants);
			//mensagemExibir ("Banco de dados", "Tabela Consultants criada corretamente");
	}catch (Exception error) {
			mensagemExibir("Banco de dados", "Erro ao criar Tabela Consultants: " +error.getMessage());
		
	}
	try {
		String CreateTablesProjects = Projects.CreateTableProjects;
		database.execSQL(CreateTablesProjects);
			//mensagemExibir ("Banco de dados", "Tabela Projects corretamente");
	}catch (Exception error) {
			 mensagemExibir("Banco de dados", "Erro ao criar Tabela Projects: " +error.getMessage());
	}
	try {		
		String CreateTableActivities = Activities.CreateTableActivities;
		database.execSQL(CreateTableActivities);
		//	mensagemExibir("Banco de dados", "Tabela Activities criada corretamente");
	}catch (Exception error) {
			mensagemExibir("Banco de dados", "Erro ao criar tabela CreateTableActivities: " +error.getMessage());
	}
	try {
		String CreateTableProjects_consultants = Project_consultants.CreateTableProject_consultants;
		database.execSQL(CreateTableProjects_consultants);
			//mensagemExibir("Banco de dados", "Tabela Projects_consultants criada corretamente");
	}catch (Exception error) {
			mensagemExibir("Banco de dados", "Erro ao criar tabela Projects_consultants: " +error.getMessage());
	}
	try {
		String CreateTableEntries = Entries.CreateTableEntries;
		// database.execSQL(CreateTableEntries);
			mensagemExibir("Banco de dados", "Tabela Entries criada corretamente");
	}catch (Exception error) {
			mensagemExibir("Banco de dados", "Erro ao criar tabela Entries: " +error.getMessage());
	}
	
	try {
		String teste = ".table;";
		database.execSQL(teste);
			mensagemExibir("Tableas criadas com sucesso", teste);
	}catch (Exception error) {
		//	mensagemExibir("Erro", "Erro ao criar tabelas" +error.getMessage());
	}
	
	
	
}



}