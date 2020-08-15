package ar.com.pablocaamano.blog.service;

import ar.com.pablocaamano.blog.exception.BlogRepositoryException;
import ar.com.pablocaamano.blog.model.Author;
import ar.com.pablocaamano.blog.repository.AuthorRepository;
import ar.com.pablocaamano.blog.utils.ApiUtils;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private AuthorRepository repository;

    public List<Author> getAllAuthors(String requestId){
        try{
            logger.info(ApiUtils.loggerMessage(requestId,"getAuthorById","list all authors..."));
            return repository.findAll();
        }catch (Exception exception){
            logger.info(ApiUtils.loggerMessage(requestId,"getAuthorById","error listing authors"));
            logger.error(ApiUtils.loggerMessage(requestId,"getAuthorById","error listing authors"), exception);
            throw new BlogRepositoryException("Error listing authors", exception);
        }
    }

    public Author getAuthorById(String id,String requestId){
        try {
            logger.info(ApiUtils.loggerMessage(requestId, "getAuthorById", "send query to repository"));
            Optional<Author> result = repository.findById(Integer.valueOf(id));
            if (!result.isPresent()) {
                logger.info(ApiUtils.loggerMessage(requestId, "getAuthorById", "no authors were found with id: " + id));
                return null;
            }
            Author a = result.get();
            logger.info(ApiUtils.loggerMessage(requestId, "getAuthorById", "author found: " + a.toString()));
            return a;
        }catch(Exception exception){
            logger.info(ApiUtils.loggerMessage(requestId, "getAuthorById", "error finding author"));
            logger.error(ApiUtils.loggerMessage(requestId, "getAuthorById", "error finding author"),exception);
            throw new BlogRepositoryException("Error finding author", exception);
        }
    }
}
