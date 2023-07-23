package com.bridgelabz.SpringBootTask.exception;

import com.bridgelabz.SpringBootTask.dto.ResponceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerEx {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponceDTO> handelMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errorMsg=errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponceDTO responceDTO =new ResponceDTO("Exception  While performing rest api",errorMsg);
        return new ResponseEntity<>(responceDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CostomException.class)
    public ResponseEntity<ResponceDTO> handleCustomException(CostomException exception){
        ResponceDTO responceDTO=new ResponceDTO("Exception during performing Rest API",exception);
        return new ResponseEntity<>(responceDTO,HttpStatus.BAD_REQUEST);
    }

}
