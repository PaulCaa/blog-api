package ar.com.pablocaamano.blogapi.utils;

import ar.com.pablocaamano.commons.rest.Error;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Global tools
 * @author Pablo Caamaño
 */
public class ApiUtils {

    /**
     * Concat logger message with sonar rules
     * @param requestId
     * @param message
     * @return String result example: [requestId] -> message
     */
    public static String loggerMessage(String requestId, String message){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("[").append(requestId).append("] -> ").append(message).toString();
    }

    /**
     * Concat logger message with sonar rules
     * @param requestId request identifier
     * @param method class method executed
     * @param message information fo event
     * @return String result example: [requestId].[method] -> message
     */
    public static String loggerMessage(String requestId, String method, String message){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("[").append(requestId).append("].[").append(method)
                .append("] ->").append(message).toString();
    }

    /**
     * Generate String date with custom format
     * @return "yyyy-MM-dd HH:mm:ss"
     */
    public static String generateTimeStamp(){
        SimpleDateFormat x = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date(System.currentTimeMillis());
        return x.format(now);
    }
}
