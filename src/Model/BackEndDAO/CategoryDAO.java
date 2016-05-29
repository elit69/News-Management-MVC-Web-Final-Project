package Model.BackEndDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.DTO.Category;
import Utilities.Convertor;
import Utilities.DatabaseConnection;
import Utilities.Logger;

/**
 * Class CategoryDAO Use For interact between Java and DBMS(tbcategory).
 */
public class CategoryDAO {
	Connection con; /* Connection object */
	PreparedStatement pstm;/* Prepared Statement object */

	/**
	 * Default Constructor Initialize object con by using class
	 * DatabaseConnection.
	 */
	public CategoryDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method insert() Use for insert data into tbcategory
	 * 
	 * @param category
	 *            is an DTO object of class Category
	 * @throws SQLException
	 * @return true for success and false for fail
	 */
	public boolean insert(Category category){

		try {
			pstm = con.prepareStatement(
					"INSERT INTO tbcategory(cat_code, parent_id, cat_name, cat_desc) VALUES(?, ?, ?, ?)");
			ResultSet rs = pstm.executeQuery();
			/* Initialize parameters for pstm object */
			pstm.setString(1, category.getCat_code());
			pstm.setInt(2, category.getParent_id());
			pstm.setString(3, category.getCat_name());
			pstm.setString(4, category.getCat_desc());

			return pstm.executeUpdate() > 0 ? true
					: false; /*
								 * return true for success and false if fail
								 */

		} catch (SQLException e) {
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, e.getMessage(), "CategoryDAO Connection");
			}
			

		}
		return false; /* return false if insert unsuccessful */
	}

	/**
	 * Method delete() Use for delete a record from tbcategory
	 * 
	 * @param categoryId
	 *            is ID of category
	 * @throws SQLException
	 * @return true for success and false for fail
	 */
	public boolean delete(int categoryId){
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("DELETE FROM tbcategory WHERE cat_id = ?;");
			/* Initialize parameter for pstm object */
			pstm.setInt(1, categoryId);

			return pstm.executeUpdate() > 0 ? true
					: false; /*
								 * return true for success and false if fail
								 */
		} catch (SQLException e) {
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		} finally {
			/* Close pstm and con */
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
			}
		
		}
		return false; /* return false if insert unsuccessful */
	}

	/**
	 * Method update() Use for update data into tbcategory
	 * 
	 * @param category
	 *            is an DTO object of class Category
	 * @throws SQLException
	 * @return true for success and false for fail
	 */
	public boolean update(Category category){
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement(
					"UPDATE tbcategory SET cat_code=?, parent_id=?, cat_name=?, cat_desc=? WHERE cat_id=?;");

			/* Initialize parameters for pstm object */
			pstm.setString(1, category.getCat_code());
			pstm.setInt(2, category.getParent_id());
			pstm.setString(3, category.getCat_name());
			pstm.setString(4, category.getCat_desc());
			pstm.setInt(5, category.getCat_id());
			//System.out.println(pstm.toString());
			return pstm.executeUpdate() > 0 ? true
					: false; /*
								 * return true for success and false if fail
								 */
		} catch (SQLException e) {
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		} finally {
			/* Close pstm and con */
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
			}
		
		}
		return false; /* return false if insert unsuccessful */
	}

	/**
	 * Method retrieve() Use for retrieve all data from tbcategory
	 * 
	 * @throws SQLException
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> retrieve(){
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		ArrayList<Category> categories = null; /*
												 * categories stores data of rs
												 */
		try {
			stm = con.createStatement(); /* Initialize stm */
			rs = stm.executeQuery(
					"SELECT * FROM tbcategory"); /*
													 * Execute query and assigns
													 * to rs
													 */
			categories = new ArrayList<>(); /* Initialize categories */
			while (rs.next()) { /* Add every record into categories */
				categories.add(new Category(rs.getInt("cat_id"), rs.getString("cat_code"), rs.getInt("parent_id"),
						rs.getString("cat_name"), rs.getString("cat_desc")));
			}

			return categories; /* return categories object */
		} catch (SQLException e) {
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		} finally {
			/* Close stm, rs and con */
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
			}
			// rs.close();
			
		}
		return null; /* Return null if error */
	}

	/**
	 * Method retrieveRS() Use for retrieve all data from tbcategory
	 * 
	 * @throws SQLException
	 * @return ResultSet
	 */
	public ResultSet retrieveRS(){
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		try {
			stm = con.createStatement(); /* Initialize stm */
			rs = stm.executeQuery(
					"SELECT * FROM tbcategory"); /*
													 * Execute query and assigns
													 * to rs
													 */
			return rs;
		} catch (SQLException e) {
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		} finally {
			// Close stm, rs and con
			try {
				stm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
			}
			// rs.close();
			
		}

		return null; /* Return null if error */
	}

	/**
	 * @throws SQLException
	 * 
	 * 
	 */
	public ResultSet resourceList(){
		Statement stm =null;
		ResultSet rs=null;
		try {
			stm= con.createStatement();
			rs = stm.executeQuery("select full_name from tbuserinfo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
			}
		}
		return rs;

	}

	public ResultSet categoryNameList(){
		Statement stm=null;
		ResultSet rs=null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery("select distinct(cat_name), cat_code from tbcategory");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				Logger.writeLogException(e2, e2.getMessage(), "CategoryDAO");
			}
		}
		
		return rs;

	}

	/*
	 * return category code
	 */
	public String returnCateCode(String data){ // ???????
		String catecode = null;
		try {
			CallableStatement clstm = con.prepareCall("{call category_code(?)}");
			clstm.setString(1, data);
			ResultSet rs = clstm.executeQuery();
			
			if (rs.next()) {
				catecode = rs.getString(1).toString();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				Logger.writeLogException(e2, e2.getMessage(), "CategoryDAO");
			}
		}
		
		return catecode;
		// return data;
	}

	public ResultSet manageCatUser(String data){
		CallableStatement clstm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		try {
			clstm = con.prepareCall(
					"{call manage_cat_user(?)}"); /* Initialize stm */
			clstm.setString(1, data);
			rs = clstm.executeQuery(); /*
										 * Execute query and assigns to rs
										 */
			return rs;
		} catch (SQLException e) {
			Logger.writeLogException(e, e.getMessage(), "CategoryDAO");
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				Logger.writeLogException(e2, e2.getMessage(), "CategoryDAO");
			}
		}

		return null; /* Return null if error */
	}


	/* Sarin updatestatus category */
	public boolean updatCatstatus(String cat_code, boolean cat_status) {
		try {
			pstm = con.prepareStatement("update tbcategory SET cat_status = ? where cat_code = ? ");

			pstm.setBoolean(1, cat_status);
			pstm.setString(2, cat_code);
			//System.out.println(cat_code + " " + cat_status);
			if (pstm.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}
}// End of class;
