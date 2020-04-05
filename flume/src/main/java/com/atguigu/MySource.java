package com.atguigu;


import org.apache.flume.Context;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.SimpleEvent;
import org.apache.flume.source.AbstractSource;

import java.util.HashMap;

public class MySource extends AbstractSource implements Configurable, PollableSource {

    private Long delay;
    private String field;

    public void configure(Context context) {
        delay=context.getLong("delay");
        field=context.getString("field","Hello");
    }

    public Status process() throws EventDeliveryException {
        try {
            HashMap<String, String> headerMap = new HashMap<String, String>();
            SimpleEvent event = new SimpleEvent();
            for (int i = 0; i < 5; i++) {
                event.setHeaders(headerMap);
                event.setBody((field + i).getBytes());
                getChannelProcessor().processEvent(event);
                Thread.sleep(delay);
            }
        }catch(Exception e){
            e.printStackTrace();
            return Status.BACKOFF;
        }
        return Status.READY;
    }

    public long getBackOffSleepIncrement() {
        return 0;
    }

    public long getMaxBackOffSleepInterval() {
        return 0;
    }
}
