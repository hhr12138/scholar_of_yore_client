package common.log.scholar_of_yore.service;

import common.entity.valhalla.vo.RestResponse;
import common.log.scholar_of_yore.entity.CommonLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(url = "${common.log.scholar-of-yore:127.0.0.1:8889}",name = "commonLogClient")
public interface CommonLogClient {
    @DeleteMapping("/realDeleteLogs")
    RestResponse<Integer> realDeleteLogsGeneratedXDayAgo(@RequestParam String requestId, @RequestParam int x);
    @GetMapping("/selectByRequestId/{requestId}/{targetRequestId}/{startTime}/{endTime}")
    RestResponse<List<CommonLog>> selectLogsByRequestId(@PathVariable String requestId, @PathVariable String targetRequestId, @PathVariable long startTime, @PathVariable long endTime);
    @GetMapping("/selectByRequestId/{requestId}/{targetRequestId}")
    RestResponse<List<CommonLog>> selectLogsByRequestId(@PathVariable String requestId, @PathVariable String targetRequestId);
    @GetMapping("/selectGeneratedXMin/{requestId}/{x}")
    RestResponse<List<CommonLog>> selectLogsGeneratedXMin(@PathVariable String requestId,@PathVariable int x);
    @GetMapping("/selectByUserId/{requestId}/{userId}/{startTime}/{endTime}/{pageCnt}/{size}")
    RestResponse<List<CommonLog>> selectLogsByUserId(@PathVariable String requestId, @PathVariable Long userId, @PathVariable long startTime, @PathVariable long endTime, @PathVariable(required = false) int pageCnt,@PathVariable(required = false) int size);
}
