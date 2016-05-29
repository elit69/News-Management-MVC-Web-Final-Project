package Model.FrontEndDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utilities.DatabaseConnection;

public class CategoryDAO {
	Connection con; /* Connection object */

	public CategoryDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean checkCategory(String categoryCode) throws SQLException,
			ClassNotFoundException {
		try {
			PreparedStatement clstm = con
					.prepareCall("Select cat_code from tbcategory where cat_code = ?");
			clstm.setString(1, categoryCode);
			ResultSet rs = clstm.executeQuery();
			if (rs.next())
				return true;
			return false;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			con.close();
		}
		return false;
	}
	//add method from backendDAo
	/* return resultset with cat_code and cat_name*/
	public ResultSet listCatcodeCatName() throws SQLException {
		Statement stm=con.createStatement();
		return stm.executeQuery("select cat_code, cat_name from tbcategory");
	}
	public ResultSet resourceList() throws SQLException {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select full_name from tbuserinfo");
		return rs;

	}
	public ResultSet manageCatUser(String data) throws SQLException {
		CallableStatement clstm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		try {
			clstm = con.prepareCall("{call manage_cat_user(?)}"); /* Initialize stm */
			clstm.setString(1, data);
			rs = clstm.executeQuery(); /*
																 * Execute query
																 * and assigns
																 * to rs
																 */
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} /*finally {
			// Close stm, rs and con
			clstm.close();
			// rs.close();
			//con.close();
		}*/

		return null; /* Return null if error */
	}
	public void close() throws SQLException {
		con.close();
	}

}// End of class;

