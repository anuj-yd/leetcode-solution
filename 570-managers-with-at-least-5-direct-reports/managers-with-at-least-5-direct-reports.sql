# Write your MySQL query statement below
# Write your MySQL query statement below
select e.name from Employee e
join Employee ep
on e.id = ep.managerId
group by e.id,e.name
having count(ep.managerId) >= 5;