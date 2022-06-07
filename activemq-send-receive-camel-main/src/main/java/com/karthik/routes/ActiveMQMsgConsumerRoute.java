package com.karthik.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMsgConsumerRoute extends RouteBuilder {

	@Value("${sendqueue}")
	private String sendqueue;
	
	@Value("${receivequeue}")
	private String receivequeue;
	
    @Override
    public void configure() throws Exception {
    	
    	
        from("activemq:receivequeue").log("${body}")
                .to("log:received-message-from-active-mq").to("activemq:sendqueue");
        
        
    }
    
    
}


