package kr.co.kyobo.vo;

public class Board {
	private int boardNum;
	private String title;
	private String writer;
	private String contents;
	private String writeDate;
	private String updateDate;
	private String fileName;
	private String serv_fileName;
	public Board() {
		super();
	}
	public Board(int boardNum, String title, String writer, String contents,
			String writeDate, String updateDate, String fileName) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
		this.fileName = fileName;
		//this.serv_fileName = serv_fileName;
	}
	public Board(int boardNum, String title, String writer, String contents, String fileName) {
		this(boardNum,title,writer,contents,"","",fileName);
	}
	public Board(String title, String writer, String contents, String fileName) {
		this(0,title,writer,contents,"","",fileName);
	}
	public Board(int boardNum, String title, String writer, String contents) {
		this(boardNum,title,writer,contents,"","","");
	}
	
	public Board(String title, String writer, String contents) {
		this(0,title,writer,contents,"","","");
	}

	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/*
	public String getserv_FileName(){
		return serv_fileName;
	}
	public void setserv_fileName(String serv_fileName){
		this.serv_fileName = serv_fileName;
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (boardNum != other.boardNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return new StringBuilder("Board [boardNum=").append(boardNum)
				 .append(", title=").append(title)
				 .append(", writer=").append(writer)
				 .append(", contents=").append(contents)
				 .append(", writeDate=").append(writeDate)
				 .append(", updateDate=").append(updateDate)
				 .append(", fileName=").append(fileName)
				 .append("]").toString();
	}
	
	
}
