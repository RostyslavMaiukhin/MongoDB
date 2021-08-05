package dao;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.User;
import org.bson.Document;
import utils.mongoUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class userDao {
    private final MongoDatabase database = connect("aLevel");

    public void createData(User... users) {
        MongoCollection<Document> userList = database.getCollection("users");
        userList.insertMany(Arrays.stream(users)
                .map(userDao::mapperFrom)
                .collect(Collectors.toList()));
    }

    public void readAllData() {
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find();
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    private void readOneData() {
        final Document filter = new Document();
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(filter);
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public void findUserByName(String name) {
        final Document filter = new Document();
        filter.append("firstName", name);
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(filter);
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public void findUserByCity(String ownCity) {
        final Document filter = new Document();
        filter.append("ownCity", ownCity);
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(filter);
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public void findUserByAge(int age) {
        final Document filter = new Document();
        filter.append("age", age);
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(filter);
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public void updateData(User userUpdate, User user) {
        final Document filter = new Document();
        filter.append("firstName", userUpdate.getFirstName());

        final Document newData = new Document();
        newData.append("firstName", user.getFirstName());
        newData.append("lastName", user.getLastName());
        newData.append("age", user.getAge());
        newData.append("workPlace", user.getWorkPlace());
        newData.append("ownCity", user.getOwnCity());

        final Document updateObject = new Document();
        updateObject.append("$set", newData);

        MongoCollection<Document> users = database.getCollection("users");
        users.updateOne(filter, updateObject);
    }

    public void deleteData(User user) {
        final Document filter = new Document();
        filter.append("id", user.getId());

        MongoCollection<Document> users = database.getCollection("users");
        users.deleteOne(filter);
    }

    public void deleteAllData() {
        MongoCollection<Document> users = database.getCollection("users");
        users.deleteMany(new Document());
    }

    public static MongoDatabase connect(String databaseName) {
        return mongoUtils.getMongoClient(null).getDatabase(databaseName);
    }

    private static Document mapperFrom(User user) {
        final Document document = new Document();
        document.append("id", user.getId());
        document.append("firstName", user.getFirstName());
        document.append("lastName", user.getLastName());
        document.append("age", user.getLastName());
        document.append("workPlace", user.getLastName());
        document.append("ownCity", user.getLastName());
        return document;
    }

    private static User mapperTo(Document document) {
        final User user = new User(
                document.get("firstName", String.class),
                document.get("lastName", String.class),
                document.get("age", Integer.class),
                document.get("workPlace", String.class),
                document.get("ownCity", String.class)
        );
        user.setId(document.get("_id", String.class));
        return user;
    }
}
