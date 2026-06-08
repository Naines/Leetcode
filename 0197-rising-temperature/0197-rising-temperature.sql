# Write your MySQL query statement below
select b.id
from weather a
cross join weather b
where datediff (b.recordDate,  a.recordDate)  = 1  and a.temperature<b.temperature;