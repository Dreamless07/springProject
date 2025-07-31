package com.group1.springProject;

import org.springframework.data.jpa.repository.JpaRepository;//inbuilt interface interacts with db
import org.springframework.stereotype.Repository;

@Repository//because a repository layer
public interface empdetailsRepository extends JpaRepository<employeeClass, Long> {//JpaRepository is inbuilt interface, contains table name(class name) and primary key datatyoe
}
