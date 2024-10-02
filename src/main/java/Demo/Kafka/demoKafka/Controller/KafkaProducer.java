package Demo.Kafka.demoKafka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "example_topic";

    @GetMapping("/publish/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message published: " + message;
    }
}
