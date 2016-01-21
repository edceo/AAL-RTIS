package com.edsoft.iot;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by edsoft on 07.01.2016.
 */
public class DataProducer {
    private static Producer<String, Data> producer;
    private static final Properties properties;

    static {
        properties = new Properties();
        properties.put("metadata.broker.list", "localhost:9092");
        properties.put("request.required.acks", "1");
        properties.put("serializer.class", "com.edsoft.kafka.DataEncoder");
        producer = new Producer<>(new ProducerConfig(properties));
    }

    public static void sendKafkaFromSensors(Data data) {
        KeyedMessage<String, Data> iotData = new KeyedMessage<>("aalDemo", data);
        producer.send(iotData);
    }
}
