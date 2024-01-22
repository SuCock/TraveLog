package travelog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	public void select(String board) { // 조회문
		System.out.println("");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT board_category\r\n" + "	 , board_writer\r\n"
					+ "	 , board_date\r\n" + "	 , board_title\r\n" + "	 , board_contents\r\n" + "  FROM board\r\n"
					+ " WHERE board_no = ?");
			pstmt.setString(1, board); // 첫번째 ?에 넣어준다. -> 조건을 먼저 넣고 실행해야한다.
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			if (rs.next()) { // 데이터가 있는 경우에만 진행
				System.out.println("╔══════" + rs.getString("board_title") + "═╗");
				System.out.println("║    " + rs.getString("board_category") + "║");
				System.out.println("║      " + rs.getString("board_writer") + "║");
				System.out.println("║        " + rs.getString("board_date") + "║");
				System.out.println("║    " + rs.getString("board_contents") + "║");
				System.out.println("╚══════════════════════════════════════════╝");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(String board) { // 수정문
		System.out.println("DB에 할일 입력하기");
		// 예외 처리
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);

			PreparedStatement pstmt = con.prepareStatement("UPDATE travelog\r\n" + "SET board_title = '?'\r\n"
					+ "  , board_contnets = '?'\r\n" + "WHERE board_no = '?';");
			pstmt.setString(1, board); // 첫번째 ?에 넣어준다.
			pstmt.setString(2, board); // 두번째 ?에 넣어준다.
			pstmt.setString(3, board); // 세번째 ?에 넣어준다.
			System.out.println("입력완료");
			pstmt.executeUpdate(); // 입력한 퀴리문을 업데이트 해준다.
		} catch (Exception e) {
		}
	}

//	public void insert(String todo) {
//		System.out.println("DB에 할일 입력하기");
//		// 예외 처리
//		try {
//			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
//			PreparedStatement pstmt = con.prepareStatement("INSERT INTO todo "
//														 + "(`할일`,`상태`)"
//														 + "VALUES "
//														 + "(?,'준비')");
//			pstmt.setString(1, todo); // 첫번째 ?에 넣어준다.
//			System.out.println("입력완료");
//			pstmt.executeUpdate(); // 입력한 퀴리문을 업데이트 해준다.
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public void select() {
		System.out.println("DB조회");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM board"); 
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			
			while(rs.next()) {
				System.out.print("[게시판번호:" + rs.getInt("board_no") + "] ");
				System.out.print("카테고리:" + rs.getString("board_category") + " ");
				System.out.print("작성자:" + rs.getString("board_writer") + " ");
				System.out.print("제목:" + rs.getString("board_title") + " ");
				System.out.println();
			}
			System.out.println("조회완료");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insert(String board) {
		System.out.println("DB에 할일 입력하기");
		// 예외 처리
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);

			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO  " + "(`board_category`,`board_writer`,`board_date`,`board_title`,`board_contents`)"
							+ "VALUES " + "(?,?,?,?,?)");
			pstmt.setString(1, board); // 첫번째 ?에 넣어준다.
			System.out.println("입력완료");
			pstmt.executeUpdate(); // 입력한 퀴리문을 업데이트 해준다.
		} catch (Exception e) {
		}
	}

	public void cateSelect(String cate) {
		System.out.println("CATEGORY SELECT 조회");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM board WHERE board_category = ?");
			pstmt.setString(1, cate);
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			
			while(rs.next()) {
				System.out.print("[게시판번호:" + rs.getInt("board_no") + "] ");
				System.out.print("카테고리:" + rs.getString("board_category") + " ");
				System.out.print("작성자:" + rs.getString("board_writer") + " ");
				System.out.print("제목:" + rs.getString("board_title") + " ");
				System.out.println();
			}
			System.out.println("조회완료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
