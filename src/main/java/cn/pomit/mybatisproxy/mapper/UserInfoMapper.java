package cn.pomit.mybatisproxy.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.pomit.mybatisproxy.domain.UserInfo;

@Mapper
public interface UserInfoMapper {
	
	UserInfo selectByUserName(String userName);
	
	int save(UserInfo userInfo);
	
	
}
