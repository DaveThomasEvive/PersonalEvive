package com.evive.api.vendoractivityregistered.controller;

import com.evive.api.vendoractivityregistered.model.Activity;
import com.evive.api.vendoractivityregistered.service.LogonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogonController {
  @Autowired
  LogonService logonService;

  @GetMapping("/logon")
  public List<Activity> getLogonActivity(){
    return logonService.getLogon();
  }
}
