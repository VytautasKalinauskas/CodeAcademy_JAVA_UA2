package eu.codeacademy.javaua2;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import eu.codeacademy.javaua2.model.Order;
import eu.codeacademy.javaua2.model.OrderType;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main {
    public static void main(String[] args) {



        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("CA_DB").withCodecRegistry(pojoCodecRegistry);
        mongoClient.listDatabaseNames().forEach(System.out::println);



        MongoCollection orders = db.getCollection("orders", Order.class);
//        Order order = new Order();
//        order.setOrderNr("554");
//        order.setType(OrderType.Purchase);
//        Document doc = new Document();
//        doc.put("ORDER", "ORD");

//        Document asmuo = new Document("vardas", "Vardas")
//                .append("pavarde", "Pavarde");
//        orders.insertOne(asmuo);
//
//        Document orderDoc = new Document("ORDER", order.getOrderNr())
//                .append("TYPE", order.getType().name());
//        orders.insertOne(orderDoc);
        orders.drop();
        Order ord = new Order();
        ord.setOrderNr("1556");
        orders.insertOne(ord);
        orders.insertOne(ord);

        List<Order> flowers = new ArrayList<>();
        Bson filter = Filters.gt("order_nr", "1555");

        orders.deleteOne(filter);

//        orders.deleteOne(filter);

        orders.find(filter).into(flowers);

        System.out.println(flowers.size());


        System.out.println("Hello world!");
    }
}