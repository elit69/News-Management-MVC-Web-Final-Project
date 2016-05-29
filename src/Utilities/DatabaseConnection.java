package Utilities;
import java.sql.*;

public class DatabaseConnection {
	private static String DRIVER_NAME = "org.postgresql.Driver";	
	private static String PORT_NUMBER = "5432";
	
	
	/*HEROKU Db*/
	/*private static String URL = "jdbc:postgresql://ec2-54-83-58-191.compute-1.amazonaws.com:";
	private static String DB_NAME = "ddk1idr8ftn2ql";	
	private static String USER_NAME = "hmmvpnwwetweud";
	private static String PASSWORD = "843k_9eX2OJRdQA9WNHCgoeq5g";*/
	
	/*HRD Db*/
	private static String URL = "jdbc:postgresql://192.168.178.155:";
	private static String DB_NAME = "newsmanagement";
	private static String USER_NAME = "postgres";
	private static String PASSWORD = "123";
	
	/*Local Db*/
	/*private static String URL = "jdbc:postgresql://localhost:";
	private static String DB_NAME = "K12346";	
	private static String USER_NAME = "postgres";
	private static String PASSWORD = "0231";*/
	/**
	 * Deny object initialization
	 */
	private DatabaseConnection() {System.out.println("{Connting to localhost}");}
	
	/**
	 * connect to database
	 * 
	 * @return object connection to a database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(URL + PORT_NUMBER + "/"
				+ DB_NAME, USER_NAME, PASSWORD);
		return con;
	}	
	
	//###########################################setter&getter#######################################
	public static String getDRIVER_NAME() {
		return DRIVER_NAME;
	}

	public static void setDRIVER_NAME(String dRIVER_NAME) {
		DRIVER_NAME = dRIVER_NAME;
	}

	public static String getURL() {
		return URL;
	}
	
	public static void setURL(String uRL) {
		URL = uRL;
	}
	
	public static String getPORT_NUMBER() {
		return PORT_NUMBER;
	}
	
	public static void setPORT_NUMBER(String pORT_NUMBER) {
		PORT_NUMBER = pORT_NUMBER;
	}
	
	public static String getDB_NAME() {
		return DB_NAME;
	}
	
	public static void setDB_NAME(String dB_NAME) {
		DB_NAME = dB_NAME;
	}
	
	public static String getUSER_NAME() {
		return USER_NAME;
	}
	
	public static void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	
	public static String getPASSWORD() {
		return PASSWORD;
	}
	
	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	System.out.println(DatabaseConnection.getConnection().getMetaData().getDatabaseProductName());
		
	}
}