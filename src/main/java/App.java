import com.mongodb.*;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        // Connection
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Get/Create database
        DB db = mongoClient.getDB("testdb");
        DBCollection table = db.getCollection("user");

        App main = new App();

        //main.insert(table);

        //main.find(table);

        //main.update(table);

        //main.delete(table);
    }

    void insert(DBCollection table){
        BasicDBObject document = new BasicDBObject();
        document.put("name", "mkyong");
        document.put("age", 30);
        document.put("createdDate", new Date());
        table.insert(document);
    }

    void find(DBCollection table){
        BasicDBObject searchQuery2 = new BasicDBObject().append("name", "mkyong");
        DBCursor cursor2 = table.find(searchQuery2);
        while (cursor2.hasNext()) {
            System.out.println(cursor2.next());
        }
        System.out.println("Done");
    }

    void update(DBCollection table){
        BasicDBObject query = new BasicDBObject();
        query.put("name", "mkyong");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "mkyong-updated");

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);
    }

    void delete(DBCollection table){
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "mkyong-updated");
        table.remove(searchQuery);
    }
}
