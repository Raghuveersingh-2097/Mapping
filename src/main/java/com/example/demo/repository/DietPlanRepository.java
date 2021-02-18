package com.example.demo.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.DietPlan;

@Repository
public interface DietPlanRepository extends CrudRepository<DietPlan,Long>{

   DietPlan  findByCustomerIdentifier(String customerIdentifier);  
}
