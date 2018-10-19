package io.mq.kafka.producer;

import com.google.gson.Gson;
import io.mq.kafka.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.PanYang on 2018/10/17.
 */
@Slf4j
@Component
public class SimpleProducer {
    private final Gson gson = new Gson();

    @Autowired
    private KafkaTemplate<String, MessageEntity> kafkaTemplate;

    public void send(String topic, MessageEntity message) {
        kafkaTemplate.send(topic, message);
    }

    public void send(String topic, String key, MessageEntity entity) {
        //开始时间
        long startTime = System.currentTimeMillis();
        //发送消息
        kafkaTemplate.send(new ProducerRecord<>(topic, key, entity));
        //消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, MessageEntity>() {
            @Override
            public void onSuccess(ProducerRecord<String, MessageEntity> producerRecord, RecordMetadata recordMetadata) {
                if (producerRecord == null) {
                    return;
                }
                //发送消息使用时间
                long elapsedTime = System.currentTimeMillis() - startTime;
                if (recordMetadata != null) {
                    StringBuilder record = new StringBuilder();
                    record.append("message(")
                            .append("key = ").append(key).append(",")
                            .append("message = ").append(gson.toJson(entity)).append(")")
                            .append("sent to partition(").append(recordMetadata.partition()).append(")")
                            .append("with offset(").append(recordMetadata.offset()).append(")")
                            .append("in ").append(elapsedTime).append(" ms");
                    log.info(record.toString());
                }
            }

            @Override
            public void onError(ProducerRecord<String, MessageEntity> producerRecord, Exception exception) {
                exception.printStackTrace();
            }
        });
    }

}
