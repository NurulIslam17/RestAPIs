package com.nurul.RestAPIs.repository;

import com.nurul.RestAPIs.entity.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends JpaRepository<Enroll,Long> {
}
