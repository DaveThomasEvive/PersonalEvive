package com.evive.api.vendoractivity.controller;

import com.evive.api.vendoractivity.entity.Activity;
import com.evive.api.vendoractivity.entity.ActivityKey;
import com.evive.api.vendoractivity.service.ActivityService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivityController {

  @Autowired
  private ActivityService activityService;

  @GetMapping("/activities")
  public List<Activity> getActivities() {
    return activityService.getAllActivities();
  }

  @GetMapping("/activities/query")
  public List<Activity> queryActivities(
      @RequestParam(value = "upin", required=false) Integer upin ,
      @RequestParam(value = "client_code", required=false) String clientCode ,
      @RequestParam(value = "vendor", required=false) String vendor,
      @RequestParam(value = "created_at", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdAt
  ){
    return activityService.queryActivities(ActivityKey.builder().upin(upin).clientCode(clientCode).vendor(vendor).createdAt(createdAt).build());
  }

  @GetMapping("/activity")
  public Activity getActivty(
      @RequestParam(value = "upin", required=true) Integer upin ,
      @RequestParam(value = "client_code", required=true) String clientCode ,
      @RequestParam(value = "vendor", required=true) String vendor,
      @RequestParam(value = "created_at", required=true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdAt
  ){
    return activityService.getActivity(ActivityKey.builder().upin(upin).clientCode(clientCode).vendor(vendor).createdAt(createdAt).build());
  }

  @PostMapping("/activity")
  public ResponseEntity postActivity(
      @RequestBody Activity activity){
    return activityService.insertActivity(activity);
  }

  @PutMapping("/activity")
  public ResponseEntity putActivity(
      @RequestBody Activity activity){
    return activityService.updateActivity(activity);
  }

  @DeleteMapping("/activity")
  public ResponseEntity deleteActivity(
      @RequestBody ActivityKey activityKey){
    return activityService.deleteActivity(activityKey);
  }

}
