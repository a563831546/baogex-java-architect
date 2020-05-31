package com.baogex.quickstart.resteasy;

import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @Author: baogex
 * @Date: 2020/5/3
 */

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class MessageRestService {

    @GET
    @Path("/test")
    public String getCity(String id) {
        return "测试" + id + " over";
    }

}
