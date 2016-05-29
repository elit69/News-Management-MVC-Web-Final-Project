package Model.FrontEndDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import Model.DTO.ArticleDetail;
import Utilities.DatabaseConnection;

public class ArticleDAO {
	Connection con; /* Connection object */

	public ArticleDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean checkArticle(int news_id) throws SQLException,
			ClassNotFoundException {
		try {
			PreparedStatement clstm = con
					.prepareCall("Select news_id from tbnewsdetail where news_id = ?");
			clstm.setInt(1, news_id);
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

	public ArticleDetail getArticle(int news_id) throws SQLException,
			ClassNotFoundException {
		try {
			PreparedStatement clstm = con
					.prepareCall("select * from s_vw_news_content_ui where news_id = ?");
			clstm.setInt(1, news_id);
			ResultSet rs=clstm.executeQuery();
			if(rs.next()){
				ArticleDetail ad = new ArticleDetail();
				ad.setAuthor(rs.getString("ui"));
				ad.setImg_path(rs.getString("news_img"));
				ad.setNew_content(rs.getString("news_content"));
				ad.setNew_source(rs.getString("c"));
				ad.setNews_date(rs.getString("news_published_date"));
				ad.setNews_title(rs.getString("news_title"));				
				return ad;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}
	public void close() throws SQLException{
		con.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(new ArticleDAO().getArticle(1895).getAuthor());
		
/*		ResultSet rs=new ArticleDAO().getArticle(1653);
		ResultSetMetaData rsmd = rs.getMetaData();
		String name = rsmd.getColumnName(9);
		System.out.println(name);*/
	}	
}// End of class;

