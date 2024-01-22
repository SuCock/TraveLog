package travelog;

import java.util.ArrayList;
import java.util.Scanner;

class Post {
	private String title;
	private String content;

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
}

class Board {
	private ArrayList<Post> posts;

	public Board() {
		this.posts = new ArrayList<>();
	}

	public void writePost(String title, String content) {
		Post post = new Post(title, content);
		posts.add(post);
		System.out.println("게시글이 등록되었습니다.");
	}

	public void viewPosts() {
		if (posts.isEmpty()) {
			System.out.println("게시글이 없습니다.");
		} else {
			System.out.println("===== 게시글 목록 =====");
			for (int i = 0; i < posts.size(); i++) {
				Post post = posts.get(i);
				System.out.println("[" + (i + 1) + "] " + post.getTitle());
			}
			System.out.println("=====================");
		}
	}
}

public class ConsoleBoard {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Board board = new Board();

		while (true) {
			System.out.println("===== 콘솔 게시판 =====");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 목록 조회");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // 개행 문자 처리

			switch (choice) {
			case 1:
				System.out.print("게시글 제목 입력: ");
				String title = scanner.nextLine();
				System.out.print("게시글 내용 입력: ");
				String content = scanner.nextLine();
				board.writePost(title, content);
				break;
			case 2:
				board.viewPosts();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴 선택입니다.");
			}
		}
	}
}
