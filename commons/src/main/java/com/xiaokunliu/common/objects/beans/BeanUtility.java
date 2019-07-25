package com.xiaokunliu.common.objects.beans;

import com.xiaokunliu.common.objects.date.DateUtility;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.Date;
import java.util.Map;

public final class BeanUtility {

    static {
        // 时间转换为字符串的转换器
//        ConvertUtils.register(new DateTime2StringConvert(), Date.class);
    }

    //将object对象转换为map
    public static Map<String, Object> objectToMap(Object bean) throws Exception{
        // TODO 使用beanUtils就需要写转换器
        Map<String,Object> map = PropertyUtils.describe(bean);
        for (Map.Entry<String,Object> entry:map.entrySet()){
            if (entry.getValue()!=null && entry.getValue() instanceof Date){
                Date dateVal = (Date)entry.getValue();
                entry.setValue(DateUtility.formatWithDateTimeLine(dateVal));
            }
        }
        return map;
    }
}
