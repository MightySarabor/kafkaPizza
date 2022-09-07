package myapps.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import myapps.Util.Json.Json;
import myapps.pojos.OrderPOJO;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static myapps.Util.POJOGenerator.generateOrder;

public class Producer {
    public static void main(String[] args) throws JsonProcessingException, ExecutionException, InterruptedException {
        //properties
        String bootstrapServers = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String,String> first_producer = new KafkaProducer<String, String>(properties);



        for(int i = 0; i <= 1000; i++) {
            String topic = "streams-plaintext-input";
            String value = Json.prettyPrint(Json.toJson(generateOrder()));
            System.out.println(value);
            ProducerRecord<String, String> record =
                    new ProducerRecord<String, String>(topic, Json.stringify(Json.toJson(generateOrder())));
            //Sending data
            first_producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {

                    if (e == null) {
                        System.out.println("Successfully recieved the details as: \n" +
                                "Topic: " + recordMetadata.topic() + "\n" +
                                "Partition: " + recordMetadata.partition() + "\n" +
                                "Offset: " + recordMetadata.offset() + "\n" +
                                "TimeStamp:" + recordMetadata.timestamp());
                    } else {
                        System.err.println("Can't produce, getting Error: " + e);
                    }
                }
            }).get();
        }
        first_producer.flush();
        first_producer.close();
    }
}
