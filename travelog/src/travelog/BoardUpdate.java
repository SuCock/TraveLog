package travelog;

import java.util.Scanner;

public class BoardUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DB db = new DB();

		while (true) {
			int boardNo = 1; // 단건조회에서 가져올 데이터(수정할 게시판 번호)
			db.updateSelect(boardNo); // 단건조회
			System.out.println("1. 게시글 수정");
			System.out.println("2. 종료");
			System.out.println("번호 입력하세요 > ");

			String number = sc.nextLine();
			if (number.equals("1")) {
				System.out.println("게시글 카테고리 > ");
				String category = sc.nextLine(); // 카테고리
				System.out.println("게시글 제목 > ");
				String title = sc.nextLine(); // 제목 작성
				System.out.println("게시글 내용 > ");
				String content = sc.nextLine(); // 내용 작성

				db.update(title, content, category, boardNo); // 수정한 게시판 번호
			} else {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

}
