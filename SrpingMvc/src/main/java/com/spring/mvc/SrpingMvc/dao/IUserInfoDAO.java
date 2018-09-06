package com.spring.mvc.SrpingMvc.dao;

import java.util.List;
import com.spring.mvc.SrpingMvc.model.Article;
import com.spring.mvc.SrpingMvc.model.UserInfo;
public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
	List<Article> getAllUserArticles();
} 