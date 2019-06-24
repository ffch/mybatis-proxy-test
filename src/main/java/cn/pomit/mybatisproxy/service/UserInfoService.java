package cn.pomit.mybatisproxy.service;

import cn.pomit.mybatisproxy.domain.UserInfo;

public interface UserInfoService {

	public UserInfo findUser(String userName);

	public int save(UserInfo user) throws Exception;
}
