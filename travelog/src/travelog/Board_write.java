package travelog;

public class Board_write {
	private String board_category;
	private String board_writer;
	private String board_date;
	private String board_title;
	private String board_content;

	public Board_write(String board_category, String board_writer, String board_date, String board_title, String board_content) {
		this.board_category = board_category;
		this.board_writer = board_writer;
		this.board_date = board_date;
		this.board_title = board_title;
		this.board_content = board_content;
	}

	public String getboard_category() {
		return board_category;
	}

	public String getboard_writer() {
		return board_writer;
	}

	public String getboard_date() {
		return board_date;
	}

	public String getTitle() {
		return board_title;
	}

	public String getContent() {
		return board_content;
	}

}
