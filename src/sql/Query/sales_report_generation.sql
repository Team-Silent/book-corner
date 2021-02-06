SELECT Sales_id, Customer_id, TO_CHAR( Sales_Date, 'HH24:MI:SS' ) as Time
From Sales
Where TO_CHAR(Sales_Date,'DD-MM-YYYY')='04-02-2021';

SELECT Book_id, Quantity FROM Book_Sales_junction Where Sales_id='$';
