package com.evive.api.vendoractivity.service;

import com.evive.api.vendoractivity.entity.Activity;
import com.evive.api.vendoractivity.entity.ActivityKey;
import com.evive.api.vendoractivity.jpa.ActivityJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

  @Autowired
  ActivityJpaRepository activityJpaRepository;

  public List<Activity> getAllActivities(){
    return activityJpaRepository.findAll();
  }

  public List<Activity> queryActivities(ActivityKey activityKey){
    return activityJpaRepository.query(activityKey);
  }

  public Activity getActivity(ActivityKey activityKey){
    return activityJpaRepository.findByKey(activityKey);
  }

  public ResponseEntity insertActivity(Activity activity){

    ResponseEntity response = null;

    if(activity.equals(activityJpaRepository.findByKey(activity.getId()))){
      response = new ResponseEntity("no no already exists", HttpStatus.CONFLICT);
    }else{
      response = new ResponseEntity(activityJpaRepository.insert(activity), HttpStatus.CREATED);
    }
    return response;

  }

  public ResponseEntity updateActivity(Activity activity){

    ResponseEntity response = null;

    if(activity.getId().equals(activityJpaRepository.findByKey(activity.getId()).getId())){
      response = new ResponseEntity(activityJpaRepository.update(activity), HttpStatus.OK);
    }else{
      response = new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
    }
    return response;

  }

  public ResponseEntity deleteActivity(ActivityKey activityKey){

    ResponseEntity response = null;

    if(activityKey.equals(activityJpaRepository.findByKey(activityKey).getId())){
      activityJpaRepository.deleteById(activityKey);
      response = new ResponseEntity(HttpStatus.OK);
    }else{
      response = new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
    }
    return response;

  }

}
