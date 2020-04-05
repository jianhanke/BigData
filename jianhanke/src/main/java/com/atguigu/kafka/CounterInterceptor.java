package com.atguigu.kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CounterInterceptor implements ProducerInterceptor<String,String> {

    private long successNum=0L;
    private long errorNum=0L;
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        System.out.println("这是count————————");
        return record;
    }

    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if(exception==null){
            successNum++;
        }else{
            errorNum++;
        }
    }

    public void close() {
        System.out.println("successNum=" + successNum);
        System.out.println("errorNum=" + errorNum);
    }

    public void configure(Map<String, ?> configs) {

    }
}
