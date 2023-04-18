package com.ambula.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ambula.location.entity.UserLocation;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LocationRepository extends JpaRepository<UserLocation, Long>{

	@Query(value="SELECT name (6371 * acos(cos(radians(0)) * cos(radians(latitude)) * cos(radians(longitude) - radians(0)) + sin(radians(0)) * sin(radians(latitude)))) AS distance FROM user_location ORDER BY distance LIMIT ?1 ", nativeQuery = true)
	List<String> getNUsers(int n);
}
