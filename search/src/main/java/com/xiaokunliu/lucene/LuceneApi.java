package com.xiaokunliu.lucene;

import com.xiaokunliu.bean.ShopAreas;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * project:java-code
 * file:LuceneApi
 * package:com.xiaokunliu.lucene
 * date:2019/4/14 4:36 PM
 * author:keithl
 */
@Service
public class LuceneApi {

    // 操作lucene api

    /**
     * 创建索引库
     * @throws Exception
     */
    public void createIndex() throws Exception {

        //创建索引库
        Path indexPath = new File(".", "temp_dir").toPath();
        System.out.println(indexPath.toUri().getPath());
        Directory directory = FSDirectory.open(indexPath);

        // 创建分词器
        Analyzer analyzer = new StandardAnalyzer();

        // 创建IndexWriter配置对象
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        config.setCommitOnClose(true);

        // 创建IndexWriter
        IndexWriter indexWriter = new IndexWriter(directory, config);

        // 创建存储的内容
        ShopAreas areas = new ShopAreas();
        areas.setId(1L);
        areas.setCity("city");
        areas.setCountryCode("china");
        areas.setProvince("guangdong");
        areas.setStreet("xinxizhijie");
        areas.setTown("huangpu");

        // 创建存储索引的文档对象
        // 将对象转换为document对象
        Document document = new Document();
        document.add(new Field("id", Long.toString(areas.getId()), TextField.TYPE_STORED));
        document.add(new Field("city", areas.getCity(), TextField.TYPE_STORED));
        document.add(new Field("countryCode", areas.getCountryCode(), TextField.TYPE_STORED));
        document.add(new Field("province", areas.getProvince(), TextField.TYPE_STORED));
        document.add(new Field("street", areas.getStreet(), TextField.TYPE_STORED));
        document.add(new Field("town", areas.getTown(), TextField.TYPE_STORED));

        indexWriter.addDocument(document);

        indexWriter.commit();
        indexWriter.close();

        // 删除索引库
//        IOUtils.rm(indexPath);
    }

    /**
     * 从索引库中进行搜索
     */
    public void searchIndex() throws Exception{
        // 搜索

        // 获取目录库
        Path indexPath = new File(".", "temp_dir").toPath();
        System.out.println(indexPath.toUri().getPath());
        Directory directory = FSDirectory.open(indexPath);

        // 使用读取器包装目录对象
        DirectoryReader ireader = DirectoryReader.open(directory);
        // 创建IndexSearcher
        IndexSearcher indexSearcher = new IndexSearcher(ireader);

        // 创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        // 创建QueryParse对象
        /**
         * 参数：
         *  String field -- 查询哪个字段
         *  Analyzer a   -- 使用的分词器
         */
        QueryParser parser = new QueryParser("street", analyzer);
        Query query = parser.parse("stre");

        /**
         * 进行搜索
         *      query ： 表示查询条件
         *      N： 表示查询前N条记录
         */
        // 返回目录结果
        TopDocs topDocs = indexSearcher.search(query, 100);

        // 获取目录结果条数
        TotalHits hits = topDocs.totalHits;
        System.out.println(hits.value);
        System.out.println(hits.relation);

        // 获取倒排索引的内容列表
        ScoreDoc[] hitsDoc = topDocs.scoreDocs;

        // 将结果内容转换为对象数据
        List<ShopAreas> areasList = new ArrayList<>();
        for (int i = 0; i < hitsDoc.length; i++) {
            Document hitDoc = indexSearcher.doc(hitsDoc[i].doc);
            ShopAreas areas = new ShopAreas();
            areas.setId(NumberUtils.toLong(hitDoc.get("id")));
            areas.setTown(hitDoc.get("town"));
            areas.setStreet(hitDoc.get("street"));
            areas.setProvince(hitDoc.get("province"));
            areas.setCountryCode(hitDoc.get("countryCode"));
            areas.setCity(hitDoc.get("city"));
            areasList.add(areas);
        }

        System.out.println(areasList);
        // 关闭索引查询
        ireader.close();
        directory.close();
    }

    // TODO
    // 删除索引库


    // 更新索引库
}
