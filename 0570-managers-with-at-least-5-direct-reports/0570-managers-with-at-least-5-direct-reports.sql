# Write your MySQL query stIdement below
select a.name
from Employee a
JOIN Employee b 
on a.id = b.managerId
group by a.id
having count(b.id)>=5;