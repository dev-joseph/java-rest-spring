package com.spring.mvc.SrpingMvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.mvc.SrpingMvc.dao.IUserInfoDAO;
import com.spring.mvc.SrpingMvc.model.Article;
@Service
public class UserInfoService implements IUserInfoService {
	@Autowired
	private IUserInfoDAO userInfoDAO;
	@Override
	public List<Article> getAllUserArticles(){
		return userInfoDAO.getAllUserArticles();
	}
} 