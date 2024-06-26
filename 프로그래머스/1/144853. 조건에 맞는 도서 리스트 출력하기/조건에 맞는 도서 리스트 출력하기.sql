-- 코드를 입력하세요

SELECT book_id, TO_CHAR(published_date, 'YYYY-MM-DD')
FROM book
WHERE (published_date BETWEEN TO_DATE('2021-01-01', 'YYYY-MM-DD') AND TO_DATE('2022-01-01', 'YYYY-MM-DD')-1)
AND category = '인문'
ORDER BY published_date
;