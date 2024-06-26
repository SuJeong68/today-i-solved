SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS AS D
WHERE EXISTS (
    SELECT *
    FROM SKILLCODES AS S
    WHERE S.NAME IN ('Python', 'C#') AND (S.CODE & D.SKILL_CODE) > 0
)
ORDER BY D.ID ASC;