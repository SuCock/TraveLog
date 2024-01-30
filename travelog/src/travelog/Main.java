package travelog;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DB db = new DB();
		Scanner scan = new Scanner(System.in);
		System.out.println("                                                                   .-'''-.              \r\n"
				+ "                                                          .---.   '   _    \\            \r\n"
				+ "                        .----.     .----.   __.....__     |   | /   /` '.   \\           \r\n"
				+ "                         \\    \\   /    /.-''         '.   |   |.   |     \\  '  .--./)   \r\n"
				+ "     .|  .-,.--.          '   '. /'   //     .-''\"'-.  `. |   ||   '      |  '/.''\\\\    \r\n"
				+ "   .' |_ |  .-. |    __   |    |'    //     /________\\   \\|   |\\    \\     / /| |  | |   \r\n"
				+ " .'     || |  | | .:--.'. |    ||    ||                  ||   | `.   ` ..' /  \\`-' /    \r\n"
				+ "'--.  .-'| |  | |/ |   \\ |'.   `'   .'\\    .-------------'|   |    '-...-'`   /(\"'`     \r\n"
				+ "   |  |  | |  '- `\" __ | | \\        /  \\    '-.____...---.|   |               \\ '---.   \r\n"
				+ "   |  |  | |      .'.''| |  \\      /    `.             .' |   |                /'\"\"'.\\  \r\n"
				+ "   |  '.'| |     / /   | |_  '----'       `''-...... -'   '---'               ||     || \r\n"
				+ "   |   / |_|     \\ \\._,\\ '/                                                   \\'. __//  \r\n"
				+ "   `'-'           `--'  `\"                                                     `'---' ");
			while (true) {
				System.out.println("1. 게시글 등록");
				System.out.println("2. 종료");
				System.out.println("번호 입력하세요");

				int choice = scan.nextInt();
				
				switch (choice) {
				case 1:
					System.out.print("제목 : ");
					String board_title = scan.nextLine();
			
			 }
   }
		}
	}

