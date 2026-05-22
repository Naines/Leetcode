-- # Write your MySQL query statement below
SELECT 
    s.user_id,
    ROUND(
        COALESCE(
            SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END) * 1.0
            /
            NULLIF(COUNT(c.action), 0),
            0
        ),2
    )AS confirmation_rate
FROM signups s
LEFT OUTER JOIN confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;


-- select * from signups;


-- select *
-- from signups s
-- left outer join confirmations c 
-- on s.user_id = c.user_id;
-- group by s.user_id;