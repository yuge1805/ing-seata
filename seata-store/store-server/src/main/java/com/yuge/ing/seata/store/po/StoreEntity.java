package com.yuge.ing.seata.store.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 库存
 * </p>
 *
 * @author yuge
 * @since 2022-06-15
 */
@Getter
@Setter
@TableName("biz_store")
public class StoreEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 数量
     */
    private BigDecimal amount;


}
