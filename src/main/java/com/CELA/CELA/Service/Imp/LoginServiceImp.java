package com.CELA.CELA.Service.Imp;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.CELA.CELA.Exception.ResourceNotFoundException;
import com.CELA.CELA.Model.User;
import com.CELA.CELA.Repository.LoginRepository;
import com.CELA.CELA.Service.LoginService;
@Service
public class LoginServiceImp implements LoginService{
	private static final Logger logger = LogManager.getLogger(LoginServiceImp.class);

    @Autowired
    private LoginRepository loginRepository;


	@Override
	public User login(Map<String, Object> data) {
		Object obj1 = data.get("email");
		Object obj2 = data.get("password");
		String pass=obj2.toString();
		String email = obj1.toString();
        logger.info("Fetching details for user ID: {}", email);
        User user=null;
        try{
        	user =  loginRepository.findUserByEmail(email);
        	if(user==null) {
        		logger.info("user not exist");
        		return null;
        	}else if(user!=null){
        		String password = user.getPassword();
        		if(password.equalsIgnoreCase(pass)) {
        			logger.info("login successfull");
        			return user;
        		}else {
        			logger.info("incorrect password");
        			return null;
        		}
        	}
        }catch(Exception ResourceNotFoundException){
        	logger.error("User not found with email: {}", email);
        	logger.error(ResourceNotFoundException);
        }
        return user;
       
    }

}
