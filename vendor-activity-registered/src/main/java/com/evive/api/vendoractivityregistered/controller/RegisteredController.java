package com.evive.api.vendoractivityregistered.controller;

import com.evive.api.vendoractivityregistered.model.Activity;
import com.evive.api.vendoractivityregistered.service.RegisteredService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisteredController {

  @Autowired
  RegisteredService registeredService;

  @GetMapping("/registered")
  public List<Activity> getRegisteredActivity(){
    return registeredService.getRegistered();
  }
}
