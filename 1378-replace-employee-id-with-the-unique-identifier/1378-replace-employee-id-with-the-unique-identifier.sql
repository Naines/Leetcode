# Write your MySQL query statement below
-- Employees(id, name)
-- EmployeeUNI(id, unique_id)

select eu.unique_id, e.name
from employees e
left join EmployeeUNI eu
on e.id = eu.id;