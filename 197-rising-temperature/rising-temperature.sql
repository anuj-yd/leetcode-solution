# Write your MySQL query statement belo
select w.id as Id from Weather w
join Weather o
on DATEDIFF(w.recordDate,o.recordDate) = 1 
and 
o.temperature < w.temperature;