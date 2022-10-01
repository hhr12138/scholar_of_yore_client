package common.log.scholar_of_yore.service.impl;

import common.entity.valhalla.util.RequestIdUtil;
import common.log.scholar_of_yore.service.LogTemplate;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class CommonLogTemplateImplTest {

    @Resource
    LogTemplate logTemplate;
    RequestIdUtil requestIdUtil = new RequestIdUtil();

    @Test
    @RepeatedTest(100)
    void debug() {
        logTemplate.debug(requestIdUtil.getRequestId(),"common.log.scholar_of_yore","debug test");
    }

    @Test
    void info() {
    }

    @Test
    void warn() {
    }

    @Test
    void error() {
    }

    @Test
    void selectLogsByRequestId() {
//        logTemplate.selectLogsByRequestId()
    }

    @Test
    void selectLogsGeneratedXMin() {
    }

    @Test
    void selectLogsByUserId() {
    }
}