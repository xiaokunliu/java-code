package com.dtrees.mongodb.dao;

import com.dtrees.mongodb.domain.YxTest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class YxTestDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public YxTest findOneById(String id){
        Query query = new Query(Criteria.where("_id").is(new ObjectId(id)));
        return mongoTemplate.findOne(query, YxTest.class);
    }
}
