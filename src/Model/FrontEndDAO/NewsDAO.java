package Model.FrontEndDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utilities.Convertor;
import Utilities.DatabaseConnection;
import Utilities.Logger;

public class NewsDAO {
	Connection con; /* Connection object */
	public NewsDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet listNewsCategoryByDaily(String categoryCode, int limit, int offset){
		try{
			CallableStatement clstm = con.prepareCall("{call s_show_news_category_by_daily(?, ?, ?)}");
			clstm.setString(1, categoryCode);
			clstm.setInt(2, limit);
			clstm.setInt(3, offset);
			ResultSet rs = clstm.executeQuery();
			//rs.next();
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "listNewsCategoryByDaily", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	
	public ResultSet listNewsCategoryByWeekly(String categoryCode, int limit, int offset){
		try{
			CallableStatement clstm = con.prepareCall("{call s_show_news_category_by_weekly(?, ?, ?)}");
			clstm.setString(1, categoryCode);
			clstm.setInt(2, limit);
			clstm.setInt(3, offset);
			ResultSet rs = clstm.executeQuery();
			//rs.next();
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "listNewsCategoryByWeekly", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	
	public ResultSet listNewsCategoryByMonthly(String categoryCode, int limit, int offset){
		try{
			CallableStatement clstm = con.prepareCall("{call s_show_news_category_by_all(?, ?, ?)}");
			clstm.setString(1, categoryCode);
			clstm.setInt(2, limit);
			clstm.setInt(3, offset);
			ResultSet rs = clstm.executeQuery();
			//rs.next();
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "listNewsCategoryByMonthly", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	
	public ResultSet searchNewsFilterTime(String newsTitle, String categoryCode, String userInfoCode, String timeFilter, int limit, int offset){
		try{
			CallableStatement clstm = con.prepareCall("{call e_search_news_filter_time(?, ?, ?, ?, ?, ?)}");
			clstm.setString(1, newsTitle);
			clstm.setString(2, categoryCode);
			clstm.setString(3, userInfoCode);
			clstm.setString(4, timeFilter);
			clstm.setInt(5, limit);
			clstm.setInt(6, offset);
			//System.out.println(clstm.toString());
			ResultSet rs = clstm.executeQuery();
			//rs.next();
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "searchNewsFilterTime", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "connection", "NewsDAO");
			}
		}
		return null;
	}
	public ResultSet getPopularNews(){
		try{
			CallableStatement clstm = con.prepareCall("{call s_vw_news_popular}");
		
			//System.out.println(clstm.toString());
			ResultSet rs = clstm.executeQuery();
			//rs.next();
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "getPopularNews", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	public ResultSet getRecommendNews(){
		try{
			CallableStatement clstm = con.prepareCall("{call s_vw_news_recommend}");
			ResultSet rs = clstm.executeQuery();
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "getRecommendNews", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "getRecommendNews", "NewsDAO");
			}
		}
		return null;
	}
	public ResultSet countNewsByCatCodeDaily(String categoryCode){
		try{
			CallableStatement clstm = con.prepareCall("{CALL s_count_news_by_catcode_daily(?)}");
			clstm.setString(1, categoryCode);
			ResultSet rs = clstm.executeQuery();
			
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "countNewsByCatCodeDaily", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	
	public ResultSet countNewsByCatCodeMonthly(String categoryCode){
		try{
			CallableStatement clstm = con.prepareCall("{CALL s_count_news_by_catcode_monthly(?)}");
			clstm.setString(1, categoryCode);
			ResultSet rs = clstm.executeQuery();
			
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "countNewsByCatCodeMontly", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	
	public ResultSet countNewsByCatCodeWeekly(String categoryCode){
		try{
			CallableStatement clstm = con.prepareCall("{CALL s_count_news_by_catcode_weekly(?)}");
			clstm.setString(1, categoryCode);
			ResultSet rs = clstm.executeQuery();
			
			return rs;
		}catch(SQLException ex){
			Logger.writeLogException(ex, "countNewsByCatCodeWeekly", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	
	//add methods from backendDAO
	public ResultSet listRecentNews(int data){
		// TODO Auto-generated method stub
		try {
			CallableStatement clstm = con.prepareCall("{call news_slider(?)}");
			clstm.setInt(1, data);
			ResultSet rs = clstm.executeQuery();
			//rs.next();
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "ListRecentNews", "NewsDAO");
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	public void countView(int newid, int count){
		// TODO Auto-generated method stub
		try{
		CallableStatement clstm = con.prepareCall("{call add_counter(?, ?)}");
		clstm.setInt(1, newid);
		clstm.setInt(2, count);
		clstm.executeQuery();
		}catch(Exception e){
			Logger.writeLogException(e, "CountView", "NewsDAO");
		}finally{
			try{
				con.close();
			}catch(SQLException e){
			Logger.writeLogException(e, "ListRecentNews", "NewsDAO");
			}
		}
	}
	
	public ResultSet showNewsCategoryTop(String categoryCode){
		try{
			CallableStatement clstm = con.prepareCall("{CALL s_show_news_category_top(?)}");
			clstm.setString(1, categoryCode);
			ResultSet rs = clstm.executeQuery();
			
			return rs;
		}catch(SQLException ex){
			//Logger.writeLogException(ex, "ShowNewsCategoryTop", "NewsDAO");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//Logger.writeLogException(e, "Connection", "NewsDAO");
			}
		}
		return null;
	}
	
	public void close() throws SQLException{
		con.close();
	}
	public static void main(String[] args) throws Exception {
		System.out.println(Convertor.convertResultSetIntoJSON(new NewsDAO().listNewsCategoryByMonthly("B030101",11,0)));
	}
	
}// End of class;










