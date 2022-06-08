package com.karthik.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMsgConsumerRoute extends RouteBuilder {

	
	@Value("${receivequeue}")
	private String receivequeue;
	
    @Override
    public void configure() throws Exception {
    	
    	
     
        from("timer:test?period=6000")
                .transform().constant("Hello Message from Apache Camel ")
                .log("${body}");
                //send this message to ActiveMQ queue
                .to("activemq:receivequeue");
    }
    
    
}


