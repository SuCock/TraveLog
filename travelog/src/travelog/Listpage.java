package travelog;

import java.util.Scanner;

public class Listpage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DB db = new DB();
//		String cate = "";
		
		System.out.println("게시물 목록");
		db.select();
		System.out.println("원하는 카테고리를 선택해주세요");
		while(true) {
			String cate = scan.nextLine();
			if(cate.equals("1")) {
				db.cateSelect(cate);
			} else {
				System.out.println("종료");
			}
		}
//		while(true) {
//			String input = scan.nextLine();
//			if(input.equals("1")) {
//				System.out.println("게시물 선택");
//			} else {
//				System.out.println("종료");
//			}
//			
//		}
	}
}

