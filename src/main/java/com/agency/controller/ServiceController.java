package com.agency.controller;

import com.agency.entity.ServiceEntity;
import com.agency.exception.MyException;
import com.agency.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")

public class ServiceController {

    @Autowired
    public ServiceService serviceService;

    // For creating service
    @PostMapping
    public ServiceEntity addService(@RequestBody ServiceEntity serviceEntity){
        return serviceService.addService(serviceEntity);
    }

    // for creating multiple record
    @PostMapping("/bulk")
    public List<ServiceEntity> createServices(@RequestBody List<ServiceEntity> serviceEntity) {
        return serviceService.createService(serviceEntity);
    }

    // Get All Service
    @GetMapping
    public List<ServiceEntity> getAllService(){
        return serviceService.getAllService();
    }

    // Get Service by Id
//@PathVariable and RequestParam
    @GetMapping("/{id}")
    public ServiceEntity getServiceById(@PathVariable("id") Long id) throws MyException {
        return serviceService.getServiceById(id);
    }


    @PutMapping("/{id}")
    public ServiceEntity updateService(@PathVariable Long id, @RequestBody ServiceEntity serviceEntity){
        return serviceService.updateService(id,serviceEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id){
        return serviceService.deleteService(id);
    }

}
