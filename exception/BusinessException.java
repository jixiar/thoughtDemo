package com.dcml.cms.common.exception;

public class BusinessException extends RuntimeException{

    private String errorCode;
//
//    private String errorMsg;

    public static final String PARAM_MISS = "504";
    public static final String PARAM_ERROR = "505";

    public static final String SELF_LOGIC_WRONG = "508";

    public static final String BUSINESS_ERROR = "500";




    public BusinessException(String errorCode, String errorMsg ){
        super(errorMsg);
        this.errorCode = errorCode;
    }



}
