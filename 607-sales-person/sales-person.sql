# Write your MySQL query statement below
select sp.name from SalesPerson sp
left join Orders o
on sp.sales_id = o.sales_id
left join Company c
on c.com_id = o.com_id and c.name = "RED"
group by sp.sales_id, sp.name
having COUNT(c.com_id) = 0;