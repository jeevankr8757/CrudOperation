package com.crud.cntroller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.crud.entity.user;
import com.crud.repo.userrepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class usercontroller {
	
	@Autowired
	userrepo usR;
	
	@GetMapping("/user")
	public List<user> getUsers(){
		return usR.findAll();
	}
	@PostMapping("/adduser")
	public void adduser(@RequestBody user u) {
		usR.save(u);
	}
	@DeleteMapping("/deleteuser/{id}")
	public void deleteuser(@PathVariable("id") int id) {
		usR.deleteById(id);
	}
	@PutMapping("/updateuser/{id}")
	public void putuser(@PathVariable("id") int id, @RequestBody user u) {
		String name=u.getName();
		u.setName(name);
		usR.save(u);
	}
}
