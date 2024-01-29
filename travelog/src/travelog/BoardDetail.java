package travelog;

import java.util.Scanner;

public class BoardDetail {

	public static void main(String[] args) {
		DB db = new DB();
		Scanner sc = new Scanner(System.in);
		System.out.println("게시물 번호를 입력하세요.");
		
		int choice = sc.nextInt();
        sc.nextLine();

		switch (choice) {
		case 1:
			BoardUpdate.main(args);
			break;
		case 2:
			db.delete(choice);		
			break;
		case 3:
			System.out.println("메인화면으로 돌아갑니다.");
			BoardDetail.main(args);
			return;
		default:
			System.out.println("잘못된 번호를 입력했습니다.");
		}
	}
}
