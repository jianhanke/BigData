package com.atguigu.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class CustomProducer {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop102:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);

        ArrayList<String> interceptors=new ArrayList<String>();
        interceptors.add("com.atguigu.kafka.TimeInterceptor");
        interceptors.add("com.atguigu.kafka.CounterInterceptor");

        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);

        KafkaProducer<String,String>  producer=new KafkaProducer<String,String>(props);

        for (int i = 0; i < 100; i++) {
            RecordMetadata meta = producer.send(new ProducerRecord<String, String>("first", i + "", "message-" + i)).get();
//            System.out.println("offset = " + meta.offset());
        }

        //3.关闭生产者
        producer.close();


    }
}


