package common.log.scholar_of_yore.service;

import common.entity.valhalla.vo.RestResponse;
import common.log.scholar_of_yore.entity.CommonLog;

import java.util.List;

public interface CommonLogService {

    RestResponse<Integer> realDeleteLogsGeneratedXDayAgo(String requestId, int x);

    RestResponse<List<CommonLog>> selectLogsByRequestId(String requestId, String targetRequestId, long startTime, long endTime, int size);

    RestResponse<List<CommonLog>> selectLogsGeneratedXMin(String requestId, int x);

    RestResponse<List<CommonLog>> selectLogsByUserId(String requestId, Long userId, long startTime, long endTime, int pageCnt, int size);
}
