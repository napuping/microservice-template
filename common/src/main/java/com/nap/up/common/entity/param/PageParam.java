package com.nap.up.common.entity.param;

import com.github.pagehelper.Page;
import lombok.Data;

/**
 * @creator napuping
 * @createTime 2020/3/9
 * @description
 */
@Data
public class PageParam {
    private Integer pageNum;
    private Integer pageSize = 10;
}
