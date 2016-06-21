package kr.co.kyobo.dao;

import java.util.ArrayList;

import kr.co.kyobo.vo.Customer;
import kr.co.kyobo.exception.DulplicateException;
import kr.co.kyobo.exception.RecordNotFoundException;

public interface CustomerDAOIF {
	public abstract void insert(Customer customer) 
			                   throws DulplicateException;
	public abstract void update(Customer customer)
	                           throws RecordNotFoundException;
	public abstract void delete(String userId)
		                           throws RecordNotFoundException;
	public abstract Customer getCustomer(String userId)
		                           throws RecordNotFoundException;
	public abstract ArrayList<Customer> getAllCustomer();
	public abstract boolean loginCheck(String userId, String password) throws Exception;
}










