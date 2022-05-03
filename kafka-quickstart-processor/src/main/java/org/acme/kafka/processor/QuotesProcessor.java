package org.acme.kafka.processor;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.acme.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import io.smallrye.common.annotation.Blocking;

@ApplicationScoped
public class QuotesProcessor {

    private static final Logger logger = Logger.getLogger(QuotesProcessor.class);
    
    private Random random = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    public Quote process(String quoteRequest) throws InterruptedException {
        logger.info(" QuotesProcessor quoteRequest "+quoteRequest);
        Thread.sleep(200);
        return new Quote(quoteRequest, random.nextInt(100));
        
    }
    

}
