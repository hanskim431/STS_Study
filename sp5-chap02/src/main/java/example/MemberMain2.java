package example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import example.config.ExamConfig;
import example.dao.MemberDao;

public class MemberMain2 {
	public static void main(String[] args) {
		
	 	ApplicationContext ctx = new AnnotationConfigApplicationContext(ExamConfig.class);
	 	
	 	MemberDao dao1 = ctx.getBean("memberDAO",MemberDao.class);
	 	MemberDao dao2 = ctx.getBean("mdao",MemberDao.class);
	 	System.out.println(dao1.getDataSource());
	 	System.out.println(dao2.getDataSource());
	 	System.out.println(dao1);
	 	System.out.println(dao2);
	 	
	 	MemberDao dao3 = (MemberDao) ctx.getBean("memberDao");
	 	MemberDao dao4 = (MemberDao) ctx.getBean("mdao");
	 	
	 	System.out.println(dao3.getDataSource());
	 	System.out.println(dao4.getDataSource());
	 	System.out.println(dao3);
	 	System.out.println(dao4);
	 	
	}
}
