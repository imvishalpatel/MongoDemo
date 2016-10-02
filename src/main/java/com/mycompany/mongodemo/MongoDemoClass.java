/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongodemo;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.Date;

/**
 *
 * @author vishal
 */
public class MongoDemoClass {

    public static void main(String[] args) {
        MongoClient mongo = new MongoClient("localhost", 27017);
        /*
            first create database and collection(table) in mongodb
            code
                use demodb // to create db
                db.createCollection("users") // create table users in db
         */
        DB db = mongo.getDB("demodb");

        DBCollection col = db.getCollection("users");
        
        // creating list of POST
        BasicDBList postList = new BasicDBList();
        postList.add("a1"); // add post reference in list
        postList.add("a2");
        postList.add("a3");
        // create nested element : posts
        BasicDBObject posts = new BasicDBObject("publicPost", postList)
                .append("privatePost", postList)
                .append("exclusivePost", postList);

        // create insert document 
        BasicDBObject doc = new BasicDBObject("firstName", "vishal")
                .append("lastName", "patel")
                .append("email", "vishal.6794@gmail.com")
                .append("userName", "im_vishal")
                .append("password", "admin")
                .append("userType", 1)
                .append("lastAccessTime", new Date())
                .append("posts", posts)
                .append("rating", 10)
                .append("verified", true);
        
        
        // insert into collection using insert method
        col.insert(doc);

        
        /*
            display first document from collection
            in this case our collection is users
        */

        DBObject mydoc = col.findOne();
        System.out.println(mydoc);
    }
}
