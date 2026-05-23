package com.agency.service;


import com.agency.entity.ServiceEntity;
import com.agency.exception.MyException;
import com.agency.repository.ServiceRepository;
import com.agency.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    //Save Service --> Creating method and return repository bcoz we get all method there like save, update
     public ServiceEntity addService(ServiceEntity serviceEntity){
        return serviceRepository.save(serviceEntity);
    }

    // For multiple record at a time
    public List<ServiceEntity> createService(List<ServiceEntity> serviceEntity){
         return serviceRepository.saveAll(serviceEntity);
    }

        //Get All service

    public List<ServiceEntity> getAllService(){
        return serviceRepository.findAll();
    }

    // Get Service by Id
    public ServiceEntity getServiceById(Long id) throws MyException {
         InputValidator inputValidator = new InputValidator();
         inputValidator.validateId(id);
         return serviceRepository.findById(id).orElse(null);
    }

    // Update Service

    public ServiceEntity updateService(Long id, ServiceEntity updateService){
        ServiceEntity existingService = serviceRepository.findById(id).orElse(null);

        if (existingService !=null){
            existingService.setServiceName(updateService.getServiceName());
            existingService.setDescription(updateService.getDescription());
             existingService.setPrice(updateService.getPrice());

             return serviceRepository.save(existingService);

        }
        return null;
    }

     // Delete Service
    public String deleteService(Long id){
         serviceRepository.deleteById(id);
         return "Service Deleted Successfully";
    }
}
