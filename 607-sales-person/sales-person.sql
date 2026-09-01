SELECT sp.name
FROM SalesPerson sp
LEFT JOIN Orders o
    ON sp.sales_id = o.sales_id
LEFT JOIN Company c
    ON c.com_id = o.com_id 
    AND c.name = "RED"
GROUP BY sp.sales_id, sp.name
HAVING COUNT(c.com_id) = 0;