-- 코드를 입력하세요
SELECT f.flavor
FROM first_half f, icecream_info i
WHERE f.flavor = i.flavor 
 AND f.total_order > 3000 
 AND i.ingredient_type = 'fruit_based'
ORDER BY f.total_order DESC
;