package travelog;

import java.util.Scanner;

public class BoardDetail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DB db = new DB();				
		int board_no;
		while(true) {
			System.out.println("게시물을 선택하세요.");
			System.out.println("게시물 번호 입력 > (1.경상도 2.충청도 3.전라도 4.강원도 5.경기도");
			  
			int choice = sc.nextInt();
	        sc.nextLine();
	        
	        switch(choice) {
            case 1:
                boolean check = false;
                do {
                    System.out.println("게시물 번호를 입력하세요");
                    System.out.println("1.경상도 2.충청도 3.전라도 4.강원도 5.경기도");
                    board_no = sc.nextInt();
                    
                } while (!check); // false 가 되면 종료 - true 이면 계속 실행
                db.detailSelect(board_no);
                break;
            case 2:
                BoardUpdate.main(args);
                // 게시글 수정
                break;
            case 3:
                db.Boarddelete.main(args);
                // 게시글삭제
                break;
            case 4:
                // 메인화면이동
                System.out.println("메인 화면으로 이동합니다.");
                return;  // 프로그램 종료
            default:
                System.out.println("알맞은 번호를 입력하세요.");
        }
    }



		while (true) {
			int boardNo = 1; // 게시물 내용 출력할 수 있게 하는 메서드
			db.updateSelect(board_no); // 단건조회
			System.out.println("1. 게시물 수정");
			System.out.println("2. 게시물 삭제");
			System.out.println("3. 메인페이지로 이동");
			System.out.println("번호 입력하세요 > ");

			String number = sc.nextLine();
			if (number.equals("1")) {
				System.out.println("게시물 작성날짜 > ");
				String date = sc.nextLine(); // 작성날짜 작성
				System.out.println("게시물 제목 > ");
				String title = sc.nextLine(); // 제목 작성
				System.out.println("게시물 내용 > ");
				String contents = sc.nextLine(); // 내용 작성
				System.out.println("게시물 작성자");
				String writer = sc.nextLine();// 작성자 작성

				db.insert(date, title, contents, writer); // 입력한 게시판 번호
			} else {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}


