//control layer
package com.group1.springProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//because a control layer
@RequestMapping("/Repository/Controller")//to fetch base url
public class empdetailsController {

    @Autowired//connects repository and control layer internally
    private empdetailsRepository empdetailsRepository;//create object for interface to connect repository and control layer

    @GetMapping//for fetching url
    public List<employeeClass> getAllEmpDetails(){//create a method referencing the same class where table exists, use inbuilt List interface because group of data
        return empdetailsRepository.findAll();//return the details after creation of object and prints into browser in JSON format
    }

    @PostMapping//for insertion
    public employeeClass inserion(@RequestBody employeeClass empob){ //create a method to insert, use arguments and convert to object to insert multiple attributes
        return empdetailsRepository.save(empob);//for insertion use save, @RequestBody coverts JSON to Object
    }

    @GetMapping("{id}")//for getting variable id, so mention in flower brackets
    public employeeClass fetchEmpByID(@PathVariable long id){//create a method to fetch by id, @PathVariable for variables
        return empdetailsRepository.findById(id).orElse(null);//for fetching specific id, find by id or null if not there;
    }
}
