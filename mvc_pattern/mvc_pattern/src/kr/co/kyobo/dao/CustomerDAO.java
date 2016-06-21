package kr.co.kyobo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.kyobo.exception.DulplicateException;
import kr.co.kyobo.exception.RecordNotFoundException;
import kr.co.kyobo.vo.Customer;

public class CustomerDAO implements CustomerDAOIF {
     DBUtil db = DBUtil.getInstance();
	/**
	 * primary key인 userId 존재여부 리턴
	 * @param userId String
	 * @return flag boolean  존재하면 true, 존재하지 않으면 false 리턴
	 */
	private boolean isExist(String userId){
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		//PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT * FROM customer WHERE user_id='"+userId+"'" ;
		//String sql="SELECT * FROM customer WHERE user_id=?";//in parameter
		try {
			//DB연결
			conn=db.getConnection();
			//Query 실행
			stmt=conn.createStatement();
		//	stmt=conn.prepareStatement(sql);
			//in parameter값 setting (stmt.setType(index,value))
		//	stmt.setString(1, userId); 
			result=stmt.executeQuery(sql);
		//	result=stmt.executeQuery();
			
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
	public void insert(Customer customer) throws DulplicateException {
	   if(isExist(customer.getUserId())) 
		     throw new DulplicateException(customer.getUserId());

	   Connection conn=null;
	   PreparedStatement stmt=null;
	   String sql="INSERT INTO customer(user_id,password,user_name,age,email,role)"
	            +" VALUES(?, ?, ?, ?, ?, ?)";
	   //String sql = INSERT INTO public."CUSTOMER"(
	   //         "USER_ID", "PASSWORD", "USER_NAME", "AGE", "EMAIL", "ROLE")
	   //		    VALUES ('1', '1', '1', 1, '1', '1');

	   try {
		   conn=db.getConnection();
		   stmt=conn.prepareStatement(sql);
		   stmt.setString(1, customer.getUserId());
		   stmt.setString(2, customer.getPassword());
		   stmt.setString(3, customer.getUserName());
		   stmt.setInt(4, customer.getAge());
		   stmt.setString(5, customer.getEmail());
		   stmt.setString(6, customer.getRole());
   
		   stmt.executeUpdate();
   
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally{
			//DB연결 종료
			db.close(stmt, conn);

		}
	}

	@Override
	public void update(Customer customer) throws RecordNotFoundException {
		   if(!isExist(customer.getUserId())) 
			     throw new RecordNotFoundException(customer.getUserId());

		   Connection conn=null;
		   PreparedStatement stmt=null;
		   String sql="UPDATE customer SET password=?,user_name=?,age=?,"+
		              " email=?,role= ?  WHERE user_id=?";
		   try {
			   conn=db.getConnection();
			   stmt=conn.prepareStatement(sql);
			   stmt.setString(1, customer.getPassword());
			   stmt.setString(2, customer.getUserName());
			   stmt.setInt(3, customer.getAge());
			   stmt.setString(4, customer.getEmail());
			   stmt.setString(5, customer.getRole());
			   stmt.setString(6, customer.getUserId());
   
			   stmt.executeUpdate();
			   
			   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally{
				db.close(stmt, conn);

			}

	}

	@Override
	public void delete(String userId) throws RecordNotFoundException {
		   if(!isExist(userId)) 
			     throw new RecordNotFoundException(userId);

		   Connection conn=null;
		   PreparedStatement stmt=null;
		   String sql="DELETE * from customer WHERE user_id=?";
		   try {
			   conn=db.getConnection();
			   stmt=conn.prepareStatement(sql);
			   stmt.setString(1, userId);
			   stmt.executeUpdate();
			   
			   
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally{
				//DB연결 종료
				db.close(stmt, conn);

			}

	}

	@Override
	public Customer getCustomer(String userId) throws RecordNotFoundException {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT * FROM customer WHERE user_id=?";
		Customer customer=null;
		
		try {
			conn=db.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, userId);
			result=stmt.executeQuery();
			
			if(result.next()){
				customer=new Customer(result.getString(1),
									  result.getString(2),
									  result.getString(3),
									  result.getInt(4),
									  result.getString(5),
									  result.getString(6));
			}else{
				throw new RecordNotFoundException(userId);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			//DB연결 종료
			db.close(result, stmt, conn);

	}
		return customer;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT * FROM customer";
		ArrayList<Customer> customerList=new ArrayList<Customer>();
		
		try {
			conn=db.getConnection();
			stmt=conn.prepareStatement(sql);
			
			result=stmt.executeQuery();
			
			while(result.next()){
				customerList.add(new Customer(result.getString(1),
											  result.getString(2),
											  result.getString(3),
											  result.getInt(4),
											  result.getString(5),
											  result.getString(6)));
									
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			//DB연결 종료
			db.close(result, stmt, conn);
		}

		return customerList;
	}
	@Override
	public boolean loginCheck(String userId, String password) throws Exception{
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
	//	PreparedStatement stmt=null;
		ResultSet result=null;
		String sql="SELECT user_id FROM customer WHERE user_id='"+userId+"' AND password='"+password+"'";
	//	String sql="SELECT user_id FROM customer  WHERE user_id=? AND password=?";
			conn=db.getConnection();
			stmt=conn.createStatement();
			result= stmt.executeQuery(sql);
	/*		stmt=conn.prepareStatement(sql);
			stmt.setString(1, userId);
			stmt.setString(2, password);
			
			result=stmt.executeQuery();
	*/		
			if(result.next()) flag=true;
			
			
		return flag;
	}

}












