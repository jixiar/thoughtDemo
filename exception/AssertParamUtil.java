package com.dcml.cms.common.exception;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Ref;
import java.util.Collection;

public class AssertParamUtil {


    /**
     * @since 2018-09-05
     * @author guolf67@qq.com
     * @param param 判断参数是否为空
     * @param showMissMsg 为空返回的信息
     * @return
     * @throws Exception
     */
    public static boolean assertParamIsNotBlank(String param, String showMissMsg ) {
        if(StringUtils.isBlank(param)){
            throw new BusinessException(BusinessException.PARAM_MISS, showMissMsg);
        }
        return true;
    }

    public static boolean assertParamIsNotNull(Object param, String name ) {
        if(param ==null){
            throw new BusinessException(BusinessException.PARAM_MISS, name + "参数不能为空！");
        }
        return true;
    }

    public static boolean assertParamIsNotEmpty(Object param, String errRemind ) {
        boolean isEmtpy =false;
        if(param ==null)
            isEmtpy =true;
        else if( param instanceof Collection && ((Collection) param).isEmpty()){
                isEmtpy =true;
        }
        if(isEmtpy)
            throw new BusinessException(BusinessException.PARAM_ERROR, errRemind);
        return true;
    }

    public static boolean assertParamIsBlank(String param, String showMissMsg ) {
        if(!StringUtils.isBlank(param)){
            throw new BusinessException(BusinessException.PARAM_MISS, showMissMsg);
        }
        return true;
    }

    public static boolean assertParamGreaterThanZero(Object param, String name, Boolean allowNull)  {
        if(allowNull !=null && allowNull)
            return true;
        assertParamIsNotNull(param, name);
        if (param instanceof BigDecimal) {
            if (((BigDecimal) param).compareTo(BigDecimal.ZERO) <= 0)
                throw new BusinessException(BusinessException.PARAM_ERROR, name + "要大于0！");
        }
        else if (param instanceof Integer) {
            if (((int) param) <= 0)
                throw new BusinessException(BusinessException.PARAM_ERROR, name + "要大于0！");
        }
        else if (param instanceof Long) {
            if (((long) param) <= 0)
                throw new BusinessException(BusinessException.PARAM_ERROR, name + "要大于0！");
        }
        else if (param instanceof Float) {
            if (((float) param) <= 0)
                throw new BusinessException(BusinessException.PARAM_ERROR, name + "要大于0！");
        }
        return true;
    }

    public static boolean assertParamGreaterThanZero(Object param, String name) {
        return assertParamGreaterThanZero(param, name, false);
    }

    public static boolean assertParamIsGreater(Object param, String name, Object compareTo ) {
        assertParamIsNotNull(param, name);
        assertParamIsNotNull(compareTo, "被比较数");
        if(!param.getClass().equals(compareTo.getClass()))
            throw new BusinessException(BusinessException.PARAM_ERROR, name + "参数类型错误！");
        BusinessException excp = new BusinessException(BusinessException.PARAM_MISS, name + "要大于" + compareTo);
        if (param instanceof BigDecimal) {
            BigDecimal cmpToBigd =  (BigDecimal) compareTo;
            if (((BigDecimal) param).compareTo(cmpToBigd) <= 0)
                throw new BusinessException(BusinessException.PARAM_ERROR, name + "要大于" + cmpToBigd.toPlainString() );
        }
        else if (param instanceof Integer) {
            if (((int) param) <= (int) compareTo)
                throw excp;
        }
        else if (param instanceof Long) {
            if (((long) param) <= (long) compareTo)
                throw excp;
        }
        else if (param instanceof Float) {
            if (((float) param) <= (float) compareTo)
                throw excp;
        }
        return true;
    }

    public static boolean assertParamIsLess(Object param, String name, Object compareTo ) {
        assertParamIsNotNull(param, name);
        assertParamIsNotNull(compareTo, "被比较数");
        if(!param.getClass().equals(compareTo.getClass()))
            throw new BusinessException(BusinessException.SELF_LOGIC_WRONG, name + "参数类型错误！");
        BusinessException excp = new BusinessException(BusinessException.PARAM_MISS, name + "要小于" + compareTo);
        if (param instanceof BigDecimal) {
            BigDecimal cmpToBigd =  (BigDecimal) compareTo;
            if (((BigDecimal) param).compareTo(cmpToBigd) >= 0)
                throw new BusinessException(BusinessException.PARAM_MISS, name + "要小于" + cmpToBigd.multiply(new BigDecimal(100), new MathContext(3)).toPlainString() + "%" );
        }
        else if (param instanceof Integer) {
            if (((int) param) >= (int) compareTo)
                throw excp;
        }
        else if (param instanceof Long) {
            if (((long) param) >=(long) compareTo)
                throw excp;
        }
        else if (param instanceof Float) {
            if (((float) param) >= (float) compareTo)
                throw excp;
        }
        return true;
    }

    public static boolean assertTrue(boolean condition, String errRemind ) {
        if(!condition)
            throw new BusinessException(BusinessException.PARAM_ERROR, errRemind);
        return true;
    }

    public static boolean assertParamFormat(String param, String showMissMsg ,String regex) {
        if(!param.matches(regex)){
            throw new BusinessException(BusinessException.PARAM_MISS, showMissMsg);
        }
        return true;
    }
}
