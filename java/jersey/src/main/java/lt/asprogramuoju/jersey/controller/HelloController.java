package lt.asprogramuoju.jersey.controller;

import lt.asprogramuoju.jersey.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GET
    @RequestMapping("/hello")
    @Produces("text/plain")
    public String hello() {
        return helloService.hello();
    }

}
