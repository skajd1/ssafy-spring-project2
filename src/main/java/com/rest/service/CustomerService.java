package com.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rest.vo.Customer;

//Controller를 위한 인터페이스
public interface CustomerService {
	public ArrayList<Customer> selectAll();//모든 글정보
	public Customer selectOne(String num);//모든 글정보
	public int insert(Customer c);
	public int delete(String num);
	public int update(Customer c);
	public List<Customer> search(String address);
}
