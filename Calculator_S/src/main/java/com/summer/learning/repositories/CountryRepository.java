package com.summer.learning.repositories;

import com.summer.learning.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    
    Country findByName(String name);
}
