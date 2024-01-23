package travelog;

import java.util.Scanner;

public class Board_write {

	public static void main(String[] args) {

		DB db = new DB();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("글작성 페이지 입니다");
		System.out.println();
		System.out.print("카테고리 : ");
		String board_category = scan.nextLine();
		if(board_category)
		System.out.print("작성자 : ");
		String board_writer = scan.nextLine();
		System.out.print("제목 : ");
		String board_title = scan.nextLine();
		System.out.print("내용 : ");
		String board_content = scan.nextLine();
		db.insert(board_category, board_writer, board_title, board_content);

	}

}
