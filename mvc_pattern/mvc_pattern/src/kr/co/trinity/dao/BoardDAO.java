package kr.co.trinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.trinity.exception.RecordNotFoundException;
import kr.co.trinity.vo.Board;

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
			//DB�뿰寃�
			conn=db.getConnection();
			//Query �떎�뻾
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, boardNum); 
			result=stmt.executeQuery();
			
			//Query 寃곌낵 泥섎━
			if(result.next()) flag=true;
			//DB�뿰寃� 醫낅즺
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//DB�뿰寃� 醫낅즺
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
	public ArrayList<Board> getAllBoard(int pageSize, int pageNumber) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		
		String sql = "select * from (SELECT *"
				  + "  FROM ("
				  + "	SELECT rownum rnum,board_num,title,writer,contents,TO_CHAR(write_date,'yyyy/mm/dd') writeDate, TO_CHAR(update_date,'yyyy/mm/dd') updateDate,  "
				  + " COALESCE(file_name,'') "
				  + "	 FROM board" 
				  + "		) board "
				  + "	where rnum <= ?"
				  + ")"
				  + "where rnum >= ?";
		
		ArrayList<Board> boardList=new ArrayList<Board>();
		
		try {
			conn=db.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, (pageNumber * pageSize));
			stmt.setInt(2, (pageNumber * pageSize - 4));
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
		} finally{
			db.close(result, stmt, conn);
	}
		return boardList;
	}
	
	//테이블의 행 갯수를 리턴해준다.
	public int getTotalCount(){
		Connection conn = null;
		PreparedStatement pstmt = null ;
		String sql = "select count(*) as cnt from board ";
		ResultSet rs = null ;
		int cnt = 0;
		
		try {			
			conn = db.getConnection() ;

			 
//			if( whatColumn.equals("all") == false ){ //전체 검색이 아니면 where 절 추가
//				//검색할 모드에 따라서 where 절의 문장이 달라진다.
//				sql += " where " + whatColumn + " like '%" + keyword + "%'" ;					
//			}		
			//System.out.println(  "getTotalCount 메소드 : \n" + sql );
			
			//sql 변수를 이용하여 PreparedStatement 객체를 구한다.
			pstmt = conn.prepareStatement( sql ) ;
			
			//executeQuery() 메소드를 이용하여 ResultSet 객체를 구한다.
			rs = pstmt.executeQuery() ; 
			
			if( rs.next() ){
				cnt = rs.getInt("cnt") ;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//참조된 객체 변수에 대하여 close() 메소드를 이용하여 해당 객체들을 닫는다.
			try {
				if( rs != null ){rs.close() ;}
				if( pstmt != null ){pstmt.close() ;}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return cnt ;
	}
}
