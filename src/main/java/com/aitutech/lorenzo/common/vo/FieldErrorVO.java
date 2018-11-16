package com.aitutech.lorenzo.common.vo;

import lombok.Data;

@Data
public class FieldErrorVO {

    private String field;

    private String message;

    public FieldErrorVO(String field, String message) {
        this.field = field;
        this.message = message;
    }
 }
