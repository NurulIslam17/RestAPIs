package com.nurul.RestAPIs.repository;

import com.nurul.RestAPIs.entity.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameOrEmail(String name, String email);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.type = 'PENDING'")
    Long getStudentCountByType(String status);
}
