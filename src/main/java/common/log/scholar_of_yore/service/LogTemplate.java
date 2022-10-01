package common.log.scholar_of_yore.service;

import common.entity.valhalla.vo.RestResponse;
import common.log.scholar_of_yore.entity.CommonLog;
import common.log.scholar_of_yore.enums.LogLevel;

import java.util.List;

public interface LogTemplate {

    void debug(String requestId, String PSM, String context);

    void info(String requestId, String PSM, String context);

    void warn(String requestId, String PSM, String context);

    void error(String requestId, String PSM, String context);

    RestResponse<List<CommonLog>> selectLogsByRequestId(String requestId, String targetRequestId, long startTime, long endTime, int size);

    RestResponse<List<CommonLog>> selectLogsGeneratedXMin(String requestId, int x);

    RestResponse<List<CommonLog>> selectLogsByUserId(String requestId, Long userId, long startTime, long endTime, int pageCnt, int size);
}
