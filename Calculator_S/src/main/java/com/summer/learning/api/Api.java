package com.summer.learning.api;

import com.summer.learning.controllers.CalculationController;
import com.summer.learning.controllers.CountryController;
import com.summer.learning.controllers.ExchangerateController;
import com.summer.learning.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Api.BASE_URL)
public class Api {
    public static final String BASE_URL = "/api";
    
    private CountryController countryController;
    private CalculationController calculationController;
    private ExchangerateController exchangerateController;
    
    @Autowired
    public Api(CountryController countryController, CalculationController calculationController, ExchangerateController exchangerateController){
        
        this.countryController = countryController;
        this.calculationController = calculationController;
        this.exchangerateController = exchangerateController;
    }
    
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List getListCountry(){ return countryController.getAllCountry(); }
    
    @GetMapping({"/list/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Country getSingleCountry(@PathVariable Long id){ return countryController.getCountryById(id); }
    
    @GetMapping({"/list/search"})
    @ResponseStatus(HttpStatus.OK)
    public Country getSingleCountryByName(@RequestParam String name){ return countryController.getCountryByName(name); }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Country updateCountry(@RequestBody Country country){ return countryController.updateCountry(country); }
    
    @DeleteMapping({"/list/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCountry(@PathVariable Long id){ countryController.deleteCountry(id);}
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country createdNewCountry(@Valid @RequestBody Country country){ return countryController.addCountry(country); }
    
    @GetMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public Double calculateSalary(@RequestParam Long id, @RequestParam Integer dailyPay){
        return calculationController.calculateSalary(id, dailyPay);
    }
    
    @GetMapping("/currency")
    @ResponseStatus(HttpStatus.OK)
    public List getDataFromNBP(){ return exchangerateController.getMapCurrencyList();}
    
}
