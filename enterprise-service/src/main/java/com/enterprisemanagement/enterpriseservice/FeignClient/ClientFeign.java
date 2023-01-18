package com.enterprisemanagement.enterpriseservice.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("client-service")
public interface ClientFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/client")
    List<Client> getAllClients();
}
