package org.example.scene.cache.cacheable.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @description: 模拟业务上的vo对象 该对象可被缓存
 * @Author shengy
 * @Date 2025/3/18 15:53
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DemoVo extends TableVo implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Integer id;

  private String filter;

  public int customHashCode() {
    return Objects.hash(id, filter);
  }
}
