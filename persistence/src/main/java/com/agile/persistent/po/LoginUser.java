package com.agile.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ximing huang
 * @Date: 2018/10/31 9:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
   private  String  name;
    private String token;
}
