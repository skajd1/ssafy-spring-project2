package com.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.CustomerService;
import com.rest.vo.Customer;

@RestController
public class CustomerController {
	private CustomerService cs;
	@Autowired
	CustomerController(CustomerService cs){
		this.cs = cs;
	}
//	@GetMapping(value = "/customers")
//	public List<Customer> selectAll() throws Exception{
//		List<Customer> list = cs.selectAll();
//		System.out.println(list.size());
//		return list;
//	}
	@GetMapping(value = "/customers")
	public ResponseEntity<List<Customer>> selectAll() throws Exception{
		List<Customer> list = cs.selectAll();
		ResponseEntity<List<Customer>> re = new ResponseEntity<>(list,HttpStatus.OK);
		return re;
	}
	@GetMapping(value = "/customers/{num}")
	public Customer selectOne(@PathVariable String num) throws Exception{
		Customer c = cs.selectOne(num);
		return c;
	}
	@PostMapping(value = "/customers")
	public ResponseEntity<String> insert(@RequestBody Customer c){
		
		int res = cs.insert(c);
		ResponseEntity<String> re = null;
		if (res>=1) re = new ResponseEntity<>("추가 성공~",HttpStatus.OK);
		return re;
	}
	@PutMapping(value = "/customers")
	public Map<String,String> update(@RequestBody Customer c){
		
		int res = cs.update(c);
		Map<String,String> map = new HashMap<>();
		if (res>=1) map.put("msg","수정 성공~~!");
		return map;
	}
	@DeleteMapping(value = "customers/{num}")
	public Map<String,String> delete(@PathVariable String num) throws Exception{
		int res = cs.delete(num);
		Map<String, String> map = new HashMap<>();
		if (res>=1) map.put("msg","삭제성공~~");
		
		return map;
	}
	@GetMapping(value = "/customers/address/{address}")
	public List<Customer> search(@PathVariable String address) throws Exception{
		List<Customer> list = cs.search(address);
		return list;
	}
	

}
