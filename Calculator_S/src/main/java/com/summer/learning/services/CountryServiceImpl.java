package com.summer.learning.services;

import com.summer.learning.exceptions.NotFoundException;
import com.summer.learning.models.Country;
import com.summer.learning.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    
    private final CountryRepository countryRepository;
    
    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }
    
    @Override
    public Country getCountryById(Long id){
        return countryRepository.findById(id)
                                .orElseThrow(() -> new NotFoundException("Nie mam takiego Państwa"));
    }
    
    @Override
    public Country getCountryByName(String name){
        return countryRepository.findByName(name);
    }
    
    @Override
    public List<Country> getAllCountry(){
        return countryRepository.findAll();
    }
    
    @Override
    public Country addNewCountry(Country country){
        return countryRepository.save(country);
    }
    
    @Override
    public Country editCountry(Country country){ return countryRepository.save(country); }
    
    @Override
    public void removeCountry(Long id){
        Country country = getCountryById(id);
        if(country != null) {
            countryRepository.delete(country);
        }
    }
}
