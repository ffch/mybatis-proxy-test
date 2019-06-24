package cn.pomit.mybatisproxy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.pomit.mybatis.ProxyHandlerFactory;
import cn.pomit.mybatis.configuration.MybatisConfiguration;
import cn.pomit.mybatisproxy.domain.UserInfo;
import cn.pomit.mybatisproxy.service.UserInfoService;
import cn.pomit.mybatisproxy.service.UserInfoServiceImp;

public class MybatisApp {
	public static String PropertiesFile = "application.properties";
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		
		//也可以直接写在代码里。
//		properties.put("mybatis.mapper.scan", "cn.pomit.mybatisproxy.mapper");
//		properties.put("mybatis.datasource.type", "POOLED");
//		properties.put("mybatis.datasource.driver", "com.mysql.jdbc.Driver");
//		properties.put("mybatis.datasource.url", "jdbc:mysql://127.0.0.1:3306/boot?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
//		properties.put("mybatis.datasource.username", "cff");
//		properties.put("mybatis.datasource.password", "123456");
		
		//读取配置文件
		InputStream resource = MybatisApp.class.getClassLoader().getResourceAsStream(PropertiesFile);
		if(resource == null){
			throw new IOException(PropertiesFile + "文件不存在！");
		}
		properties.load(resource);
		resource.close();
		
		MybatisConfiguration.initConfiguration(properties );

//		UserInfoService userInfoService = ProxyHandlerFactory.getTransaction(UserInfoServiceImp.class);
		
		UserInfoService userInfoService = new UserInfoServiceImp();
		
		UserInfo userInfo = userInfoService.findUser("cff");
		System.out.println(userInfo.toString());
	}

}
