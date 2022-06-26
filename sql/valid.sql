# 查询store log和order item 计数是否一致
SELECT
    oc.commodity_id,
    oc.order_amount,
    sc.store_amount
FROM
    (
        SELECT
            commodity_id,
            sum(amount) order_amount
        FROM
            ing_seata_order.biz_order_item
        GROUP BY
            commodity_id
    ) AS oc
        LEFT JOIN (
        SELECT
            commodity_id,
            sum(amount) store_amount
        FROM
            ing_seata_store.biz_store_log
        GROUP BY
            commodity_id
    ) AS sc ON oc.commodity_id = sc.commodity_id;