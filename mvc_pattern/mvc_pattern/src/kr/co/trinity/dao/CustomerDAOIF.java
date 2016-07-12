package kr.co.trinity.dao;

import java.util.ArrayList;

import kr.co.trinity.exception.DulplicateException;
import kr.co.trinity.exception.RecordNotFoundException;
import kr.co.trinity.vo.Customer;

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
	public abstract boolean loginCheck(String userId) throws Exception;
}










