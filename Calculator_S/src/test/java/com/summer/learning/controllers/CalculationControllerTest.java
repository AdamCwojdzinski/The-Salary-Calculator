package com.summer.learning.controllers;

import com.summer.learning.exceptions.NotFoundParameterException;
import com.summer.learning.models.Country;
import com.summer.learning.models.Rate;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculationControllerTest
{
    
    @Mock
    CountryController countryController;
    
    @Spy
    ExchangerateController exchangerateController;
    
    @InjectMocks
    CalculationController calculationController;
    
    @Test
    public void shouldCalculationSalaryForGermany() {
        
        //given
        Country germany = new Country((long)1, "Niemcy", 20, "EUR", 800);
        Rate rate = new Rate("167/A/NBP/2019", "2019-08-29", 4.3845);
        
        //when
        when(countryController.getCountryById((long)1)).thenReturn(germany);
        when(exchangerateController.getRateByCurrencyCode("EUR")).thenReturn(rate);
        
        //then
        Double salary = 6453.98;
        assertEquals(salary, calculationController.calculateSalary((long) 1, 120));
        verify(countryController, times(1)).getCountryById((long)1);
        verify(exchangerateController, times(1)).getRateByCurrencyCode("EUR");
        //verify(calculationController, times(1)).calculateSalary((long) 1, 120);
    }
    
    @Test
    public void shouldCalculationSalaryForPoland(){
        
        //given
        Country poland = new Country((long)4, "Polska", 19, "PLN", 1200);
        
        //when
        when(countryController.getCountryById((long)4)).thenReturn(poland);
        
        //then
        Double salary = 1522.80;
        assertEquals(salary, calculationController.calculateSalary((long)4, 140));
        verify(countryController, times(1)).getCountryById((long)4);
        //verify(calculationController, times(1)).calculateSalary((long) 4, 140);
    }
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void shouldReturnNotFoundParameterException(){
        
        expectedException.expect(NotFoundParameterException.class);
        expectedException.expectMessage("Nie wybrano kraju");
        
        //when
        //when(countryController.getCountryById(null)).thenReturn(null);
        
        //then
        Double salary = 1522.80;
        assertEquals(salary, calculationController.calculateSalary(null, 140));
        verify(countryController, times(1)).getCountryById((long)1);
        verify(calculationController, times(1)).calculateSalary((long) 1, 140);
        
    }
    
    @Test
    public void shouldReturnExceptionDailyPayBrutto() throws NotFoundParameterException {
        
        expectedException.expect(NotFoundParameterException.class);
        expectedException.expectMessage("Nie podałeś stawki za dzień");
        //given
        Country poland = new Country((long)4, "Polska", 19, "PLN", 1200);
        
        //when
        when(countryController.getCountryById((long)4)).thenReturn(poland);
    
        //then
        Double salary = 1522.80;
        assertEquals(salary, calculationController.calculateSalary((long)4, null));
        verify(countryController, times(1)).getCountryById((long)4);
        verify(calculationController, times(1)).calculateSalary((long) 4, null);
    }
    
    private List<Country> prepareMockData() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country((long) 1, "Stany Zjednoczone Ameryki", 21, "USD", 1000));
        countries.add(new Country((long) 2, "Wielka Brytania", 25, "GBP", 600));
        countries.add(new Country((long) 3, "Niemcy", 20, "EUR", 800));
        countries.add(new Country((long) 4, "Polska", 19, "PLN", 1200));
        countries.add(new Country((long) 5, "Szwajcaria", 25, "CHF", 700));
        return countries;
    }
}
