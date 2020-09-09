/**
 * @Project Name :  SchoolBus_Server
 * @Package Name :  com.agile.web.result
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-03-24 8:16 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.web.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  huangximing
 * @Description :  带分页查询结果
 * @Creation Date:  2018-03-24 8:16 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GridData<T> implements Serializable {

    /**
     * 返回的数据
     */
    private List<T> list = new ArrayList<>();

    private long total = 0l;

    private Integer pageSize;

    private Integer currentPage;

    private Integer allPageNo;
}