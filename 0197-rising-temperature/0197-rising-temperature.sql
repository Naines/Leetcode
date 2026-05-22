# Write your MySQL query statement below
select b.id
from weather a
cross join weather b
on datediff(b.recordDate, a.recordDate)=1 and b.temperature>a.temperature;