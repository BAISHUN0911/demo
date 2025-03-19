package org.example.scene.cache.cacheable.vo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: Service层
 * @Author shengy
 * @Date 2025/3/18 16:05
 */
@Service
@EnableCaching
public class DemoService {
  // 缓存map集合
  private static final ConcurrentHashMap<Integer, String> cacheMap = new ConcurrentHashMap<>();

  @Cacheable(value = "demo", key = "#demoVo.hashCode()")
  public String commonMethod1(DemoVo demoVo) {
    System.out.println("缓存策略需要考虑到vo父类字段的情况");
    return "";
  }

  public String commonMethod2(DemoVo demoVo) {
    System.out.println("缓存策略只考虑vo字段的情况");
    if (cacheMap.containsKey(demoVo.customHashCode())) {
      return cacheMap.get(demoVo.customHashCode());
    } else {
      // 执行业务逻辑
      return "";
    }
  }
}
