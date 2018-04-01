package com.mobileIron.tlv;

/**
 * Created by gaakarsh on 02/04/18.
 */
public class Parser {
    private String type;
    private String length;
    private String value;

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getLength(){
        return this.length;
    }
    public void setLength(String len){
        this.length = len;
    }

    public String getValue(){
        return this.value;
    }
    public void setValue(String value){
        this.value = value;
    }

    Parser(String type,String length,String value){
        this.type = type ;
        this.length = length;
        this.value = value;
    }
}
