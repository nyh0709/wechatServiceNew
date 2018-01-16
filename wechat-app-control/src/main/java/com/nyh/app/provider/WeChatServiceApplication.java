package com.nyh.app.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan( basePackages = {"com.nyh.app"})
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.nyh.app.core.orm"})
public class WeChatServiceApplication {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(WeChatServiceApplication.class, args);
        System.out.println(print());
    }
	
	private static String print(){
        StringBuffer sb = new StringBuffer();
        sb.append("                   _ooOoo_\n");
        sb.append("                  o8888888o\n");
        sb.append("                  88\" . \"88\n");
        sb.append("                  (| ^_^ |)\n");
        sb.append("                  O\\  =  /O\n");
        sb.append("               ____/`---'\\____\n");
        sb.append("             .'  \\\\|     |//  `.\n");
        sb.append("            /  \\\\|||  :  |||//  \\ \n");
        sb.append("           /  _||||| -:- |||||-  \\ \n");
        sb.append("           |   | \\\\\\  -  /// |   |\n");
        sb.append("           | \\_|  ''\\---/''  |   |\n");
        sb.append("           \\  .-\\__  `-`  ___/-. /\n");
        sb.append("         ___`. .'  /--.--\\  `. . __\n");
        sb.append("      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n");
        sb.append("     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n");
        sb.append("     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n");
        sb.append("======`-.____`-.___\\_____/___.-`____.-'======\n");
        sb.append("                   `=---='\n");
        sb.append("...................................................\n");
        return sb.toString();
    }
	
	
	
	
//	 @Bean
//	    public EmbeddedServletContainerFactory servletContainer() {
//	        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//	            @Override
//	            protected void postProcessContext(Context context) {
//	                SecurityConstraint constraint = new SecurityConstraint();
//	                constraint.setUserConstraint("CONFIDENTIAL");
//	                SecurityCollection collection = new SecurityCollection();
//	                collection.addPattern("/*");
//	                constraint.addCollection(collection);
//	                context.addConstraint(constraint);
//	            }
//	        };
//	        tomcat.addAdditionalTomcatConnectors(httpConnector());
//	        return tomcat;
//	    }
//
//	    @Bean
//	    public Connector httpConnector() {
//	        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//	        connector.setScheme("http");
//	        //Connector监听的http的端口号
//	        connector.setPort(8081);
//	        connector.setSecure(false);
//	        //监听到http的端口号后转向到的https的端口号
//	        connector.setRedirectPort(8443);
//	        return connector;
//	    }

}
