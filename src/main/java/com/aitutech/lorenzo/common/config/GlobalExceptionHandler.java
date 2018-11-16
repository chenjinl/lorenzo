package com.aitutech.lorenzo.common.config;

import com.aitutech.lorenzo.common.utils.LogicException;
import com.aitutech.lorenzo.common.utils.ResultApi;
import com.aitutech.lorenzo.common.utils.ResultCode;
import com.aitutech.lorenzo.common.vo.FieldErrorVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindException;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一处理controller  异常
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultApi handleException(BindException e){
        log.error(e.getMessage(), e);
        //Hibernate Validator验证消息返回
        List<FieldError> fieldErrorList =  e.getFieldErrors();
        return ResultApi.fail(ResultCode.PARAMETER_ERROR, this.getListFieldError(fieldErrorList));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultApi methodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(e.getMessage(), e);
        //Hibernate Validator验证消息返回
        BindingResult bindingResult =  e.getBindingResult();
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        return ResultApi.fail(ResultCode.PARAMETER_ERROR, this.getListFieldError(fieldErrorList));
    }

    private List<FieldErrorVO> getListFieldError(List<FieldError> fieldErrorList) {
        List<FieldErrorVO> fieldErrorVOList = new ArrayList<>();
        for(FieldError fieldError : fieldErrorList) {
            FieldErrorVO fieldErrorVO = new FieldErrorVO(fieldError.getField(), fieldError.getDefaultMessage());
            fieldErrorVOList.add(fieldErrorVO);
        }
        return fieldErrorVOList;
    }
}
