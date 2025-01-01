package com.CELA.CELA.Service;

import java.util.Map;

import com.CELA.CELA.Model.User;

public interface LoginService {
	User login(Map<String,Object>data);
}
