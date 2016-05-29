package Model.BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.DTO.User;
import Utilities.Convertor;
import Utilities.DatabaseConnection;

/**
 * Class UserDAO Use For interact between Java and DBMS(tbuser).
 */
public class UserDAO {
	Connection con; /* Connection object */
	PreparedStatement pstm; /* Prepared Statement object */

	/**
	 * Default Constructor Initialize object con by using class
	 * DatabaseConnection.
	 */
	public UserDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Method insert() Use for insert data into tbuser
	 * 
	 * @param user
	 *            is an DTO object of class User
	 * @throws SQLException
	 * @return true for success and false for fail
	 */
	public boolean insert(User user) throws SQLException {
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("INSERT INTO tbuser(user_name, user_pass, user_type) VALUES(?, ?, ?);");
			/* Initialize parameters for pstm object */
			pstm.setString(1, user.getUser_name());
			pstm.setString(2, user.getUser_pass());
			pstm.setString(3, user.getUser_type());
			//System.out.println(pstm.toString());
			return pstm.executeUpdate() > 0 ? true
					: false; /* return true for success and false if fail */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* Close pstm and con */
			// pstm.close();
			con.close();
		}
		return false; /* return false if insert unsuccessful */
	}

	/**
	 * Method delete() Use for delete a record from tbuser
	 * 
	 * @param userId
	 *            is ID of User
	 * @throws SQLException
	 * @return true for success and false for fail
	 */
	public boolean delete(int userId) throws SQLException {
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("DELETE FROM tbuser WHERE user_id = ?;");
			/* Initialize parameter for pstm object */
			pstm.setInt(1, userId);
			return pstm.executeUpdate() > 0 ? true
					: false; /* return true for success and false if fail */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* Close pstm and con */
			pstm.close();
			con.close();
		}
		return false; /* return false if insert unsuccessful */
	}

	/**
	 * Method update() Use for update data into tbuser
	 * 
	 * @param user
	 *            is an DTO object of class User
	 * @throws SQLException
	 * @return true for success and false for fail
	 */
	public boolean update(User user) throws SQLException {
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("UPDATE tbuser SET user_name=?, user_pass=?, user_type=? WHERE user_id=?;");
			/* Initialize parameters for pstm object */
			pstm.setString(1, user.getUser_name());
			pstm.setString(2, user.getUser_pass());
			pstm.setString(3, user.getUser_type());
			pstm.setInt(4, user.getUser_id());

			return pstm.executeUpdate() > 0 ? true
					: false; /* return true for success and false if fail */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* Close pstm and con */
			pstm.close();
			con.close();
		}
		return false; /* return false if update unsuccessful */
	}

	/**
	 * Method retrieve() Use for retrieve all data from tbuser
	 * 
	 * @throws SQLException
	 * @return ArrayList<CategoryParent>
	 */
	public ResultSet listTypeUser() throws SQLException {
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		try {
			stm = con
					.createStatement(); /* Statement for Query Data from DBMS */
			rs = stm.executeQuery(
					"SELECT distinct user_type FROM tbuser;"); /*
																 * rs stores all
																 * records of
																 * query
																 */
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method retrieveRS() Use for retrieve all data from tbuser
	 * 
	 * @throws SQLException
	 * @return ResultSet
	 */
	public ResultSet retrieveRS() throws SQLException {
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		try {
			stm = con
					.createStatement(); /* Statement for Query Data from DBMS */
			rs = stm.executeQuery(
					"SELECT * FROM tbuser;"); /*
												 * rs stores all records of query
												 */
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close stm, rs and con
			// stm.close();
			// rs.close();
			con.close();
		}
		return null; /* Return null if error */
	}

	public ResultSet uFind(int id) throws SQLException {
		String sql = "select * from tbuser where user_id=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, id);
		return pstm.executeQuery();
	}

	/*
	 * public boolean userLogin(String userName, String password) throws
	 * SQLException{ pstm = con.prepareStatement("SELECT login_user (?, ?);");
	 * pstm.setString(1, userName); pstm.setString(2, password); ResultSet rs =
	 * pstm.executeQuery(); rs.next(); System.out.println("Get Rows:" +
	 * rs.getRow()); return rs.getRow()>0?true:false; }
	 */
	/* Sarin */
	public String userLogin(String userName, String password) throws SQLException {
		pstm = con.prepareStatement("SELECT * FROM tbuser WHERE user_name=? and user_pass=? and user_status='true';");
		pstm.setString(1, userName);
		pstm.setString(2, password);

		ResultSet rs = pstm.executeQuery();
		rs.next();
		if (rs.getRow() > 0) {
			//System.out.println("has row");
			return rs.getString("user_type");
		}
		// System.out.println("Get Rows:" + rs.getString("user_type"));
		// return rs.getRow()>0?true:false;
		return null;
	}

	/* sarin editUserStatus */
	public boolean editUserStatus(int user_id, boolean user_status) throws SQLException {
		pstm = con.prepareStatement("update tbuser SET user_status = ? where user_id = ? ");
		pstm.setBoolean(1, user_status);
		pstm.setInt(2, user_id);
		//System.out.println(user_id + " " + user_status);
		if (pstm.executeUpdate() > 0) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) throws SQLException, Exception {
		//System.out.println(Convertor.convertResultSetIntoJSON(new UserDAO().retrieveRS()));
	}
}// End of class;
