package travelog;

public class Board_write{
	private String board_category;
	private String board_writer;
	private String board_date;
	
	public Board_write(String board_category, String board_writer, String board_date) {
		this.board_category = board_category;
		this.board_writer = board_writer;
		this.board_date = board_date;
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
	
}
