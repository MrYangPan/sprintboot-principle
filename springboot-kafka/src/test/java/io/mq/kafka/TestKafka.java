package io.mq.kafka;

import io.mq.kafka.common.MessageEntity;
import io.mq.kafka.consumer.SimpleConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Mr.PanYang on 2018/10/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApp.class)
public class TestKafka {

    @Autowired
    private SimpleConsumer simpleConsumer;

    @Test
    public void testConsumer() {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setBody("欢迎你");
        messageEntity.setTitle("中国");
//        simpleConsumer.receive();
    }


}
