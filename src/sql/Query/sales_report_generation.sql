SELECT Sales_id, Customers.Name, TO_CHAR( Sales_Date, 'HH24:MI:SS' )
From Sales, Customers
Where TO_CHAR( Sales_Date, 'DD-Mon-YYYY' )=TO_CHAR( sysdate, 'DD-Mon-YYYY' ) AND Sales.Customer_id=Customers.Contact_Number;


SELECT Book_id, Quantity
FROM Book_Sales_junction
Where Sales_id='$';
