package cn.pomit.mybatisproxy.service;

import cn.pomit.mybatis.ProxyHandlerFactory;
import cn.pomit.mybatis.annotation.Transactional;
import cn.pomit.mybatisproxy.domain.UserInfo;
import cn.pomit.mybatisproxy.mapper.UserInfoMapper;

@Transactional
public class UserInfoServiceImp implements UserInfoService{

	UserInfoMapper userInfoMapper = ProxyHandlerFactory.getMapper(UserInfoMapper.class);

	public UserInfo findUser(String userName) {		
		return userInfoMapper.selectByUserName(userName);
	}

	public int save(UserInfo user) throws Exception{		
		UserInfo test = userInfoMapper.selectByUserName(user.getUserName());
		System.out.println(test);
		if(test == null){
			int ret = userInfoMapper.save(user);
			System.out.println(ret);
			return ret;
		}

		return -1;
	}

}
