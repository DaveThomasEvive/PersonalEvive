package com.evive.api.vendoractivityregistered.dao;

import com.evive.api.vendoractivityregistered.model.Activity;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VendorActivity {

  public List<Activity> getAllActivity(){

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Activity>> response = restTemplate.exchange("http://localhost:8080/activities", HttpMethod.GET, null,
                                                                    new ParameterizedTypeReference<List<Activity>>(){});
    return response.getBody();
  }

}
