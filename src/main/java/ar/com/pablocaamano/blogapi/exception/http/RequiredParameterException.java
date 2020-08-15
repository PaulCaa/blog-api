package ar.com.pablocaamano.blogapi.exception.http;

import ar.com.pablocaamano.commons.exception.CommonException;
import ar.com.pablocaamano.commons.exception.http.ICommonHttpException;
import org.springframework.http.HttpStatus;

/**
 * This exception is threw when required parameters are empty
 * @author Pablo Caamaño
 * @site http://pablocaamano.com.ar
 */
public class RequiredParameterException extends CommonException implements ICommonHttpException {

    private static final String DEFAULT_MESSAGE = "A required parameter is null or empty";

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    public RequiredParameterException(){
        super(DEFAULT_MESSAGE);
    }

    public RequiredParameterException(String message){
        super(message);
    }

    public RequiredParameterException(Throwable cause){
        super(cause);
    }

    public RequiredParameterException(String message, Throwable cause){
        super(message, cause);
    }
}
