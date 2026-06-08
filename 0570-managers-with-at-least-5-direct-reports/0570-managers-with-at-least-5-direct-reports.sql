# Write your MySQL query statement below
select b.name
from Employee a
inner join Employee b
ON a.managerId = b.id 
where a.managerId is not null
group by b.name, a.managerId
having count(a.managerId)>4;