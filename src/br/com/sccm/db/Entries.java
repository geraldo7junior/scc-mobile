package br.com.sccm;

public class Entries {
	public static final String Id = "id";
	public static final String Project_name = "project_name";
	public static final String Activity_name = "activity_name";
	public static final String Title = "title";
	public static final String Date = "date";
	public static final String Hour = "hour";
	public static final String Type_hour = "type_hour";
	public static final String Type_consultancy = "type_consultancy";

	
	
	
	public static final String CreateTableEntries = "CREATE TABLE Entr ("+
								  Id+" INTEGER PRIMARY_KEY, "+
								  Project_name+" TEXT, "+
								  Activity_name+" TEXT, "+
								  Title+" TEXT, "+
								  Date+" TEXT, "+
								  Hour+" TEXT, "+
								  Type_hour+" TEXT, "+
								  Type_consultancy+" TEXT)";
								  
								//  "CONSTRAINT Consultant_id REFERENCES Id(Consultants)" +
								//  "CONSTRAINT Activity_id REFERENCES Id(Activities)";
	

}
