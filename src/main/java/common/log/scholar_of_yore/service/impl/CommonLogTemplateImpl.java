package common.log.scholar_of_yore.service.impl;

import common.log.scholar_of_yore.entity.CommonLog;
import common.log.scholar_of_yore.enums.LogLevel;
import common.log.scholar_of_yore.service.LogTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CommonLogTemplateImpl implements LogTemplate {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void debug(String requestId, String PSM, String context) {
        CommonLog commonLog = new CommonLog(requestId, PSM, LogLevel.DEBUG.getLevel(),context);
        kafkaTemplate.sendDefault(PSM, commonLog);
    }

    @Override
    public void info(String requestId, String PSM, String context) {
        CommonLog commonLog = new CommonLog(requestId, PSM, LogLevel.INFO.getLevel(),context);
        kafkaTemplate.sendDefault(PSM, commonLog);
    }

    @Override
    public void warn(String requestId, String PSM, String context) {
        CommonLog commonLog = new CommonLog(requestId, PSM, LogLevel.WARN.getLevel(),context);
        kafkaTemplate.sendDefault(PSM, commonLog);
    }

    @Override
    public void error(String requestId, String PSM, String context) {
        CommonLog commonLog = new CommonLog(requestId, PSM, LogLevel.ERR.getLevel(),context);
        kafkaTemplate.sendDefault(PSM, commonLog);
    }
}
