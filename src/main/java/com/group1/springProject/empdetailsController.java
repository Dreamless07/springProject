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

    // POST/INSERT which connects to postman
    @PostMapping//for insertion
    public employeeClass insertion(@RequestBody employeeClass empob){ //create a method to insert, use arguments and convert to object to insert multiple attributes
        return empdetailsRepository.save(empob);//for insertion and update use save, @RequestBody coverts JSON to Object
    }

    // GET/FETCH based on specific id
    @GetMapping("{id}")//for getting variable id, so mention in flower brackets
    public employeeClass fetchEmpByID(@PathVariable long id){//create a method to fetch by id, @PathVariable for variables
        return empdetailsRepository.findById(id).orElse(null);//for fetching specific id, find by id or null if not there;
    }

    // PUT/UPDATE based on specific id
    @PutMapping("{id}")//for updating any attribute based on id
    public employeeClass updateByID(@PathVariable long id,@RequestBody employeeClass updateOb){//create a method to fetch id and argument for storing updated data
        employeeClass fetchID= empdetailsRepository.findById(id).orElse(null);//same as fetch by id method
        fetchID.setName(updateOb.getName());//gets the specific id then sets which attribute needed to change(i.e name and address, then gets the updated data from postman
        fetchID.setAddress(updateOb.getAddress());
        return empdetailsRepository.save(fetchID);//updated data
    }

    // DELETE/REMOVE based on specific id
    @DeleteMapping("{id}")
    public employeeClass deleteByID(@PathVariable long id) {//create method to delete based on id
        employeeClass fetchID= empdetailsRepository.findById(id).orElse(null);//same as fetchById method
        if(fetchID!=null){//if exists and not null then
            empdetailsRepository.delete(fetchID);//delete the id its respective attributes
        }
        return fetchID;//return
    }
}
