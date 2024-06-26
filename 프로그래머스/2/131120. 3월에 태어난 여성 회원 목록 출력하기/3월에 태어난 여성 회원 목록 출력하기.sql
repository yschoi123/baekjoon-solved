-- 코드를 입력하세요
SELECT member_id, member_name, gender, TO_CHAR(date_of_birth, 'YYYY-MM-DD')
FROM MEMBER_PROFILE
WHERE TO_CHAR(date_of_birth, 'MM') = '03'
AND gender = 'W'
AND tlno IS NOT NULL
ORDER BY member_id