package com.smartfactory.apiserver.common.exception;

import com.smartfactory.apiserver.common.exception.auth.AuthException;
import com.smartfactory.apiserver.common.exception.auth.ServiceException;
import com.smartfactory.apiserver.common.response.ApiBaseResponse;
import com.smartfactory.apiserver.common.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice(annotations= RestController.class)
@Slf4j
public class RestExceptionHandler {
//    @ExceptionHandler(value = BusinessException.class)
//    public ResponseEntity<?> handleBusinessException(HttpServletRequest request, BusinessException e){
//        RestApiResponse responseDTO = new RestApiResponse();
//        responseDTO.setResult(new BaseResponse(e.getResponseCode(), e.getDetail()));
//        return new ResponseEntity<RestApiResponse>(responseDTO, e.getStatus());
//    }
//
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<?> handleClientIdAuthExceptionException(HttpServletRequest request, AuthException e) {
        ApiBaseResponse response = ApiBaseResponse.builder()
                .responseCode(e.getResponseCode())
                .detail(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();
        log.error(errorMessage);
        ApiBaseResponse response = ApiBaseResponse.builder()
                .responseCode(ResponseCode.INVALID_PARAMETER_ERROR)
                .detail(errorMessage)
                .build();
        return new ResponseEntity<ApiBaseResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        String errorMessage = e.getMessage();
        log.error(errorMessage);
        ApiBaseResponse response = ApiBaseResponse.builder()
                .responseCode(ResponseCode.INVALID_PARAMETER_ERROR)
                .detail(errorMessage)
                .build();
        return new ResponseEntity<ApiBaseResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> handleServiceException(ServiceException e) {
        ApiBaseResponse response = ApiBaseResponse.builder()
                .responseCode(e.getResponseCode())
                .detail(e.getMessage())
                .build();
        return new ResponseEntity<ApiBaseResponse>(response, HttpStatus.BAD_REQUEST);
    }



    /*
    public ResponseEntity<?> handleBusinessException(HttpServletRequest request, BusinessException e){
//        RestApiResponse responseDTO = new RestApiResponse();
//        responseDTO.setResult(new BaseResponse(e.getResponseCode(), e.getDetail()));
//        return new ResponseEntity<RestApiResponse>(responseDTO, e.getStatus());
//    }
     */
}
