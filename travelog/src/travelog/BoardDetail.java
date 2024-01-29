package travelog;

import java.util.Scanner;

public class BoardDetail {

	public static void main(String[] args) {
		DB db = new DB();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("게시물 번호를 입력하세요.");
			int board_no = sc.nextInt();
			 String board_contents = db.retrieve(board_no);

	            if (board_contents != null) {
	                System.out.println("게시물 내용:");
	                System.out.println(board_contents);
	            } else {
	                System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
	            }
	        }
	    }
	}