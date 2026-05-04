package com.example.HR_Management.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.HR_Management.entity.Country;
import com.example.HR_Management.projection.CountryProjection;

@RepositoryRestResource(path = "countries", excerptProjection=CountryProjection.class)
public interface CountryRepository extends JpaRepository<Country, String> {
	@EntityGraph(attributePaths = "region")
	Optional<Country> findById(String id);

	Optional<Country> findByCountryNameIgnoreCase(String countryName);
	 
    List<Country> findByRegion_RegionId(BigDecimal regionId);
 
    boolean existsByCountryNameIgnoreCase(String countryName);
    @EntityGraph(attributePaths = "region")
    Page<Country> findAll(Pageable pageable);
    
    @EntityGraph(attributePaths = "region")
    Country findWithRegionByCountryId(String countryId);
}
