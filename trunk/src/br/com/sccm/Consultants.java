package br.com.sccm;

public class Consultants {
	public static final String Id = "id";
	public static final String Name = "name";
	public static final String Username = "username";
	public static final String Password = "password";

	public static String CreateTableConsultants = "CREATE TABLE IF NOT EXISTS Consultants ("+Id+" INTEGER NOT NULL PRIMARY KEY, " +
			                                                                  Name+" TEXT NOT NULL," +
			                                                                  Username+" TEXT NOT NULL, " +
			                                                                  Password+" TEXT NOT NULL);";
	
	public static String PopulatedTableConsultants = "INSERT INTO Consultants ('"+Name+"','"+Username+"','"+Password+"') values" +
													   "(Rose Farrell Keller, rose, 123)," +
													   "(Admin, admin, admin)";

	


}
