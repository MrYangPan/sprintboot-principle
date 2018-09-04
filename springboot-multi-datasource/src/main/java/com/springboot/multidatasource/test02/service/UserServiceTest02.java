package com.springboot.multidatasource.test02.service;

import com.springboot.multidatasource.test01.mapper.UserMapperTest01;
import com.springboot.multidatasource.test02.mapper.UserMapperTest02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceTest02<br>
 * 作者: 每特教育-余胜军<br>
 * 联系方式:QQ644064779|WWW.itmayiedu.com<br>
 */
@Service
@Slf4j
public class UserServiceTest02 {
	@Autowired
	private UserMapperTest02 userMapperTest02;
	@Autowired
	private UserMapperTest01 userMapperTest01;

	@Transactional(transactionManager = "test2TransactionManager")
	public int insertUser(String name, Integer age) {
		int insertUserResult = userMapperTest02.insert(name, age);
		log.info("######insertUserResult:{}##########", insertUserResult);
		// 怎么样验证事务开启成功!~
		int i = 1 / age;
		return insertUserResult;
	}

	@Transactional()
	public int insertUserTest01AndTest02(String name, Integer age) {
		// 传统分布式事务解决方案 jta+atomikos 注册同一个全局事务中
		// 第一个数据源
		int insertUserResult01 = userMapperTest01.insert(name, age);
		// 第二个数据源
		int insertUserResult02 = userMapperTest02.insert(name, age);
		int i = 1 / 0;
		int result = insertUserResult01 + insertUserResult02;
		// test01入库 test02回滚
		return result;
	}

}
