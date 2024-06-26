-- 코드를 입력하세요
SELECT DISTINCT outer.user_id, outer.product_id
FROM online_sale outer
WHERE EXISTS (
SELECT inner.user_id, inner.product_id
FROM online_sale inner
WHERE inner.user_id = outer.user_id
AND inner.product_id = outer.product_id
AND inner.online_sale_id != outer.online_sale_id
)
ORDER BY user_id, product_id DESC
;