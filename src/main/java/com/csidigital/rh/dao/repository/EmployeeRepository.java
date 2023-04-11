package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.shared.enumeration.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value ="SELECT serial_number FROM employee WHERE serial_number IS NOT NULL  ORDER BY Id DESC LIMIT 1;",nativeQuery = true)
    String resourceLastCode();

    @Query(value ="SELECT * FROM employee WHERE dtype= 'Employee'", nativeQuery = true)
    List<Employee> getAllCandidates ();

    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
}
