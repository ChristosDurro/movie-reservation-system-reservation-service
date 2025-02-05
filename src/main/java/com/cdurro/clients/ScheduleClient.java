package com.cdurro.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdurro.model.Schedule;

@FeignClient("schedule-service")
public interface ScheduleClient {

	@PostMapping("/schedules/multiple")
	public ResponseEntity<List<Schedule>> getMultipleSchedules(@RequestBody List<Long> scheduleIds);
}
