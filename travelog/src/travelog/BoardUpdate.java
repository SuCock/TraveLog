package travelog;

import java.util.Scanner;

public class BoardUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DB db = new DB();
		
		while (true) {
			System.out.println("1. 게시글 단건 조회");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 종료");
			System.out.println("번호 입력하세요 > ");

			String board = sc.nextLine();

			if (board.equals("1")) {
				System.out.println("게시글 번호 입력 > ");
				db.updateSelect(board);
			} else if (board.equals("2")) {
				System.out.println("게시글 제목 > ");
				String input = sc.nextLine();
				db.update(board); // 제목
				System.out.println("게시글 내용 > ");
				input = sc.nextLine();
				db.update(board); // 내용
				System.out.println("게시글 번호 > ");
				input = sc.nextLine();
				db.update(board); // 게시글 번호
				db.updateSelect(board);
			} else {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}
