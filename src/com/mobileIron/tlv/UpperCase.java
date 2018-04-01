package com.mobileIron.tlv;

/**
 * Created by gaakarsh on 02/04/18.
 */
public class UpperCase implements TypeValidators {
    @Override
    public String isValid(String str) {
        return str.toUpperCase();
    }
}
