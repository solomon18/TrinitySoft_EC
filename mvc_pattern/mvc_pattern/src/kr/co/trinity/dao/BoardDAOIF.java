package kr.co.trinity.dao;

import java.util.ArrayList;

import kr.co.trinity.exception.RecordNotFoundException;
import kr.co.trinity.vo.Board;

public interface BoardDAOIF {
	public abstract void insert(Board b);
	public abstract void update(Board b) throws RecordNotFoundException;
	public abstract void delete(int boardNum) throws RecordNotFoundException;
	public abstract Board getBoard(int boardNum) throws RecordNotFoundException;
	public abstract ArrayList<Board> getAllBoard();
	public abstract ArrayList<Board> getBoardFindByTitle(String title);
	public abstract ArrayList<Board> getBoardFindByWriter(String writer);
	public abstract int getTotalCount();
	public abstract ArrayList<Board> getAllBoard(int pageSize, int pageNumber);
}
