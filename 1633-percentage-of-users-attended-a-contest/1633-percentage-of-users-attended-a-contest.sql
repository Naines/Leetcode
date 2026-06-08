# Write your MySQL query statement below
SELECT 
    r.contest_id,
    ROUND(COUNT(DISTINCT r.user_id)*100/(select count(*) from users), 2) as percentage
FROM Register r
GROUP BY r.contest_id
order by percentage desc, contest_id asc;