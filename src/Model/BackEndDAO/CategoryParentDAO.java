package Model.BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.DTO.CategoryParent;
import Utilities.DatabaseConnection;

/**
 * Class CategoryParentDAO
 * Use For interact between Java and DBMS(tbcategoryparent). 
 */
public class CategoryParentDAO {
	Connection con; /* Connection object */
	PreparedStatement pstm; /* Prepared Statement object */
	
	/**
	 * Default Constructor
	 * Initialize object con by using class DatabaseConnection.
	 * */
	public CategoryParentDAO(){
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method insert()
	 * Use for insert data into tbcategoryparent
	 * @param categoryParent is an DTO object of class CategoryParent 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean insert(CategoryParent categoryParent){
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("INSERT INTO tbcategoryparent(parent_desc) VALUES(?)");
			
			/* Initialize parameters for pstm object */
			pstm.setString(1, categoryParent.getParent_desc());
			
			return pstm.executeUpdate()>0?true:false; /* return true for success and false if fail */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			/* Close pstm and con */
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false; /* return false if insert unsuccessful */
	}

	/**
	 * Method delete()
	 * Use for delete a record from tbcategoryparent
	 * @param parentId is ID of category 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean delete(int parentId){
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("DELETE FROM tbcategoryparent WHERE parent_id = ?;");
			/* Initialize parameter for pstm object */
			pstm.setInt(1, parentId);
			return pstm.executeUpdate()>0?true:false; /* return true for success and false if fail */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			/* Close pstm and con */
			
			try {
				pstm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return false; /* return false if insert unsuccessful */
	}
	
	/**
	 * Method update()
	 * Use for update data into tbcategoryparent
	 * @param categoryParent is an DTO object of class CategoryParent 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean update(CategoryParent categoryParent){
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("UPDATE tbcategoryparent SET parent_desc=? WHERE parent_id=?;");
			/* Initialize parameters for pstm object */
			pstm.setString(1, categoryParent.getParent_desc());
			pstm.setInt(2, categoryParent.getParent_id());
			
			return pstm.executeUpdate()>0?true:false; /* return true for success and false if fail */
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally{
			/* Close pstm and con */
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false; /* return false if update unsuccessful */
	}
	
	/**
	 * Method retrieve()
	 * Use for retrieve all data from tbcategoryparent
	 * @throws SQLException
	 * @return ArrayList<CategoryParent>
	 * */
	public ArrayList<CategoryParent> retrieve(){
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		ArrayList<CategoryParent> categoryParents = null; /* categoryParents stores data of rs */
		try {
			stm = con.createStatement(); /* Statement for Query Data from DBMS */
			rs = stm.executeQuery("SELECT * FROM tbcategoryparent"); /* rs stores all records of query */
			categoryParents = new ArrayList<>(); /* categoryParent stores data of rs */
			while(rs.next()){ /* Add every record into categoryParents */
				categoryParents.add(new CategoryParent(rs.getInt("parent_id"), rs.getString("parent_desc")));
			}
			
			return categoryParents; /* return categoryParent object */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			/* Close stm, rs and con */
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//rs.close();
			
		}
		return null; /* Return null if error */
	}

	/**
	 * Method retrieveRS()
	 * Use for retrieve all data from tbcategoryparent
	 * @throws SQLException
	 * @return ResutlSet 
	 * */
	public ResultSet retrieveRS(){
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		try {
			stm = con.createStatement(); /* Statement for Query Data from DBMS */
			rs = stm.executeQuery("SELECT * FROM tbcategoryparent"); /* rs stores all records of query */
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			/* Close stm, rs and con */
			try {
				stm.close();
				//rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null; /* Return null if error */
	}
}//End of class;








