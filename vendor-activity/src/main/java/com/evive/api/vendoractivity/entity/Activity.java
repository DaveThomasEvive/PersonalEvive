package com.evive.api.vendoractivity.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@NamedQuery(name="find_all_activities", query="select a from Activity a")
public class Activity {


  @EmbeddedId
  private ActivityKey id;

  private String data;



}
