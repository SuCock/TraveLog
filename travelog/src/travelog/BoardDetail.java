package travelog;

import java.util.Scanner;

public class BoardDetail {

	public static void main(String[] args) {
		DB db = new DB();
		Scanner sc = new Scanner(System.in);
		System.out.println("게시물 번호를 입력하세요.");
		
		int choice = sc.nextInt();
		sc.nextLine();
        db.detailSelect(choice);
        System.out.println();
        System.out.println("게시물 수정,  게시물 삭제, 메인화면으로 이동");

	}
}