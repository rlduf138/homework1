package service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.Customer;

public class CustomerService {
	
	private Map<String, Customer> customers;	//<key, value>
	
	private static final CustomerService instance = new CustomerService();
	
	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerService getInstance(){
		return instance;
	}
	
	public void addCustomer(Customer customer){
		customers.put(customer.getId(), customer);
	}
	
	public Customer login(String id, String password){
		Customer temp = customers.get(id);
		if(password.equals(temp.getPassword())){
			return temp;
		}		
		else{
			return null;
		}
	}
	public Customer findCustomer(String id){
		if(id != null)
			return(customers.get(id.toLowerCase()));
		else
			return null;
	}
}
