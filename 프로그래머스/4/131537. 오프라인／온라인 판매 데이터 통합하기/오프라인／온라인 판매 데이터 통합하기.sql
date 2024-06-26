-- 코드를 입력하세요
SELECT TO_CHAR(sales_date,'YYYY-MM-DD'), product_id, user_id, sales_amount
FROM online_sale
WHERE TO_CHAR(sales_date, 'YYYY-MM') = '2022-03'
UNION ALL
SELECT TO_CHAR(sales_date,'YYYY-MM-DD'), product_id, NULL AS user_id, sales_amount
FROM offline_sale
WHERE TO_CHAR(sales_date, 'YYYY-MM') = '2022-03'
ORDER BY 1, 2, 3
;

