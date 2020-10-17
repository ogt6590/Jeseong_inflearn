package kr.co.softcampus.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// WebApplicationInitializer 구현한 class 가있으면 was 실행시 onStartup 을 실행한다 
//public class SpringConfigClass implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		//spring mvc 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
//		AnnotationConfigWebApplicationContext servletAppContext =new AnnotationConfigWebApplicationContext();
//		servletAppContext.register(ServletAppContext.class);
//		
//		// 요청 발생시 요청을 처리하는 서블릿을  DispatcherServlet 으로 설정해준다 
//		DispatcherServlet dispatcherServlet=new DispatcherServlet(servletAppContext);
//	
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//		
//		//부가설정 
//		//가장먼저 로딩하겠다는 뜻 
//		servlet.setLoadOnStartup(1);
//		//모든 요청을 이 서블릿이 가장먼저 받아들이겠다 
//		servlet.addMapping("/");
//		
//		//Bean을 정의하는 클래스를 지정한다 
//		AnnotationConfigWebApplicationContext rootAppContext=new AnnotationConfigWebApplicationContext();
//		rootAppContext.register(RootAppContext.class);
//		
//		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//		servletContext.addListener(listener);
//		
//		//파라미터 인코딩 설정 
//		FilterRegistration.Dynamic filter=servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//		filter.setInitParameter("encoding", "UTF-8");
//		filter.addMappingForServletNames(null, false, "dispatcher");
//		
//	}
//}

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	//DispatcherServlet 에 매핑할 요청 주소를 셋팅한다 
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//모든 요청 주소에대해서 dispacher서블릿이  반응하게 하겠다
		return new String[] {"/"};
	}
	//spring mvc 프로젝트 설정을 위한 클래스를 지정한다 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	//프로젝트에서 사용할 Bean들을 정의하기 위한 클래스를 지정한다 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
}
