package com.it.feign;

import com.it.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("member")
public interface UserFeign extends UserService {
}
