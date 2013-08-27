package br.com.sccm;

public class Activities {
	
	public static final String Id = "Id";
	public static final String Name = "Name";
	public static final String Project_id = "Project_id";
	public static final String Consultant1_id = "Consultant1_id";
	public static final String Consultant2_id = "Consultant2_id";
	public static final String Consultant3_id = "Consultant3_id";
	public static final String Consultant4_id = "Consultant4_id";
	
	public static final String CreateTableActivities = "CREATE TABLE IF NOT EXISTS Activities ("+Id+" INTEGER PRIMARY KEY NOT NULL, "+
														Name+" TEXT NOT NULL, "+Consultant1_id+" INTEGER, "+Consultant2_id+" INTEGER, " +
														Consultant3_id+" INTEGER, "+Consultant4_id+" INTEGER, "+Project_id+" INTEGER NOT NULL " +
														"CONSTRAINT "+Project_id+" REFERENCES Id (Projects));";
	
	public static final String PopulatedTableActivities = "";
	

}
