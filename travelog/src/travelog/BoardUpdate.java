package travelog;

import java.util.Scanner;

public class BoardUpdate {
	public static void main(String[] args, int boardNo) {
		Scanner sc = new Scanner(System.in);
		DB db = new DB();

		while (true) {
//			boardNo = db.detailSelect(boardNo);
			int number = sc.nextInt();
			if (number == 1) {
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
