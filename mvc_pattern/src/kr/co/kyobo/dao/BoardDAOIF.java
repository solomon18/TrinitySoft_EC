package kr.co.kyobo.dao;

import java.util.ArrayList;

import kr.co.kyobo.vo.Board;
import kr.co.kyobo.exception.RecordNotFoundException;

public interface BoardDAOIF {
	public abstract void insert(Board b);
	public abstract void update(Board b) throws RecordNotFoundException;
	public abstract void delete(int boardNum) throws RecordNotFoundException;
	public abstract Board getBoard(int boardNum) throws RecordNotFoundException;
	public abstract ArrayList<Board> getAllBoard();
	public abstract ArrayList<Board> getBoardFindByTitle(String title);
	public abstract ArrayList<Board> getBoardFindByWriter(String writer);
}
