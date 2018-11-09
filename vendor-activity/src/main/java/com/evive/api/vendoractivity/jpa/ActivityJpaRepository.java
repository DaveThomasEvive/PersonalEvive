package com.evive.api.vendoractivity.jpa;

import com.evive.api.vendoractivity.entity.Activity;
import com.evive.api.vendoractivity.entity.ActivityKey;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ActivityJpaRepository {

  @PersistenceContext
  EntityManager entityManager;

  public Activity findByKey(ActivityKey activityKey){

    return entityManager.find(Activity.class, activityKey);
  }

  public List<Activity> findAll() {
    TypedQuery<Activity> namedQuery = entityManager.createNamedQuery("find_all_activities", Activity.class);
    return namedQuery.getResultList();
  }

  public Activity update(Activity activity) {
    return entityManager.merge(activity);
  }

  public Activity insert(Activity activity) {
    return entityManager.merge(activity);
  }

  public void deleteById(ActivityKey activityKey) {
    Activity activity = findByKey(activityKey);
    entityManager.remove(activity);
  }

  public List<Activity> query(ActivityKey activityKey){
    int queryCount = 0;
    StringBuilder queryString = new StringBuilder("Select a from Activity a ");

    if (activityKey.getUpin() != null){
      queryString.append(whereAndOrString(queryCount, ""));
      queryString.append(" a.id.upin = '" + activityKey.getUpin() + "'");
      queryCount++;
    }
    if (activityKey.getClientCode() != null){
      queryString.append(whereAndOrString(queryCount, " and"));
      queryString.append(" a.id.clientCode = '" + activityKey.getClientCode()+ "'");
      queryCount++;
    }
    if (activityKey.getVendor() != null){
      queryString.append(whereAndOrString(queryCount, " and"));
      queryString.append(" a.id.vendor = '" + activityKey.getVendor()+ "'");
      queryCount++;
    }
    if (activityKey.getCreatedAt() != null){
      queryString.append(whereAndOrString(queryCount, " and"));
      queryString.append(" a.id.createdAt = '" + activityKey.getCreatedAt()+ "'");
      queryCount++;
    }
    System.out.println(queryString);
    TypedQuery<Activity> dynamicQuery = entityManager.createQuery(queryString.toString(), Activity.class);
    return dynamicQuery.getResultList();
  }

  private String whereAndOrString(int count, String andOr){
    if (count == 0) {
      return "Where";
    }
    return andOr;
  }

}
