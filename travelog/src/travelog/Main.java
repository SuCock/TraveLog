package travelog;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DB db = new DB();
		try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				System.out.println("1. 게시글 등록");
				System.out.println("2. 종료");
				System.out.println("번호 입력하세요");

				int choice = scan.nextInt();
//			scanner.nextLine();
				
				switch (choice) {
				case 1:
					System.out.print("제목 : ");
					String board_title = scan.nextLine();
					db.insert(board_title);
			
			 }
   }
		}
	}
}
