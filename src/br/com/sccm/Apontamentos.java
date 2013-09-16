package br.com.sccm;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Apontamentos extends BaseMenu {
	Spinner sp;
	String radioTipoHora;
	String horaApontada;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apontamentos);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
/*		sp=(Spinner) findViewById(R.id.listprojetos);
		
		ArrayAdapter<CharSequence> ar= ArrayAdapter.createFromResource(this, R.array.projeto, android.R.layout.simple_list_item_1);
		
		ar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(ar);
		
		sp=(Spinner) findViewById(R.id.listatividades);
		
		ArrayAdapter<CharSequence> arr= ArrayAdapter.createFromResource(this, R.array.atividades, android.R.layout.simple_list_item_1);
		
		arr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(arr);*/
		
		
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
  }
  
  public void onRadioButtonClicked(View view) {
		//Tá selecionado?
    boolean checked = ((RadioButton) view).isChecked();
    
		//Selecionada cada botao quando clicado
    switch(view.getId()) {
     case R.id.tipoa:
	
		if (checked)
					//Tipo A
			radioTipoHora = "tipoA";
		Toast.makeText(Apontamentos.this, radioTipoHora, Toast.LENGTH_LONG).show();
     break;
     case R.id.tipob:
     if (checked)
					//Tipo B
    	 radioTipoHora = "tipoB";
       Toast.makeText(Apontamentos.this, radioTipoHora, Toast.LENGTH_SHORT).show();
     break;
     case R.id.tipoc:
     if (checked)
					//Tipo C
    	 radioTipoHora = "tipoC";
       Toast.makeText(Apontamentos.this, radioTipoHora, Toast.LENGTH_SHORT).show();
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
  //TextView horaAp = (TextView) findViewById(R.id.timeDisplay);
  //horaApontada = horaAp.getText().toString();
  //Toast.makeText(Apontamentos.this, horaApontada, Toast.LENGTH_LONG).show();
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

}
