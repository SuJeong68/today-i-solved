SELECT ID, EMAIL, FIRST_NAME, LAST_NAME 
FROM DEVELOPER_INFOS 
WHERE 'PYTHON' IN (SKILL_1, SKILL_2, SKILL_3)
ORDER BY ID ASC;