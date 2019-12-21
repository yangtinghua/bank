package com.yth;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
public class InitProject implements ApplicationListener<ContextRefreshedEvent>{
    private static final Logger LOG = LoggerFactory.getLogger(InitProject.class);




	public void onApplicationEvent(ContextRefreshedEvent event) {
		 LOG.info("==========init project===========");
	//    
	  
	}
    
    
//    public void run(ApplicationArguments args) throws Exception {
//        LOG.info("==========init project===========");
//    
//     String name=   service.test("lishuang");
//        System.out.println(name);
//    }
}
