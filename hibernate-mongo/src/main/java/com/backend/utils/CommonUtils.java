package com.backend.utils;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

/**
 * @author Armen Arzumanyan
 */
public class CommonUtils {

    private static DecimalFormatSymbols fs = new DecimalFormatSymbols();


    public static Double doubleValue(String strValue) {
        Double reValue = null;

        if (strValue == null || strValue.trim().equals("")) {
            return null;
        }
        fs.setGroupingSeparator(',');
        fs.setDecimalSeparator('.');
        try {
            DecimalFormat nf = new DecimalFormat("#,###,###,##0.00", fs);
            nf.setMaximumFractionDigits(3);
            nf.setMaximumIntegerDigits(3);
            reValue = nf.parse(strValue).doubleValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reValue;
    }

    public static Long longValue(String strValue) {
        Long reValue = null;
        if (strValue == null || strValue.trim().equals("")) {
            return null;
        }
        NumberFormat nf = NumberFormat.getInstance();
        try {
            reValue = nf.parse(strValue).longValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reValue;
    }

    public static Integer integerValue(String strValue) {
        Integer reValue = null;
        if (strValue == null || strValue.trim().equals("")) {
            return null;
        }
        NumberFormat nf = NumberFormat.getInstance();
        try {
            reValue = nf.parse(strValue).intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reValue;
    }

   
}
