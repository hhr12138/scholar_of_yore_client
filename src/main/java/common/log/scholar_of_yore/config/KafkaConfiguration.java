package common.log.scholar_of_yore.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    public static final String DEFAULT_TOPIC = "common.log.scholar-of-yore.common-log";

    @Bean
    public ProducerFactory<String,Object> producerFactory(KafkaProperties properties){
        Map<String, Object> map = properties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(map);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String,Object> pf) {
        KafkaTemplate<String,Object> kafkaTemplate = new KafkaTemplate<>(pf);
        kafkaTemplate.setDefaultTopic(DEFAULT_TOPIC);
        return kafkaTemplate;
    }
}
