package io.mq.kafka.consumer;

import com.google.gson.Gson;
import io.mq.kafka.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.PanYang on 2018/10/17.
 */
@Slf4j
@Component
public class SimpleConsumer {

    private final Gson gson = new Gson();

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(ConsumerRecord<String, MessageEntity> record) {
        MessageEntity messageEntity = record.value();
        log.info(gson.toJson("消费者接受到消息：" + gson.toJson(messageEntity)));
    }
}
