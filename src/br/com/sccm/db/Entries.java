package br.com.sccm.db;

public class Entries {
	public static final String Id = "id";
	public static final String Title = "title";
	public static final String Date = "date";
	public static final String Type_hour = "type_hour";
	public static final String Type_consultancy = "type_consultancy";
	public static final String Consultant_id = "consultant_id";
	public static final String Activity_id = "Activity_id";
	
	
	
	public static final String CreateTableEntries = "CREATE IF NOT EXISTS TABLE Entries ("+
								  Id+" INTEGER PRIMARY_KEY, "+
								  Title+" TEXT, "+
								  Date+" TEXT, "+
								  Type_hour+" TEXT, "+
								  Type_consultancy+" TEXT, "+
								  Consultant_id+" TEXT, "+
								  Activity_id+" TEXT) "+
								  "CONSTRAINT Consultant_id REFERENCES Id(Consultants)" +
								  "CONSTRAINT Activity_id REFERENCES Id(Activities)";
	

}
