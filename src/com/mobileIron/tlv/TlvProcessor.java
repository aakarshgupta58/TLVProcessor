package com.mobileIron.tlv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaakarsh on 02/04/18.
 */
public class TlvProcessor {
    public static void splitfunction(String str){
        String[] afterSplit;
        if(str != null) {
            afterSplit = str.split("-");
            String type = afterSplit[0];
            String length = afterSplit[1];
            if (!(afterSplit[2].contains("REPLCE") || afterSplit[2].contains("UPPRCS"))) {
                String value = afterSplit[2];
                Parser tlv = new Parser(type, length, value);
                if (tlv.getType().equalsIgnoreCase("UPPRCS")) {
                    UpperCase u = new UpperCase();
                    System.out.println(tlv.getType() + " " + u.isValid(tlv.getValue()));
                } else if (tlv.getType().equalsIgnoreCase("REPLCE")) {
                    Replace r = new Replace();
                    System.out.println(tlv.getType() + " " + r.isValid(tlv.getValue()));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        try {
            if (args.length > 0) {
                BufferedReader br = new BufferedReader(new FileReader(args[0]));
                String line;
                String REGEX = "UPPRCS|REPLCE";
                Pattern p = Pattern.compile(REGEX);
                int beg = 0;

                while ((line = br.readLine()) != null) {
                    if (!(line.contains("UPPRCS") || line.contains("REPLCE"))) {
                        System.out.println("Type Not Valid");
                    }
                    Matcher m = p.matcher(line);
                    beg = 0;
                    while (m.find()) {
                        if (m.start() > 0) {
                            int end = m.start();
                            String s = line.substring(beg, end);
                            splitfunction(s);
                            String str = new String();
                            str = line.replace(line.charAt(end) + "", "\n" + line.charAt(end));
                            splitfunction(str);
                            beg = end;
                        }

                    }
                    String normalString = line.substring(beg, line.length());
                    splitfunction(normalString);
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
