package com.kuma.domain.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.kuma.domain.api.user.User;
import com.kuma.domain.api.user.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<User> getUserList() {
		String sql = "select * from test_user";
		List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper(User.class));
		return list;
	}

	@Override
	public boolean insertUser(User user) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user,entity);
		entityManager.persist(entity);
		entityManager.flush();
		return true;
	}
	
}
