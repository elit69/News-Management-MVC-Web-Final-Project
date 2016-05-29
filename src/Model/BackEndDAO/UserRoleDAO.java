package Model.BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.DTO.UserRole;
import Utilities.DatabaseConnection;


/**
 * Class UserRoleDAO
 * Use For interact between Java and DBMS(tbuserrole). 
 */
public class UserRoleDAO {
	Connection con; /* Connection object */
	PreparedStatement pstm; /* Prepared Statement object */
	
	/**
	 * Default Constructor
	 * Initialize object con by using class DatabaseConnection.
	 * */
	public UserRoleDAO(){
		try {
			con=DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method insert()
	 * Use for insert data into tbuserrole
	 * @param userRole is an DTO object of class UserRole
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean insert(UserRole userRole) throws SQLException{
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("INSERT INTO tbuserrole(user_type, user_desc) VALUES(?, ?);");
			/* Initialize parameters for pstm object */
			pstm.setString(1, userRole.getUser_type());
			pstm.setString(2, userRole.getUser_desc());
			
			return pstm.executeUpdate()>0?true:false; /* return true for success and false if fail */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			/* Close pstm and con */
			pstm.close();
			con.close();
		}
		return false; /* return false if insert unsuccessful */
	}
	
	/**
	 * Method delete()
	 * Use for delete a record from tbuserrole
	 * @param userRoleId is ID of UserInfo 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean delete(int userRoleId) throws SQLException{
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("DELETE FROM tbuserrole WHERE user_role_id = ?;");
			/* Initialize parameter for pstm object */
			pstm.setInt(1, userRoleId);
			
			return pstm.executeUpdate()>0?true:false; /* return true for success and false if fail */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			/* Close pstm and con */
			pstm.close();
			con.close();
		}
		return false; /* return false if insert unsuccessful */
	}
	
	/**
	 * Method update()
	 * Use for update data into tbuserrole
	 * @param userRole is an DTO object of class UserRole 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean update(UserRole userRole) throws SQLException{
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("UPDATE tbuserrole SET user_type=?, user_desc=? WHERE user_role_id=?;");
			/* Initialize parameters for pstm object */
			pstm.setString(1, userRole.getUser_type());
			pstm.setString(2, userRole.getUser_desc());
			pstm.setInt(3, userRole.getUser_role_id());
			
		
			return pstm.executeUpdate()>0?true:false; /* return true for success and false if fail */
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally{
			/* Close pstm and con */
			pstm.close();
			con.close();
		}
		return false; /* return false if update unsuccessful */
	}
	
	/**
	 * Method retrieve()
	 * Use for retrieve all data from tbuserrole
	 * @throws SQLException
	 * @return ArrayList<News>
	 * */
	public ArrayList<UserRole> retrive() throws SQLException{
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		ArrayList<UserRole> userRoles = null; /* userRoles stores data of rs */
		try {
			stm = con.createStatement(); /* Statement for Query Data from DBMS */
			rs = stm.executeQuery("SELECT * FROM tbuserrole"); /* rs stores all records of query */
			userRoles = new ArrayList<>();
			while(rs.next()){ /* Add every record into userRoles */
				userRoles.add(new UserRole(rs.getInt("user_role_id"),
										   rs.getString("user_type"),
										   rs.getString("user_desc")));
			}
			
			return userRoles; /* return userRoles object */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			/* Close stm, rs and con */
			stm.close();
			//rs.close();
			con.close();
		}
		return null; /* Return null if error */
	}
	
}//End of class;












