package Model.BackEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.DTO.NewsDetail;
import Utilities.DatabaseConnection;

/**
 * Class NewsDetailDAO
 * Use For interact between Java and DBMS(tbnewsdetail). 
 */
public class NewsDetailDAO {
	
	Connection con; /* Connection object */
	PreparedStatement pstm; /* Prepared Statement object */
	
	/**
	 * Default Constructor
	 * Initialize object con by using class DatabaseConnection.
	 * */
	public NewsDetailDAO(){
		try {
			con=DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method insert()
	 * Use for insert data into tbnewsdetail
	 * @param newsDetail is an DTO object of class NewDetail 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean insert(NewsDetail newsDetail) throws SQLException{
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("INSERT INTO tbnewsdetail(news_id, news_content) VALUES(?, ?);");
			/* Initialize parameters for pstm object */
			pstm.setInt(1, newsDetail.getNews_id());
			pstm.setString(2, newsDetail.getNew_content());
			
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
	 * Use for delete a record from tbnewsDetail
	 * @param newsDetailId is ID of category 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean delete(int newsDetailId) throws SQLException{
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("DELETE FROM tbnewsdetail WHERE news_detail_id = ?;");
			/* Initialize parameter for pstm object */
			pstm.setInt(1, newsDetailId);
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
	 * Use for update data into tbnewsdetail
	 * @param newsDetail is an DTO object of class NewsDetail 
	 * @throws SQLException
	 * @return true for success and false for fail 
	 * */
	public boolean update(NewsDetail newsDetail) throws SQLException{
		try {
			/* Set PreparedStatement */
			pstm = con.prepareStatement("UPDATE tbnewsdetail SET news_id=?, news_content=? WHERE news_detail_id=?;");
			/* Initialize parameters for pstm object */
			pstm.setInt(1, newsDetail.getNews_id());
			pstm.setString(2, newsDetail.getNew_content());
			pstm.setInt(3, newsDetail.getNews_detail_id());			
			//System.out.println(pstm.toString());
		
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
	 * Use for retrieve all data from tbnewdetail
	 * @throws SQLException
	 * @return ArrayList<CategoryParent>
	 * */
	public ArrayList<NewsDetail> retrieve() throws SQLException{
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		ArrayList<NewsDetail> newsDetails = null; /* newsDetails stores data of rs */
		try {
			stm = con.createStatement(); /* Statement for Query Data from DBMS */
			rs = stm.executeQuery("SELECT * FROM tbnewsdetail;"); /* rs stores all records of query */
			newsDetails = new ArrayList<>();
			while(rs.next()){ /* Add every record into newsDetail */
				newsDetails.add(new NewsDetail(rs.getInt("news_detail_id"),
											   rs.getInt("news_id"),
											   rs.getString("news_content")));
			}
			
			return newsDetails; /* return newDetail object */
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
	/**
	 * Method retrieveRS()
	 * Use for retrieve all data from tbnewdetail
	 * @throws SQLException
	 * @return ArrayList<CategoryParent>
	 * */
	public ResultSet retrieveRS() throws SQLException{
		Statement stm = null; /* Statement for Query Data from DBMS */
		ResultSet rs = null; /* rs stores all records of query */
		try {
			stm = con.createStatement(); /* Statement for Query Data from DBMS */
			rs = stm.executeQuery("SELECT * FROM tbnewsdetail;"); /* rs stores all records of query */
			return rs;
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












