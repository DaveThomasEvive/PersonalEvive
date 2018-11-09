package com.evive.api.vendoractivity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityKey implements Serializable {

  private Integer upin;
  private String clientCode;
  private String vendor;
  private LocalDateTime createdAt;
}
