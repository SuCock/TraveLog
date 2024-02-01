package travelog;

import java.util.Scanner;

public class BoardDetail {
	public static void main(String[] args) {

		DB db = new DB();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("게시물 번호를 입력하세요.");
			int choice = sc.nextInt();
			sc.nextLine();
			db.detailSelect(choice);
			boolean bo = true;

			while (bo) {
				System.out.println("1. 게시물 수정, 2. 게시물 삭제 3. 뒤로가기");
				String BD = sc.nextLine();
				switch (BD) {
				case "1":
					while (true) {
						if (BD.equals("1")) {
							System.out.println("게시글 카테고리 > ");
							String category = sc.nextLine(); // 카테고리
							System.out.println("게시글 제목 > ");
							String title = sc.nextLine(); // 제목 작성
							System.out.println("게시글 내용 > ");
							String content = sc.nextLine(); // 내용 작성
							db.update(title, content, category, choice); // 수정한 게시판 번호
							
						} else {
							System.out.println("종료합니다.");
							break;
						}
					}
					break;
				case "2":
					db.delete(choice);
					ConsoleBoard.main(args);
					break;
				case "3":
					BoardDetail.main(args);;
					break;
				case "0":
					System.out.println("종료합니다.");
					bo = false;
				default:
					System.out.println("게시물 번호를 다시 입력해주세요");
					continue;

				}
			}

		}
	}

}
