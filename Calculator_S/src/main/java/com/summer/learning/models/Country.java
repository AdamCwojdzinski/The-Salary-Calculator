package com.summer.learning.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="countries")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty (message = "Proszę podać nazwę kraju")
    private String name;
    
    @NotNull (message = "Proszę podać wartość podatku")
    @Min(1)
    @Max(99)
    private Integer tax;
    
    @NotEmpty (message = "Proszę podać kod waluty")
    private String rateCode;
    
    @NotNull (message = "Proszę podać koszty stałe")
    private Integer fixedCost;
    
    public Country(){ }
    
    public Country(Long id, String name, Integer tax, String rateCode, Integer fixedCost)
    {
        this.id = id;
        this.name = name;
        this.tax = tax;
        this.rateCode = rateCode;
        this.fixedCost = fixedCost;
    }
    
    public Long getId(){ return id; }
    
    public void setId(Long id){ this.id = id; }
    
    public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }
    
    public Integer getTax() { return tax; }
    
    public void setTax(Integer tax) { this.tax = tax; }
    
    public String getRateCode() { return rateCode; }
    
    public void setRateCode(String rateCode) { this.rateCode = rateCode; }
    
    public Integer getFixedCost() { return fixedCost; }
    
    public void setFixedCost(Integer fixedCost) { this.fixedCost = fixedCost; }
}
