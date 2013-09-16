package br.com.sccm.db;

public class Project_consultants {
	
	public static final String Project_id = "Project_id";
	public static final String Consultant_id = "Consultant_id";
	
	
	public static final String CreateTableProject_consultants = "CREATE TABLE IF NOT EXISTS Project_consultants (" +
			                                                     Project_id+" INTEGER NOT NULL, "+Consultant_id+" " +
			                                                     "INTEGER NOT NULL CONSTRAINT "+Project_id+" REFERENCES " +
			                                                     "Id (Projects) CONSTRAINT "+Consultant_id+" REFERENCES " +
			                                                     "Id (Consultants));";
	

}
