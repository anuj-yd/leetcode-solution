# Write your MySQL query statement below
SELECT c.name
FROM Customer c
LEFT JOIN Customer rf
    ON c.referee_id = rf.id
WHERE rf.id != 2
   OR rf.id IS NULL;