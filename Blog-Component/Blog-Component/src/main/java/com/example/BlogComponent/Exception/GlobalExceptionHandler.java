package com.example.BlogComponent.Exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String ,Object> body=new HashMap<>();
        List<String> errors=ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(t->t.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors",errors);
        return new ResponseEntity<>(body,headers,status);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ErrorDetail> resourceNotFound(BlogNotFoundException ex, WebRequest request)
    {
        ErrorDetail error=new ErrorDetail(ex.getMessage(),"406",new Date());
        return new ResponseEntity<ErrorDetail>(error,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ErrorDetail error=new ErrorDetail(ex.getMessage(),"500",new Date());
        return new ResponseEntity<Object>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(BlogInsertionException.class)
    public ResponseEntity<Object> blogInsertionException(BlogInsertionException ex) {
        ErrorDetail error=new ErrorDetail(ex.getMessage(),"500",new Date());
        return new ResponseEntity<Object>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BlogDeletionException.class)
    public ResponseEntity<Object> blogExceptionDeletion(BlogDeletionException ex) {
        ErrorDetail error = new ErrorDetail(ex.getMessage(), "406", new Date());
        return new ResponseEntity<Object>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<Object> blogAlreadyExistsException(BlogAlreadyExistsException ex) {
        ErrorDetail error = new ErrorDetail(ex.getMessage(), "406", new Date());
        return new ResponseEntity<Object>(error, HttpStatus.NOT_ACCEPTABLE);
    }
}




//    @ResponseStatus(BAD_REQUEST)
//    @ResponseBody
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Stream<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
//       Stream<Object> result = ex.getBindingResult().getAllErrors().stream().collect(Collectors.toList())
//               .stream().map(t->t.getDefaultMessage().toString());
//
//        return result;
//    }

