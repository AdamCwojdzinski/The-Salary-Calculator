package com.summer.learning.controllers;

import com.summer.learning.models.Country;
import com.summer.learning.repositories.CountryRepository;
import com.summer.learning.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController {
    
    private final CountryService countryService;
    private final CountryRepository countryRepository;
    
    @Autowired
    public CountryController(CountryService countryService, CountryRepository countryRepository){
    
        this.countryService = countryService;
        this.countryRepository = countryRepository;
    }
    
    public List getAllCountry(){ return countryService.getAllCountry(); }
    
    public Country getCountryById(Long id){ return countryService.getCountryById(id); }
    
    public Country getCountryByName(String name){ return countryService.getCountryByName(name); }
    
    public Country updateCountry(Country country){ return countryService.editCountry(country); }
    
    public void deleteCountry(Long id){ countryService.removeCountry(id); }
    
    public Country addCountry(Country country){ return countryService.addNewCountry(country); }
}
