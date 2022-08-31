package com.example;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/timeout")
public class TimeoutController {

    @GET
    @Timeout(5000)
    @Fallback(fallbackMethod = "fallback")
    public Response recommendations(@QueryParam("delay") long delay) {
        try {
            Thread.sleep(delay * 1000);
        } catch(InterruptedException e) {
            //Do Nothing
        }
        return Response.status(Response.Status.OK).entity("success").build();
    }

    private Response fallback(long delay) {
        log.info("failback executed.");
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("timeout").build();
    }

}
