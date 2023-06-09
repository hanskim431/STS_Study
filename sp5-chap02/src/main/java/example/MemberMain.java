package example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import example.dao.MemberDao;

public class MemberMain {
	public static void main(String[] args) {
		
	 	BeanFactory ctx = new GenericXmlApplicationContext("classpath:example/appCtx.xml");
	 	
	 	MemberDao dao1 = ctx.getBean("memberDao",MemberDao.class);
	 	MemberDao dao2 = ctx.getBean("memberDao2",MemberDao.class);
	 	System.out.println(dao1.getDataSource());
	 	System.out.println(dao2.getDataSource());
	 	System.out.println(dao1);
	 	System.out.println(dao2);
	 	
	 	MemberDao dao3 = (MemberDao) ctx.getBean("memberDao");
	 	MemberDao dao4 = (MemberDao) ctx.getBean("memberDao2");
	 	
	 	System.out.println(dao3.getDataSource());
	 	System.out.println(dao4.getDataSource());
	 	System.out.println(dao3);
	 	System.out.println(dao4);
	 	
	}
}
