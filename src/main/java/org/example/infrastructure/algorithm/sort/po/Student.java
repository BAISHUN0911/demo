package org.example.infrastructure.algorithm.sort.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/7/11 17:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student> {
    private Long id;

    private String name;

    private int totalPoints;

    private Date birth;

    /**
     * 默认定制排序，按id升序，name升序
     * 注意null值情况，Objects.equals(null, o.getId())会返回false,如果再用null去调用compareTo方法肯定报空指针异常
     * 所以这里可能需要null值检查
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        if (!Objects.equals(this.getId(), o.getId())) {
            return this.getId().compareTo(o.getId());
        } else {
            return this.getName().compareTo(o.getName());
        }
    }
}
