package com.xunruan.framekork.util;



import java.util.Date;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/**
 * 
 * @author wenz
 *
 */
public final class DateConverter implements Converter {
    private Object defaultValue = null;
    private boolean useDefault = true;
	
    public DateConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }
    public DateConverter(Object defaultValue) {
        this.defaultValue = defaultValue;
        this.useDefault = true;
    }

    @SuppressWarnings("unchecked")
	public Object convert(Class type, Object value) {
        if (value == null) {
            if (useDefault) {
                return (defaultValue);
            } else {
                throw new ConversionException("No value specified");
            }
        }
        if (value instanceof Date) {
            return (value);
        }
        try {
            return (this.valueOf(value.toString()));
        } catch (Exception e) {
            if (useDefault) {
                return (defaultValue);
            } else {
                throw new ConversionException(e);
            }
        }
    }
    
    @SuppressWarnings("deprecation")
	private Date valueOf(String s) {
    	int year;
    	int month;
    	int day;
    	int firstDash;
    	int secondDash;

    	if (s == null) throw new java.lang.IllegalArgumentException();

    	firstDash = s.indexOf('-');
    	secondDash = s.indexOf('-', firstDash+1);
    	if ((firstDash > 0) & (secondDash > 0) & (secondDash < s.length()-1)) {
    	    year = Integer.parseInt(s.substring(0, firstDash)) - 1900;
    	    month = Integer.parseInt(s.substring(firstDash+1, secondDash)) - 1;
    	    day = Integer.parseInt(s.substring(secondDash+1));	 
    	} else {
    	    throw new java.lang.IllegalArgumentException();
    	}
    			
    	return new Date(year, month, day);
    }
}

