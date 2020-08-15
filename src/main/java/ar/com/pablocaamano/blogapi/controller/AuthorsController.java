package ar.com.pablocaamano.blogapi.controller;

import ar.com.pablocaamano.blogapi.model.Author;
import ar.com.pablocaamano.blogapi.service.AuthorService;
import ar.com.pablocaamano.blogapi.utils.ApiUtils;
import ar.com.pablocaamano.commons.builder.ResponseBuilder;
import ar.com.pablocaamano.commons.exception.http.CommonHttpException;
import ar.com.pablocaamano.commons.rest.Error;
import ar.com.pablocaamano.commons.rest.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/blog/author")
public class AuthorsController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorsController.class);

    private String method = "";

    @Autowired
    private AuthorService service;

    @GetMapping(value = "/all")
    public ResponseEntity<RestResponse> getAllAuthors(
            HttpServletRequest httpRequest,
            @RequestHeader(value = "request_id") String requestId
    ){
        this.method = "getAllAuthors";
        try{
            logger.info(ApiUtils.loggerMessage(requestId, method,"initializing list of authors"));
            List<Author> authors = service.getAllAuthors(requestId);
            logger.info(ApiUtils.loggerMessage(requestId,method, authors.toString()));
            return new ResponseEntity<>(ResponseBuilder.init()
                    .addRequestCode("200").addRequestUri(httpRequest.getRequestURI())
                    .addRequestMethod(httpRequest.getMethod())
                    .addData(authors).build(), HttpStatus.OK);
        }catch (Exception exception){
            logger.error(ApiUtils.loggerMessage(requestId,method, "error process"), exception);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            if(exception instanceof CommonHttpException)
                status = ((CommonHttpException) exception).getStatus();
            return new ResponseEntity<>(ResponseBuilder.init()
                    .addTimestamp(ApiUtils.generateTimeStamp())
                    .addRequestUri(httpRequest.getRequestURI())
                    .addRequestMethod(httpRequest.getMethod())
                    .addRequestCode(String.valueOf(status.value()))
                    .addError(new Error("error list authors process", exception.getMessage(), exception))
                    .addData(Collections.emptyList()).build(),
                    status);
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<RestResponse> getAuthorBy(
            @RequestParam(value = "id") String id,
            HttpServletRequest httpRequest,
            @RequestHeader(value = "request_id") String requestId
    ){
        this.method = "getAuthorBy";
        try {
            logger.info(ApiUtils.loggerMessage(requestId, method, "finding author with id: " + id));
            Author a = service.getAuthorById(id, requestId);
            if(a == null){
                logger.info(ApiUtils.loggerMessage(requestId, method, "service response not found author"));
                return new ResponseEntity<>(ResponseBuilder.init()
                        .addTimestamp(ApiUtils.generateTimeStamp())
                        .addRequestCode("200").addRequestMethod(httpRequest.getMethod())
                        .addRequestUri(httpRequest.getRequestURI())
                        .addError(new Error("Not found author with id: " + id))
                        .addData(Collections.EMPTY_LIST).build(),
                        HttpStatus.OK);
            }
            logger.info(ApiUtils.loggerMessage(requestId, method, "generating rest response"));
            return new ResponseEntity<>(ResponseBuilder.init()
                    .addTimestamp(ApiUtils.generateTimeStamp())
                    .addRequestUri(httpRequest.getRequestURI())
                    .addRequestCode("200").addRequestMethod(httpRequest.getMethod())
                    .addData(a).build(),
                    HttpStatus.OK);
        }catch(Exception exception){
            logger.error(ApiUtils.loggerMessage(requestId, method, "error process"), exception);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            if(exception instanceof CommonHttpException) {
                status = ((CommonHttpException) exception).getStatus();
            }
            return new ResponseEntity<>(ResponseBuilder.init()
                    .addTimestamp(ApiUtils.generateTimeStamp())
                    .addRequestUri(httpRequest.getRequestURI())
                    .addRequestMethod(httpRequest.getMethod())
                    .addRequestCode(String.valueOf(status.value()))
                    .addError(new Error("error find author process", exception.getMessage(), exception))
                    .addData(Collections.emptyList()).build(),
                    status);
        }
    }
}
