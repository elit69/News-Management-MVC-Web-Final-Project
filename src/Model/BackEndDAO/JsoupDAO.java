package Model.BackEndDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.DTO.exchangeRateDTO;
import Model.DTO.jobDTO;
import Model.DTO.scholarshipDTO;
import Utilities.Convertor;
import Utilities.DatabaseConnection;

public class JsoupDAO {
	private Connection con;

	public JsoupDAO() {
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

	public boolean insertJob(ArrayList<jobDTO> alistjdto) {
		java.sql.PreparedStatement pstm = null;
		try {
			pstm = con
					.prepareStatement("insert into tbmyjob(title,company,close_date,category,link) values(?,?,?,?,?)");
			for (jobDTO jobDTO : alistjdto) {
				pstm.setString(1, jobDTO.getTitle());
				pstm.setString(2, jobDTO.getCompany());
				pstm.setString(3, jobDTO.getCloseDate());
				pstm.setString(4, jobDTO.getCategory());
				pstm.setString(5, jobDTO.getLink());
				pstm.executeUpdate();
			}
			return true;
		} catch (Exception e) {

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
	
	public boolean updateJob(ArrayList<jobDTO> alistjdto) {
		java.sql.PreparedStatement pstm = null;
		try {
			pstm = con
					.prepareStatement("update tbmyjob set title=?,company=?,close_date=?,category=?,link=? where id=?");
			int i=0;
			for (jobDTO jobDTO : alistjdto) {
				pstm.setString(1, jobDTO.getTitle());
				pstm.setString(2, jobDTO.getCompany());
				pstm.setString(3, jobDTO.getCloseDate());
				pstm.setString(4, jobDTO.getCategory());
				pstm.setString(5, jobDTO.getLink());
				pstm.setInt(6, i++);
				pstm.executeUpdate();
			}
			return true;
		} catch (Exception e) {

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
	
	public ResultSet retrievJobs() {
		try {
			Statement stm = con.createStatement();
			return stm.executeQuery("select * from tbmyjob");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public boolean insertScholarship(ArrayList<scholarshipDTO> asdto) {
		java.sql.PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(
					"insert into tbscholarship(title,description,posted,deadline,link) values(?,?,?,?,?)");
			for (scholarshipDTO scholarshipDTO : asdto) {
				pstm.setString(1, scholarshipDTO.getTitle());
				pstm.setString(2, scholarshipDTO.getDescription());
				pstm.setString(3, scholarshipDTO.getPosted());
				pstm.setString(4, scholarshipDTO.getDeadline());
				pstm.setString(5, scholarshipDTO.getLink());
				pstm.executeUpdate();
			}
			return true;
		} catch (Exception e) {

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

	public ResultSet retrievScholarship() {
		try {
			Statement stm = con.createStatement();
			return stm.executeQuery("select * from tbscholarship");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean updateScholarship(ArrayList<scholarshipDTO> asdto) {
		java.sql.PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(
					"update tbscholarship set title=?,description=?,posted=?,deadline=?,link=? where id=?");
			int i=0;
			for (scholarshipDTO scholarshipDTO : asdto) {
				pstm.setString(1, scholarshipDTO.getTitle());
				pstm.setString(2, scholarshipDTO.getDescription());
				pstm.setString(3, scholarshipDTO.getPosted());
				pstm.setString(4, scholarshipDTO.getDeadline());
				pstm.setString(5, scholarshipDTO.getLink());
				pstm.setInt(6, 60+i);
				pstm.executeUpdate();
				i++;
			}
			return true;
		} catch (Exception e) {

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
	
	
	public boolean insertExchange(ArrayList<exchangeRateDTO> e) {
		java.sql.PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement("insert into tbexchange(currency,bid,ask) values(?,?,?)");
			for (exchangeRateDTO exchangeRateDTO : e) {
				pstm.setString(1, exchangeRateDTO.getCurrency());
				pstm.setString(2, exchangeRateDTO.getBid());
				pstm.setString(3, exchangeRateDTO.getAsk());
				pstm.executeUpdate();
			}
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	public boolean updateExchange(ArrayList<exchangeRateDTO> e) {
		java.sql.PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement("update tbexchange set currency=?,bid=?,ask=? where id=?");
			for (int i = 0; i < e.size(); i++) {
				pstm.setString(1, e.get(i).getCurrency());
				pstm.setString(2, e.get(i).getBid());
				pstm.setString(3, e.get(i).getAsk());
				pstm.setInt(4, i + 1);
				pstm.executeUpdate();
			}
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
	}

	public ResultSet retrieveExchange() {
		try {
			Statement stm = con.createStatement();
			return stm.executeQuery("select * from tbexchange");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}
