package com.evive.api.vendoractivityregistered.service;

import com.evive.api.vendoractivityregistered.dao.VendorActivity;
import com.evive.api.vendoractivityregistered.model.Activity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogonService {

  @Autowired
  VendorActivity vendorActivity;

  public List<Activity> getLogon(){

    List<Activity> returnActivity = new ArrayList<>();
    List<Activity> listActivity = vendorActivity.getAllActivity();

    for(Activity a : listActivity){
      System.out.println(a);
      if (a.getData().toLowerCase().equals("logon")){
        returnActivity.add(a);
      }
    }
    return returnActivity;
  }

}
