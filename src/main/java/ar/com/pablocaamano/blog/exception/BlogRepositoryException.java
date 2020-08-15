package ar.com.pablocaamano.blog.exception;

import ar.com.pablocaamano.commons.exception.CommonException;

/**
 * This exception threw when repository access/connection fails
 * @author Pablo Caamaño
 * @site http://pablocaamano.com.ar
 */
public class BlogRepositoryException extends CommonException {

    private static final String DEFAULT_MESSAGE = "Repository access fail";

    public BlogRepositoryException(){
        super(DEFAULT_MESSAGE);
    }

    public BlogRepositoryException(String message){
        super(message);
    }

    public BlogRepositoryException(Throwable cause){
        super(DEFAULT_MESSAGE, cause);
    }

    public BlogRepositoryException(String message, Throwable cause){
        super(message, cause);
    }
}
