package com.xiaokunliu.lucene;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:java-code
 * file:LuceneApiTest
 * package:com.xiaokunliu.lucene
 * date:2019/4/14 5:07 PM
 * author:keithl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LuceneApiTest {

    @Autowired
    private LuceneApi luceneApi;

    @Test
    public void testCreateIndex() throws Exception{
        luceneApi.createIndex();
    }

    @Test
    public void testSearch() throws Exception {
        luceneApi.searchIndex();
    }
}
