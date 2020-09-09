/**
 * @Project Name :  SchoolBus_Server
 * @Package Name :  com.agile.web.base
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-03-24 8:35 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.web.base;

import com.agile.web.result.GridData;

/**
 * @author :  panduanduan
 * @Description :  业务处理层基类
 * @Creation Date:  2018-03-24 8:35 PM
 */
public class BaseService {

    protected  GridData constructGridData(Integer page, Integer pageSize) {
        GridData gridData = GridData.builder().pageSize(pageSize).currentPage(page).build();
        return gridData;
    }

}