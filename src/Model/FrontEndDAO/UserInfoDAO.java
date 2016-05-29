package Model.FrontEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utilities.DatabaseConnection;
import Utilities.Logger;

public class UserInfoDAO {
	Connection con; /* Connection object */
	PreparedStatement pstm; /* Prepared Statement object */

	/**
	 * Default Constructor Initialize object con by using class
	 * DatabaseConnection.
	 */
	public UserInfoDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			Logger.writeLogException(e, "UserInfoDAO", "UserInfoDAO");
		}
	}

	public ResultSet listuserCodeName() {

		try {
			Statement stm = con.createStatement();
			return stm.executeQuery("select user_info_code, full_name from tbuserinfo");
		} catch (Exception e) {
			Logger.writeLogException(e, "listuserCodeName", "UserInfoDAO");
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				Logger.writeLogException(e, "Connection", "UserInfoDAO");
			}
		}
		return null;
	}

	public void close() throws SQLException {
		con.close();
	}
}
