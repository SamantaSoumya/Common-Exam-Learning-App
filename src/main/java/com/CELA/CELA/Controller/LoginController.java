package com.CELA.CELA.Controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import com.CELA.CELA.Model.User;
import com.CELA.CELA.Service.LoginService;


@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/login")

public class LoginController {
	
	@Autowired
	LoginService loginService;
	@PostMapping
	public ResponseEntity<User>loginuser(@RequestBody Map<String, Object> data){
		return ResponseEntity.ok(loginService.login(data));
	}
}
