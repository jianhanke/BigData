package com.atguigu;


import org.apache.flume.*;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MySink extends AbstractSink implements Configurable {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractSink.class);

    private String prefix;
    private String suffix;

    public Status process() throws EventDeliveryException {
        Status status;
        Channel ch=getChannel();
        Transaction txn=ch.getTransaction();
        Event event;
        txn.begin();
        while (true){
            event=ch.take();
            if(event!=null){
                break;
            }
        }
        try{
            LOG.info(prefix+new String(event.getBody())+suffix);
            txn.commit();
            status=Status.READY;
        }catch (Exception e){
            txn.rollback();
            status=Status.BACKOFF;
        }finally {
            txn.close();
        }
        return status;
    }

    public void configure(Context context) {
        prefix=context.getString("prefix","myPrefix");
        suffix=context.getString("suffix","mySuffix");
    }
}
