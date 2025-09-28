package com.tech.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tech.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	public Optional<List<Employee>> findAllByFirstName(String fname);
    
	@Transactional
	public void deleteAllByFirstName(String fname);
	
	public List<Employee> findDistinctByDepartment(String department);
	
	public List<Employee> findAllByFirstNameAndLastName(String fname,String lname);
	
	public List<Employee> findByFirstNameOrLastName(String fname,String lname);
	
	public List<Employee> findByMiddleNameEquals(String mname);
	
	public List<Employee> findByAgeGreaterThanEqual(int age);
	
	public List<Employee> findByAgeLessThanEqual(int age);
	
	public List<Employee> findByRankAfter(Long rank);
	
	public List<Employee> findByRankBefore(Long rank);
	
	public List<Employee> findByFirstNameLike(String fname);
	
	public List<Employee> findByFirstNameNotLike(String fname);
	
	public List<Employee> findByEmailIsNotNull();
	
	public List<Employee> findByEmailIsNull();
	
	public List<Employee> findByFirstNameContaining(String fname);
	
	public List<Employee> findByFirstNameNotContaining(String fname);
	
	public List<Employee> findByMiddleNameStartingWith(String mname);
	
	public List<Employee> findByMiddleNameEndingWith(String mname);
	
	public List<Employee> findByOrderByRankAsc();
	
	public List<Employee> findByFirstNameOrderByLastNameDesc(String fname);
	
	public List<Employee> findByIdIn(List<Integer> ids);
	
	public List<Employee> findByIdNotIn(List<Integer> ids);
	
	public List<Employee> findByFirstNameIgnoreCase(String fname);
	
	public List<Employee> findByAddrsVillageNot(String village);
	
	public List<Employee> findByRankBetween(Long start,Long end);
	
	@Query("Select e from Employee e where e.firstName=:name")
	public List<Employee> getByName(@Param("name") String name);
	
	
	
	

	
	
	
	
}
