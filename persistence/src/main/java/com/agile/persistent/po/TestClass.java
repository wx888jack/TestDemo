package com.agile.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by huangximing on 2020/4/21.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestClass {
    private String name;
    private Integer age;
}
