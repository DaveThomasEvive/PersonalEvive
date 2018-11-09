package com.evive.api.vendoractivityregistered.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ActivityKey {

  private Integer upin;
  private String clientCode;
  private String vendor;
  private LocalDateTime createdAt;
}
