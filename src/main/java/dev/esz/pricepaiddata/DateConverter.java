package dev.esz.pricepaiddata;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter extends AbstractBeanField<LocalDate, String> {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
