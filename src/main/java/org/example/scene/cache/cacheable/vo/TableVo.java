package org.example.scene.cache.cacheable.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @description:
 * @Author shengy
 * @Date 2025/3/18 15:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableVo implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  // 页数
  private Integer page;

  // 页容量
  private Integer limit;

  // 排序字段
  private String orderBy;

  // 排序方式
  private String orderType;
}
