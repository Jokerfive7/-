package com.bowen.community;

import com.bowen.community.dao.AlphaDao;
import com.bowen.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);

		//从容器中获取相应类型的bean
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		//使用bean名称强制查找某个bean
		alphaDao = applicationContext.getBean("hi", AlphaDao.class);
		System.out.println(alphaDao.select());

	}

	@Test
	public void testBeanManage() {
		//bean的销毁过程：
		//先实例化，再初始化，再执行业务，最后销毁
		//bean在容器中是单例的。如果再次实例化相同的bean，对象是相同的。（哈希值相同）
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

		//如果在bean中加了scope注解强调可以重复实例化，则可以多次实例化
		alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}
	@Test
	public void testBeanConfig() {
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));

	}
	@Override
	//传入的参数就是IoC容器
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	//实际应用中不需要手动注入，直接使用注入注解，将需要的bean注入成属性
	@Autowired
	//使用注解选取对应名称的bean
	@Qualifier("hi")
	private AlphaDao alphaDao;

	@Test
	public void testDI(){
		System.out.println(alphaDao.select());
	}
}
