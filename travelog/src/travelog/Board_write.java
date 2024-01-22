package travelog;

import java.util.Scanner;

public class Board_write {
	
public static void main(String[] args) {
		
		DB db = new DB();
		try (Scanner scan = new Scanner(System.in)) {
			while(true) {
				System.out.println("1. 게시물등록");
				System.out.println("2. 게시물목록");
				System.out.println("3. 종료");
				System.out.println("번호 입력하세요");
				
				String input = scan.nextLine();
				
				if (input.equals("1")) {
					System.out.print("카테고리: ");
					String board_category = scan.nextLine();
					System.out.print("작성자: ");
					String board_writer = scan.nextLine();
				    System.out.print("제목: ");
				    String board_title = scan.nextLine();
				    System.out.print("내용: ");
				    String board_contents = scan.nextLine();
				    db.insert(board_category, board_writer, board_title, board_contents);
				}

				else if(input.equals("2")) {
					db.select();
				}
				else {
					System.out.println("종료합니다.");
					break;
				}
			}
		}
		
	}
}
