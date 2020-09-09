/**
 * @Project Name :  mainserver
 * @Package Name :  com.agile.web.result
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 1:56 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.web.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :  huangximing
 * @Description :  restful response
 * @Creation Date:  2018-01-24 1:56 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrientRestfulResp<T> implements Serializable {

    /**
     * 响应业务状态
     */
    private Integer status;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 提示信息
     */
    private String error;
}