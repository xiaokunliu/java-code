package com.dtrees.study.springboot_j2ee.spring.web.conveter;

import com.dtrees.study.springboot_j2ee.spring.web.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by keithl on 2017/11/30.
 */
public class WebMessageConverter extends AbstractHttpMessageConverter<Person>{

    // 新建自定义的媒体类型
    public WebMessageConverter() {
        super(new MediaType("application","x-wisely", Charset.forName("UTF-8")));
    }

    // 表示当前的HttpMessageConverter仅处理这个Person类
    @Override
    protected boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    /**
     * 重写方法来处理请求的数据,将数据的"-"分割并重新组装成Person对象
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("UTF-8"));
        String[] arr = temp.split("-");
        if (arr != null && arr.length >=2){
            Person person = new Person();
            person.setId(new Long((arr[0])));
            person.setName(arr[1]);
            return person;
        }
       return null;
    }

    // 处理如何输出到response中
    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        String out = String.format("this is the http message from id[%s] and name[%s]",person.getId(),person.getName());
        outputMessage.getBody().write(out.getBytes());
    }

    // 配置在WebConfig
}
