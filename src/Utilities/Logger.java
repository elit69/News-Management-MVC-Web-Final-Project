package Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Logger {
	private static Logger logger = null;
	public static String logFileName = "article.log";
	public static String errorLogFileName = "error.log";
	private static String path;

	private Logger() {
	}

	
	 public static void setPath(String paths) { path = paths+"\\Logs"; }
	 

	public static Logger getLogger() {
		if (logger == null)
			logger = new Logger();
		return logger;
	}

	public void writeLogCreateNewDatabase(String dbName) {
		try (BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true))) {
			output.write(currentDate() + ":\t Create New Database \"" + dbName + "\"");
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeLogRestoreDatabase(String backUpFileName) {
		try (BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true))) {
			output.write(currentDate() + ":\t Restore Database from \"" + backUpFileName + "\"");
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeLogBackUpDatabase(String backUpFileName) {
		try (BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true))) {
			output.write(currentDate() + ":\t BackUp Database to \"" + backUpFileName + "\"");
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeLogOpenDatabase(String dbName) {
		try (BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true))) {
			output.write(currentDate() + ":\t Open Database Name \"" + dbName + "\"");
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeLogAdd(int id) {
		try (BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true))) {
			output.write(currentDate() + ":\t ADDNEW Record ID " + id);
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeLogUpdate(int id, String fieldName) {
		try (BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true))) {
			output.write(currentDate() + ":\t UPDATE Record ID " + id + " with FIELDNAME \"" + fieldName + "\"");
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeLogDelete(int id) {
		try (BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true))) {
			output.write(currentDate() + ":\t DELETE Record ID " + id);
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeLogException(Exception ex, String methodName, String className) {
		System.err.println("Error : "+ path);
		try (BufferedWriter output = new BufferedWriter(new FileWriter(path+"//"+errorLogFileName, true))) {
			output.write(currentDate() + ":\t" + ex + " in METHOD \"" + methodName + "\" CLASS \"" + className + "\"");
			output.write(System.getProperty("line.separator"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String currentDate() {
		return new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new Date());
	}

	/*public static void main(String args[]) {

		try {
			System.out.println(1221);
			throw new Exception();
		} catch (Exception ex) {
			writeLogException(ex, "sdf", "asdafdsf");
		}
	}*/

}
