# Write your MySQL query statement below
-- Employees(id, name)
-- EmployeeUNI(id, unique_id)

select eu.unique_id, e.name
from employees e
left join EmployeeUNI eu
on e.id = eu.id
order by eu.unique_id;

-- SELECT   eu.unique_id, e.name  
-- FROM  Employees e
-- LEFT JOIN EmployeeUNI eu 
-- ON e.id = eu.id
-- ORDER BY eu.unique_id ;