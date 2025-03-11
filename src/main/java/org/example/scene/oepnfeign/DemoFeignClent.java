package org.example.scene.oepnfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author BAISHUN
 * @Date: 2024/5/12 19:25
 */
@FeignClient(name = "default", url = "http://www.baidu.com")
public interface DemoFeignClent {
    @GetMapping("/hello")
    String getHello();
}
