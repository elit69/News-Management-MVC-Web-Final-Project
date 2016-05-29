package Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.State;

import Controller.BackEnd.sub.newsCategory;
import Model.DTO.exchangeRateDTO;

public class postgresAccount {
	private Connection con;

	public postgresAccount() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int destroyConnection() {
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"SELECT pg_terminate_backend(pg_stat_activity.pid)FROM pg_stat_activity WHERE datname = current_database()  AND pid <> pg_backend_pid();");
			int i=0;
			while(rs.next()){
				i++;
			}
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int countUserPostgres() {
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from pg_stat_activity");
			int i = 0;
			while (rs.next()) {
				i++;
			}
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		
		System.out.println(new postgresAccount().countUserPostgres());
		//System.out.println(new postgresAccount().destroyConnection());
	}
}
