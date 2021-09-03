package com.scj.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 19:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId;//产品ID
    private Integer total;//总数
    private Integer used;//已用
    private Integer residue;//剩余
}
