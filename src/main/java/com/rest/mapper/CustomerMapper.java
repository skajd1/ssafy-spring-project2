package com.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rest.vo.Customer;

@Mapper
public interface CustomerMapper {
	public ArrayList<Customer> selectAll();//모든 글정보
	public Customer selectOne(String num);//모든 글정보
	public int insert(Customer c);
	public int delete(String num);
	public int update(Customer c);
	public List<Customer> search(String address);
}
