package com.summer.learning.services;

import com.summer.learning.models.Country;

import java.util.List;

public interface CountryService {

    Country getCountryById(Long id);
    
    Country getCountryByName(String name);
    
    List<Country> getAllCountry();
    
    Country addNewCountry(Country country);
    
    Country editCountry(Country country);
    
    void removeCountry(Long id);
}
