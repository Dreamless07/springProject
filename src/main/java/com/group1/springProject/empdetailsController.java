//control layer
package com.group1.springProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//because a control layer
@RequestMapping("/Repository/Controller")//url
public class empdetailsController {

    @Autowired//connects repository and control layer internally
    private empdetailsRepository empdetailsRepository;//create object for interface to connect repository and control layer

    @GetMapping// url
    public List<employeeClass> getAllEmpDetails(){//create a method referencing the same class where table exists, use inbuilt List interface because group of data
        return empdetailsRepository.findAll();//return the details after creation of object and prints into browser in JSON format
    }

}
