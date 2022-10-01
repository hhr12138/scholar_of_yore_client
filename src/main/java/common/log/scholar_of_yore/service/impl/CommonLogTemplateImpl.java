package common.log.scholar_of_yore.service.impl;

import common.entity.valhalla.vo.RestResponse;
import common.log.scholar_of_yore.entity.CommonLog;
import common.log.scholar_of_yore.enums.LogLevel;
import common.log.scholar_of_yore.service.CommonLogService;
import common.log.scholar_of_yore.service.LogTemplate;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CommonLogTemplateImpl implements LogTemplate {
    @DubboReference
    private CommonLogService commonLogService;
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

    @Override
    public RestResponse<List<CommonLog>> selectLogsByRequestId(String requestId, String targetRequestId, long startTime, long endTime, int size) {
        return commonLogService.selectLogsByRequestId(requestId,targetRequestId,startTime,endTime,size);
    }

    @Override
    public RestResponse<List<CommonLog>> selectLogsGeneratedXMin(String requestId, int x) {
        return commonLogService.selectLogsGeneratedXMin(requestId,x);
    }

    @Override
    public RestResponse<List<CommonLog>> selectLogsByUserId(String requestId, Long userId, long startTime, long endTime, int pageCnt, int size) {
        return commonLogService.selectLogsByUserId(requestId,userId,startTime,endTime,pageCnt,size);
    }
}
