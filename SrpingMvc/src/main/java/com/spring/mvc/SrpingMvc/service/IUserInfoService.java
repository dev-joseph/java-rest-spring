package com.spring.mvc.SrpingMvc.service;

import java.util.List;
import org.springframework.security.access.annotation.Secured;
import com.spring.mvc.SrpingMvc.model.Article;
public interface IUserInfoService {
     @Secured ({"ROLE_ADMIN"})
     List<Article> getAllUserArticles();
} 