package com.example.HR_Management.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.HR_Management.entity.Country;
import com.example.HR_Management.projection.CountryProjection;

@RepositoryRestResource(path = "countries")
public interface CountryRepository extends JpaRepository<Country, String> {

	Optional<Country> findByCountryNameIgnoreCase(String countryName);
	 
    List<Country> findByRegion_RegionId(BigDecimal regionId);
 
    boolean existsByCountryNameIgnoreCase(String countryName);
}
