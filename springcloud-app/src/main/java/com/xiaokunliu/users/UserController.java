package com.xiaokunliu.users;

//import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project:java-code
 * file:UserController
 * package:com.xiaokunliu.users
 * date:2019/9/21 13:15
 * author:keithl
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String getName(@PathVariable(name = "name") String name){
        return "from the name:"+name;
    }

    @RequestMapping(value = "/get/eureka", method = RequestMethod.GET)
    public Map<String,Object> getEurekaInfo(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("cloud-app");
        Map<String,Object> map = new HashMap<>();
        for (ServiceInstance serviceInstance:serviceInstances){
            LOG.info("id is %s, the host name is %s, the server id is %s",
                    serviceInstance.getInstanceId(), serviceInstance.getHost(), serviceInstance.getServiceId());
            map.put(serviceInstance.getInstanceId(), serviceInstance);
        }
        return map;
    }
}
