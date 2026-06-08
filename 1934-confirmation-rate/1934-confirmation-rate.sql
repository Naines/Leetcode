# Write your MySQL query statement below
-- confirmation messages/total requests
select s.user_id, round(sum( case when c.action='confirmed' then 1 else 0 end) / count(*),2) as confirmation_rate
from Signups s
left join confirmations c
on s.user_id = c.user_id
group by user_id;
