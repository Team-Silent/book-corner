select Book_Sales_junction.Sales_id, Book_id, Quantity
from Book_Sales_junction,Sales
Where Book_Sales_junction.Sales_id=Sales.Sales_id AND Sales.Sales_Date=$;
