package Demo.Kafka.demoKafka.Controller;

import org.apache.kafka.common.errors.UnknownTopicOrPartitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

@RestController
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "example_topic";

     @GetMapping("/publish/{message}")
     public String sendMessage(@PathVariable("message") String message) {
         kafkaTemplate.send("TOPIC", message);
         return "Message published: " + message;
     }

//     @GetMapping("/publish/{message}")
//     public String sendMessage(@PathVariable("message") String message, @RequestParam("key") String key) {  // Thêm @RequestParam cho key
//         kafkaTemplate.send(TOPIC, key, message);  // Gửi message với key
//         return "Message published: " + message + " with key: " + key;
//     }

//    @GetMapping("/publish/{message}")
//    public ResponseEntity<String> sendMessage(@PathVariable("message") String message,
//                                              @RequestParam("key") String key,
//                                              @RequestParam("partition") int partition) {
//        try {
//            kafkaTemplate.send(TOPIC, partition, key, message).get();  // Sử dụng .get() để chờ kết quả gửi
//            return ResponseEntity.ok("Message published: " + message + " with key: " + key + " to partition: " + partition);
//        } catch (UnknownTopicOrPartitionException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Unknown topic or partition - " + e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error publishing message: " + e.getMessage());
//        }
//    }
}
