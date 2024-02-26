package com.example.demo.dto;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambiaData {
    private Float amount;
    private String base;
    private String date;
    private HashMap<String,Float> rates;
}
