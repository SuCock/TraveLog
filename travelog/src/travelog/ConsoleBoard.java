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
        System.out.println("글이 작성되었습니다.");
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

    public void viewPost(int index) {
        if (index >= 1 && index <= posts.size()) {
            Post post = posts.get(index - 1);
            System.out.println("제목: " + post.getTitle());
            System.out.println("내용: " + post.getContent());
        } else {
            System.out.println("해당 인덱스의 글이 없습니다.");
        }
    }

    public void deletePost(int index) {
        if (index >= 1 && index <= posts.size()) {
            Post post = posts.remove(index - 1);
            System.out.println("글이 삭제되었습니다. 제목: " + post.getTitle());
        } else {
            System.out.println("해당 인덱스의 글이 없습니다.");
        }
    }
}

public class ConsoleBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        while (true) {
            System.out.println("===== 게시판 =====");
            System.out.println("1. 글 작성");
            System.out.println("2. 글 목록 조회");
            System.out.println("3. 글 조회");
            System.out.println("4. 글 삭제");
            System.out.println("5. 종료");
            System.out.print("메뉴 선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 처리

            switch (choice) {
                case 1:
                    System.out.print("제목 입력: ");
                    String title = scanner.nextLine();
                    System.out.print("내용 입력: ");
                    String content = scanner.nextLine();
                    board.writePost(title, content);
                    break;
                case 2:
                    board.viewPosts();
                    break;
                case 3:
                    System.out.print("조회할 글 번호 입력: ");
                    int viewIndex = scanner.nextInt();
                    board.viewPost(viewIndex);
                    break;
                case 4:
                    System.out.print("삭제할 글 번호 입력: ");
                    int deleteIndex = scanner.nextInt();
                    board.deletePost(deleteIndex);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }
}
