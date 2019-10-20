package com.summer.learning.controllers;

import com.summer.learning.exceptions.NotFoundParameterException;
import com.summer.learning.models.Country;
import com.summer.learning.models.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Controller
public class CalculationController {
    
    private CountryController countryController;
    private ExchangerateController exchangerateController;
    public Integer month = 22;
    
    @Autowired
    public CalculationController(CountryController countryController, ExchangerateController exchangerateController){
        this.countryController = countryController;
        this.exchangerateController = exchangerateController;
    }
    
    public Double calculateSalary(Long id, Integer dailyPayBrutto){
        try{
            if(id != null){
                Country country = countryController.getCountryById(id);
                Double tax = (country.getTax()/100d);
                Integer monthlyIncome = (dailyPayBrutto * month)-country.getFixedCost();
                Double taxDue = monthlyIncome*tax;
                if(country.getRateCode().equals("PLN")){
                    Double salaryPerMonth = (monthlyIncome - taxDue);
                    Double roundedSalaryPerMonth = Math.round(salaryPerMonth * 100.0)/100.0;
                    return roundedSalaryPerMonth;
                }else {
                    Rate rate = exchangerateController.getRateByCurrencyCode(country.getRateCode());
                    Double salaryPerMonth = (monthlyIncome - taxDue)*rate.getMid();
                    Double roundedSalaryPerMonth = Math.round(salaryPerMonth * 100.0)/100.0;
                    return roundedSalaryPerMonth;
                }
            }else{
                throw new NotFoundParameterException("Nie wybrano kraju");
            }
        }catch(NullPointerException e){
            throw new NotFoundParameterException("Nie podałeś stawki za dzień");
        }
        //120*22=2640-1000=1640*0,21=344,4 w dolarach
        //4981,97068 w PLN
    }
}
