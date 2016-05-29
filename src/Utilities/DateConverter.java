package Utilities;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;

public class DateConverter {
	/* Format "ថ្ងៃទី៣ខែធ្នូ ឆ្នាំ២០១៥ ម៉ោង ១០:៥៥" */
	private static int dayConverter(String input) {
		int date = 1;
		switch (input.trim()) {
		case "១":
			date = 1;
			break;
		case "ៗ":
			date = 2;
			break;
		case "៣":
			date = 3;
			break;
		case "៤":
			date = 4;
			break;
		case "៥":
			date = 5;
			break;
		case "៦":
			date = 6;
			break;
		case "៧":
			date = 7;
			break;
		case "៨":
			date = 8;
			break;
		case "៩":
			date = 9;
			break;
		case "១០":
			date = 10;
			break;
		case "១១":
			date = 11;
			break;
		case "១២":
			date = 12;
			break;
		case "១៣":
			date = 13;
			break;
		case "១៤":
			date = 14;
			break;
		case "១៥":
			date = 15;
			break;
		case "១៦":
			date = 16;
			break;
		case "១៧":
			date = 17;
			break;
		case "១៨":
			date = 18;
			break;
		case "១៩":
			date = 19;
			break;
		case "២០":
			date = 20;
			break;
		case "២១":
			date = 21;
			break;
		case "២២":
			date = 22;
			break;
		case "២៣":
			date = 23;
			break;
		case "២៤":
			date = 24;
			break;
		case "២៥":
			date = 25;
			break;
		case "២៦":
			date = 26;
			break;
		case "២៧":
			date = 27;
			break;
		case "២៨":
			date = 28;
			break;
		case "២៩":
			date = 29;
			break;
		case "៣០":
			date = 30;
			break;
		case "៣១":
			date = 31;
			break;
		default:
			break;
		}
		return date;
	}

	private static int monthConverter(String input) {
		int month = 1;
		switch (input.trim()) {
		case "មករា":
			month = 1;
			break;
		case "កុម្ភៈ":
			month = 2;
			break;
		case "មិនា":
			month = 3;
			break;
		case "មេសា":
			month = 4;
			break;
		case "ឧសភា":
			month = 5;
			break;
		case "មិថុនា":
			month = 6;
			break;
		case "កក្កដា":
			month = 7;
			break;
		case "សីហា":
			month = 8;
			break;
		case "កញ្ញា":
			month = 9;
			break;
		case "តុលា":
			month = 10;
			break;
		case "វិច្ឆិកា":
			month = 11;
			break;
		case "ធ្នូ":
			month = 12;
			break;
		default:
			break;
		}
		return month;
	}

	private static int yearConverter(String input) {
		int year = 0;
		switch (input.trim()) {
		case "២០០៧":
			year = 2007;
			break;
		case "២០០៨":
			year = 2008;
			break;
		case "២០០៩":
			year = 2009;
		case "២០១០":
			year = 2010;
			break;
		case "២០១១":
			year = 2011;
		case "២០១២":
			year = 2012;
			break;
		case "២០១៣":
			year = 2013;
			break;
		case "២០១៤":
			year = 2014;
			break;
		case "២០១៥":
			year = 2015;
			break;
		case "២០១៦":
			year = 2016;
			break;
		case "២០១៧":
			year = 2017;
			break;
		case "២០១៨":
			year = 2018;
			break;
		case "២០១៩":
			year = 2019;
			break;
		case "២០២០":
			year = 2020;
			break;
		case "២០២១":
			year = 2021;
			break;
		case "២០២២":
			year = 2022;
			break;
		case "២០២៣":
			year = 2023;
			break;
		case "២០២៤":
			year = 2024;
			break;
		case "២០២៥":
			year = 2025;
			break;
		case "២០២៦":
			year = 2026;
			break;
		case "២០២៧":
			year = 2027;
			break;
		case "២០២៨":
			year = 2028;
			break;
		case "២០២៩":
			year = 2029;
			break;
		case "២០៣០":
			year = 2030;
			break;
		case "២០៣១":
			year = 2031;
			break;
		case "២០៣២":
			year = 2032;
			break;
		case "២០៣៣":
			year = 2033;
			break;
		case "២០៣៤":
			year = 2034;
			break;
		case "២០៣៥":
			year = 2035;
			break;
		case "២០៣៦":
			year = 2036;
			break;
		case "២០៣៧":
			year = 2037;
			break;
		case "២០៣៨":
			year = 2038;
			break;
		case "២០៣៩":
			year = 2039;
			break;
		case "២០៤០":
			year = 2040;
			break;
		default:
			break;
		}
		return year;
	}

	private static String sabayConvertDate(String date) {
		int iday = date.indexOf("ទី");
		int imonth = date.indexOf("ខែ");
		int iyear = date.indexOf("ឆ្នាំ");
		String month = date.substring(imonth + 2, iyear);
		String day = date.substring(iday + 2, imonth);
		String year = date.substring(iyear + 5, iyear + 9);
		return (dayConverter(day) + "/" + monthConverter(month) + "/" + yearConverter(year));
	}

	@SuppressWarnings("unused")
	private static boolean isUTF8MisInterpreted(String input) {
		// convenience overload for the most common UTF-8 misinterpretation
		// which is also the case in your question
		return isUTF8MisInterpreted(input, "Windows-1252");
	}

	private static boolean isUTF8MisInterpreted(String input, String encoding) {
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
		ByteBuffer tmp;
		try {
			tmp = encoder.encode(CharBuffer.wrap(input));
		} catch (CharacterCodingException e) {
			return false;
		}
		try {
			decoder.decode(tmp);
			return true;
		} catch (CharacterCodingException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private static String dateConverter(String input) {
		if (!isUTF8MisInterpreted(input)) {
			input = sabayConvertDate(input);
		} else {
			try {
				@SuppressWarnings("deprecation")
				long date = java.util.Date.parse(input);
				Date d = new Date(date);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				input = df.format(d);
			} catch (Exception e) {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = null;
				try {
					utilDate = formatter.parse(input);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				input = df.format(utilDate);
			}
		}
		return input;
	}

	public static java.sql.Date converter(String input) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date oUtilDate = null;
		java.sql.Date sqlDate = null;
		try {
			oUtilDate = formatter.parse(dateConverter(input));
			sqlDate = new java.sql.Date(oUtilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	public boolean convertStringToSqlDate() throws ClassNotFoundException,
			SQLException {
		java.sql.Connection con = DatabaseConnection.getConnection();
		CallableStatement clstm = con.prepareCall("{call s_vw_convert_date}");

		try (ResultSet rs = clstm.executeQuery();) {
			java.sql.PreparedStatement pstm = null;
			while (rs.next()) {

				pstm = con
						.prepareStatement("update tbnews set news_published_date=? where news_id=?");
				pstm.setDate(1, converter(rs.getString("news_date")));
				pstm.setInt(2, rs.getInt("news_id"));
				pstm.executeUpdate();
			}

			return true;
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		} finally {
			con.close();
		}
		return false;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		System.out.println(new DateConverter().convertStringToSqlDate());
	}
	/*
	 * public static void main(String[] args) {
	 * System.out.println(converter("Wednesday, 29 July 2015 15:10"));
	 * System.out.println(converter("8/14/15 11:09 AM"));
	 * System.out.println(converter("05 August, 2015"));
	 * System.out.println(converter
	 * ("ថ្ងៃអាទិត្យ ទី៩ ខែសីហា ឆ្នាំ២០១៥ ម៉ោង ២៣:១៨"));
	 * System.out.println(converter("2015-8-29")); }
	 */
}