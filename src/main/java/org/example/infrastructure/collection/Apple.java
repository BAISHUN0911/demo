package org.example.infrastructure.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 生产日期早的排前面，生产日期相同数量多的排前面，这两个都相等name升序排序，否则相等
 * 实现思路 自定义类实现Comparable接口，重写compareTo方法
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 14:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Apple implements Comparable<Apple>{
    private String name;

    private Integer nums;

    /**
     * 生产日期
     */
    private LocalDateTime productDate;

    @Override
    public int compareTo(Apple o) {
        int arg1 = this.productDate.compareTo(o.productDate);
        if (arg1 != 0) {
            return arg1;
        }
        int arg2 = o.nums.compareTo(this.nums);
        if (arg2 != 0) {
            return arg2;
        }
        return this.name.compareTo(o.name);
    }
}
