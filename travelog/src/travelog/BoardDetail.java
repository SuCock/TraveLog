package travelog;

import java.util.Scanner;

public class BoardDetail {

	public static void main(String[] args) {
		DB db = new DB();
		Scanner sc = new Scanner(System.in);

		while(true) {
		System.out.println("게시물 번호를 입력하세요.");

		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			boolean check = false;
			int ds;
			do {
				
			
				System.out.println("메뉴를 고르시오");
				System.out.println("1. 수정 2. 삭제 3. 메인으로 이동");
				ds = sc.nextInt();
				if(db.detailSelect() == 0) {
					check = true;
				}else {
					System.out.println("번호를 다시 입력하세요.");
			}while (!check);
			
			db.detailSelect(ds);
			
			break;
			
			case 2:							
			BoardUpdate.main(args);
			break;
		case 3:
			db.delete(choice);
			break;
		case 4:
			System.out.println("메인 화면으로 이동합니다.");
			BoardDetail.main(args);
			return;
		default:
			System.out.println("알맞은 번호를 입력하세요.");


		}
		}
		}
