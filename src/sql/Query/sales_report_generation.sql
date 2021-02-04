SELECT Sales_id, Customers.Name, TO_CHAR( Sales_Date, 'HH24:MI:SS' )
From Sales, Customers
Where TO_CHAR(Sales_Date,'DD-MM-YYYY')='04-02-2021' AND Sales.Customer_id=Customers.Contact_Number;

SELECT Book_id, Quantity
FROM Book_Sales_junction
Where Sales_id='$';
