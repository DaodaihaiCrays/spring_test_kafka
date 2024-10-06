package Demo.Kafka.demoKafka.Controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

     @KafkaListener(topics = "TOPIC", groupId = "group_id")
     public void consume(String message) {
         System.out.println("Consumed message: " + message);
     }

//     @KafkaListener(topics = "example_topic", groupId = "group_id")
//     public void consume(String message,
//                         @Header(KafkaHeaders.RECEIVED_KEY) String key,
//                         @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {  // Using correct header constants
//         System.out.println("Consumed message: " + message + " with key: " + key + " from partition: " + partition);
//     }

//    @KafkaListener(topics = "example_topic", groupId = "group_id")
//    public void consume(String message,
//                        @Header(KafkaHeaders.RECEIVED_KEY) String key,
//                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
//        System.out.println("Consumed message: " + message + " with key: " + key + " from partition: " + partition);
//    }
}