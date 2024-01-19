package travelog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	public void insert(String board) {
		System.out.println("DB에 할일 입력하기");
		// 예외 처리
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO  "
														 + "(`board_category`,`board_writer`,`board_date`,`board_title`,`board_contents`)"
														 + "VALUES "
														 + "(?,?,?,?,?)");
			pstmt.setString(1, board); // 첫번째 ?에 넣어준다.
			System.out.println("입력완료");
			pstmt.executeUpdate(); // 입력한 퀴리문을 업데이트 해준다.
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void select() {
		System.out.println("DB에 할일 조회하기");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM todo"); 
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			
			while(rs.next()) {
				System.out.print("idx: " + rs.getInt("idx"));
				System.out.print(" 할일: " + rs.getString("할일"));
				System.out.println(" 상태: " + rs.getString("상태"));
			}
			System.out.println("조회완료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
