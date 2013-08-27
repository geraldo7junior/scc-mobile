package br.com.sccm;

public class Projects {
	public static final String Id = "id";
	public static final String Name = "name";
	
	public static final String CreateTableProjects = "CREATE TABLE IF NOT EXISTS Projects ("+Id+" INTEGER PRIMARY KEY NOT NULL, " +
																							Name+" TEXT NOT NULL);";
	
	public static final String PopulatedTablesProjects = "INSERT INTO TABLE Projects ('"+Name+"') VALUES" +
															"(Recife), (Maringa), (Aplic)";

}


