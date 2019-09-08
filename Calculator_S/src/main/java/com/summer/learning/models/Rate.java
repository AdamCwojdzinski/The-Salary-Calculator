package com.summer.learning.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
                       "no",
                       "effectiveDate",
                       "mid"
                   })
public class Rate {
    
    @JsonProperty("no")
    private String no;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("mid")
    private Double mid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Rate() { }
    
    public Rate(String no, String effectiveDate, Double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }
    
    @JsonProperty("no")
    public String getNo() {
        return no;
    }
    
    @JsonProperty("no")
    public void setNo(String no) {
        this.no = no;
    }
    
    @JsonProperty("effectiveDate")
    public String getEffectiveDate() {
        return effectiveDate;
    }
    
    @JsonProperty("effectiveDate")
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    
    @JsonProperty("mid")
    public Double getMid() {
        return mid;
    }
    
    @JsonProperty("mid")
    public void setMid(Double mid) {
        this.mid = mid;
    }
    
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    @Override
    public String toString()
    {
        return "Rate{" +
               "no='" + no + '\'' +
               ", effectiveDate='" + effectiveDate + '\'' +
               ", mid=" + mid +
               '}';
    }
}
