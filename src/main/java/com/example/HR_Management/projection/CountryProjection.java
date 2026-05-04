package com.example.HR_Management.projection;

import java.math.BigDecimal;

import org.springframework.data.rest.core.config.Projection;
import com.example.HR_Management.entity.Country;
import com.example.HR_Management.entity.Region;

@Projection(name = "countryWithRegion", types = { Country.class })
public interface CountryProjection {
    String getCountryId();
    String getCountryName();
  
    RegionSummary getRegion();

    interface RegionSummary {
        BigDecimal getRegionId();
        String getRegionName();
    }
}