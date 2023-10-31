package com.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.mapper.CustomerMapper;
import com.rest.vo.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerMapper mapper;
	@Autowired
	CustomerServiceImpl(CustomerMapper mapper){
		this.mapper = mapper;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public Customer selectOne(String num) {
		return mapper.selectOne(num);
	}

	@Override
	public int insert(Customer c) {
		return mapper.insert(c);
	}

	@Override
	public int delete(String num) {
		return mapper.delete(num);
	}

	@Override
	public int update(Customer c) {
		return mapper.update(c);
	}

	@Override
	public List<Customer> search(String address) {
		return mapper.search(address);
	}
	

	

}






