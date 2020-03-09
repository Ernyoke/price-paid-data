package dev.esz.pricepaiddata;

public class PriceNotFoundException extends Exception {
    public PriceNotFoundException(String what) {
        super(what);
    }
}
