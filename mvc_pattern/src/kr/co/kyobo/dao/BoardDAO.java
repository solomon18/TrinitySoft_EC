package kr.co.kyobo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.kyobo.vo.Board;
import kr.co.kyobo.exception.RecordNotFoundException;

public class BoardDAO implements BoardDAOIF {
	DBUtil db=DBUtil.getInstance();
	
	private boolean isExist(int boardNum){
		boolean flag=false;
		Connection conn=null;
		//Statement stmt=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT * FROM board WHERE board_num=?";
		try {
			//DB연결
			conn=db.getConnection();
			//Query 실행
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, boardNum); 
			result=stmt.executeQuery();
			
			//Query 결과 처리
			if(result.next()) flag=true;
			//DB연결 종료
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//DB연결 종료
			db.close(result, stmt, conn);
		}
		return flag;
	}
	@Override
	public void insert(Board b) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="INSERT INTO board(board_num, title, writer, contents, write_date, file_name) "+
		           " VALUES((SELECT COALESCE(MAX(board_num),0)+1 FROM board),?,?,?,current_timestamp,?)";
		try {
			conn=db.getConnection();
			
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getWriter());
			stmt.setString(3, b.getContents());
			stmt.setString(4, b.getFileName());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally{
			db.close(result, stmt, conn);
		}
	}

	@Override
	public void update(Board b) throws RecordNotFoundException {
		   if(!isExist(b.getBoardNum())) 
			     throw new RecordNotFoundException(""+b.getBoardNum());
		   Connection conn=null;
		   PreparedStatement stmt=null;
		   String sql="UPDATE board SET title=?, contents=?, update_date=current_timestamp  WHERE board_num=?";
		   if(b.getFileName() != null ) sql="UPDATE board SET title=?, contents=?, update_date=current_timestamp, file_name=?  WHERE board_num=?";
		   try {
			   conn=db.getConnection();
			   stmt=conn.prepareStatement(sql);
			   stmt.setString(1, b.getTitle());
			   stmt.setString(2, b.getContents());
			   if(b.getFileName() != null ){
				   stmt.setString(3, b.getFileName());
				   stmt.setInt(4, b.getBoardNum());
			   }else{
				   stmt.setInt(3, b.getBoardNum());
			   }
			   
			   stmt.executeUpdate();
 			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally{
				db.close(stmt, conn);
			}
	}

	@Override
	public void delete(int boardNum) throws RecordNotFoundException {
		   if(!isExist(boardNum)) 
			     throw new RecordNotFoundException(new Integer(boardNum).toString());

		   Connection conn=null;
		   PreparedStatement stmt=null;
		   String sql="DELETE board WHERE board_num=?";
		   try {
			   conn=db.getConnection();
			   stmt=conn.prepareStatement(sql);
			   stmt.setInt(1, boardNum);

			   stmt.executeUpdate();
			   
			   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally{
				db.close(stmt, conn);
			}
	}

	@Override
	public Board getBoard(int boardNum) throws RecordNotFoundException {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT board_num, title, writer, contents,"
		           +" TO_CHAR(write_date,'yyyy/mm/dd'), TO_CHAR(update_date,'yyyy/mm/dd'),  "
		           +" COALESCE(file_name,'') FROM board WHERE board_num=?";
		Board board=null;
		
		try {
			conn=db.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, boardNum);
			result=stmt.executeQuery();
			
			if(result.next()){
				board=new Board(result.getInt(1),
									  result.getString(2),
									  result.getString(3),
									  result.getString(4),
									  result.getString(5),
									  result.getString(6),
									  result.getString(7));
			}else{
				throw new RecordNotFoundException(""+boardNum);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			db.close(result, stmt, conn);
	}
		return board;
	}

	@Override
	public ArrayList<Board> getAllBoard() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT board_num, title, writer, contents,"
		           +" TO_CHAR(write_date,'yyyy/mm/dd') writeDate, TO_CHAR(update_date,'yyyy/mm/dd') updateDate,  "
		           +" COALESCE(file_name,'') FROM board ORDER BY board_num";
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			conn=db.getConnection();
			stmt=conn.prepareStatement(sql);
			result=stmt.executeQuery();
			
			while(result.next()){
				boardList.add(new Board(result.getInt(1),
									  result.getString(2),
									  result.getString(3),
									  result.getString(4),
									  result.getString(5),
									  result.getString(6),
									  result.getString(7)) );
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			db.close(result, stmt, conn);
	}
		return boardList;
	}

	@Override
	public ArrayList<Board> getBoardFindByTitle(String title) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT board_num, title, writer, contents,"
		           +" TO_CHAR(write_date,'yyyy/mm/dd'), TO_CHAR(update_date,'yyyy/mm/dd'),  "
		           +" COALESCE(file_name,'') FROM board WHERE title like ?  ORDER BY board_num";
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			conn=db.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, "%"+title+"%");
			result=stmt.executeQuery();
			
			while(result.next()){
				boardList.add(new Board(result.getInt(1),
									  result.getString(2),
									  result.getString(3),
									  result.getString(4),
									  result.getString(5),
									  result.getString(6),
									  result.getString(7)) );
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			db.close(result, stmt, conn);
	}
		return boardList;
	}

	@Override
	public ArrayList<Board> getBoardFindByWriter(String writer) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT board_num, title, writer, contents,"
		           +" TO_CHAR(write_date,'yyyy/mm/dd'), TO_CHAR(update_date,'yyyy/mm/dd'),  "
		           +" COALESCE(file_name,'') FROM board WHERE writer like ?  ORDER BY board_num";
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			conn=db.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, "%"+writer+"%");
			result=stmt.executeQuery();
			
			while(result.next()){
				boardList.add(new Board(result.getInt(1),
									  result.getString(2),
									  result.getString(3),
									  result.getString(4),
									  result.getString(5),
									  result.getString(6),
									  result.getString(7)) );
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			db.close(result, stmt, conn);
	}
		return boardList;
	}

}
