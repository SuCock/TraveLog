package travelog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	// 수민
	public void updateSelect(int board) { // 수정전의 조회문(단건조회임으로 완성되면 사라질 예정)
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT board_category\r\n" + "	 , board_writer\r\n"
					+ "	 , board_date\r\n" + "	 , board_title\r\n" + "	 , board_contents\r\n" + "  FROM board\r\n"
					+ " WHERE board_no = ?");
			pstmt.setInt(1, board); // 첫번째 ?에 넣어준다. -> 조건을 먼저 넣고 실행해야한다.
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

	public void update(String title, String content, int boardNo ) { // 수정문
		// 예외 처리
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);

			PreparedStatement pstmt = con.prepareStatement("UPDATE board SET board_title = ?, board_contents = ? WHERE board_no = ?");
			pstmt.setString(1, title); // 게시판 제목 
			pstmt.setString(2, content); // 게시판 내용
			pstmt.setInt(3, boardNo); // 게시판 번호
			
			int result = pstmt.executeUpdate(); // 입력한 퀴리문을 업데이트 해준다.
			
			if(result > 0 ) {
				System.out.println("수정완료");
				
			} else {
				System.err.println("수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// end 수민
	
	// 찬우
//	public void insert01(String board_category) {
//		// 예외 처리
//		try {
//			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
//
//			PreparedStatement pstmt = con.prepareStatement("INSERT INTO board" + 
//														"(`board_category`)"+ 
//														"VALUES " + 
//														"(?)");
//			pstmt.setString(1, board_category); // 첫번째 ?에 넣어준다.
//			pstmt.executeUpdate(); // 입력한 퀴리문을 업데이트 해준다.
//		} catch (Exception e) {
//		}
//	}
	public void insert(String board_category, String board_writer,String board_title, String board_contents) {
		System.out.println("게시물이 등록되었습니다");
		// 예외 처리
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO board" + 
														"(`board_category`,`board_writer`,`board_title`,`board_contents`)"+ 
														"VALUES " + 
														"(?,?,?,?)");
			pstmt.setString(1, board_category); // 첫번째 ?에 넣어준다.
			pstmt.setString(2, board_writer); // 두번째 ?에 넣어준다.
			pstmt.setString(3, board_title); // n번째 ?에 넣어준다.
			pstmt.setString(4, board_contents); // n번째 ?에 넣어준다.
//			pstmt.setString(5, board); // n번째 ?에 넣어준다.

			pstmt.executeUpdate(); // 입력한 퀴리문을 업데이트 해준다.
		} catch (Exception e) {
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// end 찬우
	
	// 현욱
	public void listSelect() {
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
	
	public void cateSelect(String cate) {
		System.out.println("CATEGORY SELECT 조회");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM board WHERE board_category = ?");
			pstmt.setString(1,cate);
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			
			if (!rs.isBeforeFirst()) {
		        // rs.isBeforeFirst() 결과 집합에 데이터가 있는지 여부를 확인
		        System.out.println("조회되는 내용이 없습니다. 카테고리를 다시 입력 해주세요");
		    } else {
				while(rs.next()) {
					System.out.print("[게시판번호:" + rs.getInt("board_no") + "] ");
					System.out.print("카테고리:" + rs.getString("board_category") + " ");
					System.out.print("작성자:" + rs.getString("board_writer") + " ");
					System.out.print("제목:" + rs.getString("board_title") + " ");
					System.out.println();
				}
		    }
			System.out.println("조회완료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// end 현욱
	
	// 상의
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// end 상의
}
