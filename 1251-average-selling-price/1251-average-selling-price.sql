# Write your MySQL query statement below
-- avg -> p1+p2+p3/3
select p.product_id, 
IFNULL(ROUND(SUM(p.price * us.units) / SUM(us.units), 2),0) AS average_price
from prices p
left join unitsSold us
on p.product_id = us.product_id
and p.start_Date<=us.purchase_date and p.end_Date>=us.purchase_Date
group by p.product_id;