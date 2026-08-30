# Write your MySQL query statement below
select ep.name,b.bonus from Employee ep
left join Bonus b
on b.empId = ep.empId
group by ep.empId
having b.bonus < 1000 or b.bonus is null;
