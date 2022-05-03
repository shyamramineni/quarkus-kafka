package org.acme.kafka.producer;

import java.util.UUID;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import io.smallrye.mutiny.Multi;

@Path("/quotes")
public class QuotesResource {

    private static final Logger logger = Logger.getLogger(QuotesResource.class);

    @Channel("quote-requests")
    Emitter<String> quoteRequestEmitter;

    @Channel("quotes")
    Multi<Quote> quotes;

    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest() {
        UUID uuid = UUID.randomUUID();
        logger.info("POST /quotes/request "+uuid.toString());
        quoteRequestEmitter.send(uuid.toString());
        return uuid.toString();
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Quote> stream() {
        logger.info("POST /quotes/stream ");
        return quotes;
    }
    
}
