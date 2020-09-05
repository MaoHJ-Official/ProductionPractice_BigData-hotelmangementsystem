package com.neusoft.hotelmanagementsystem.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class CustomDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sfm.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
