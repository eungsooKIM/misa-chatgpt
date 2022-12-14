package model;

import java.sql.*;

public class chatGptRepository {


	public static void main(String[] args) {
		Connection con = null;

		String server = "jdbc:mariadb://127.0.0.1:8080";
		String database = "chatGpt";
		String user_name = "root";
		String password = "123123123a";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(" 드라이버 로딩 오류 : " + e.getMessage());
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name,
				password); // SSL 실행 확인
			System.out.println("연결 성공");
		} catch (SQLException e) {
			System.err.println("에러 내용 :" + e.getMessage());
			e.printStackTrace();
		}

		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}
	}
}

