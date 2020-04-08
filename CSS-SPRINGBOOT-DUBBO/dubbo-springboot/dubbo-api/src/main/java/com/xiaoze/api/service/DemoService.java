package com.xiaoze.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;

/**
 * DemoService
 * 服务Api接口类
 *
 * @author xiaoze
 * @date 2018/6/6
 */
@Path("demo")
public interface DemoService {
    @GET
    @Path("/hello/{id:\\d+}")
    @Consumes({MediaType.APPLICATION_JSON})
    String sayHello(@PathParam("id") String id);

}
