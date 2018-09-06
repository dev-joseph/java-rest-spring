package com.spring.mvc.SrpingMvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.spring.mvc.SrpingMvc.model.Article;
import com.spring.mvc.SrpingMvc.model.UserInfo;
@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		short enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
				.setParameter(0, userName).setParameter(1, enabled).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
		}
		return activeUserInfo;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllUserArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}	
} 