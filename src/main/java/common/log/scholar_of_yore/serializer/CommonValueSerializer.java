package common.log.scholar_of_yore.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class CommonValueSerializer implements Serializer<Object> {
    ObjectMapper objectMapper = new ObjectMapper();
    StringSerializer stringSerializer = new StringSerializer();
    @SneakyThrows
    @Override
    public byte[] serialize(String topic, Object o) {
        String data = objectMapper.writeValueAsString(o);
        return stringSerializer.serialize(topic,data);
    }
}
