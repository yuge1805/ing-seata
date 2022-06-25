package com.yuge.ing.seata.store.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author yuge
 * @since 2022-06-25
 */
@Getter
@Setter
@TableName("biz_commodity")
public class CommodityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime crtTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updTime;

    /**
     * 删除标记； 0 未删除 1已删除
     */
    private Integer deleted;


}
