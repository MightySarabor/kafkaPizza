package myapps.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import myapps.Util.Json.Json;
import myapps.pojos.OrderPOJO;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static myapps.Util.POJOGenerator.generateOrder;
import static myapps.Util.POJOGenerator.generatePizza;

public class Producer {
    public static void main(String[] args) throws JsonProcessingException, ExecutionException, InterruptedException {
        System.setProperty("java.security.auth.login.config", "/home/fleschm/kafka.jaas");

        //properties
        String bootstrapServers = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        properties.put("security.protocol", "SASL_PLAINTEXT");

        KafkaProducer<String,String> first_producer = new KafkaProducer<String, String>(properties);



        while(true) {
            String topic = "my_eighth";
            String value = Json.stringify(Json.toJson(generatePizza()));
            ProducerRecord<String, String> record =
                    new ProducerRecord<String, String>(topic, value);
            System.out.println(value);
            //Sending data
            Thread.sleep(10000);
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
    }
}
