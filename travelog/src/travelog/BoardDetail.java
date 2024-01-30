package travelog;

import java.util.Scanner;

public class BoardDetail {

	public static void main(String[] args) {
		DB db = new DB();
		Scanner sc = new Scanner(System.in);
		System.out.println("게시물 번호를 입력하세요.");

		int board_choice = sc.nextInt();
		sc.nextLine();
		db.detailSelect(board_choice);
		System.out.println();
		System.out.println("1. 게시물 수정, 2. 게시물 삭제, 3.메인화면으로 이동");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			BoardUpdate.main(args);
			break;
		case 2:
			db.delete(board_choice);
			break;
		case 3:
			System.out.println("메인 화면으로 이동합니다.");
			BoardDetail.main(args);
			return;
		default:
			System.out.println("알맞은 번호를 입력하세요.");
		}
	}
}