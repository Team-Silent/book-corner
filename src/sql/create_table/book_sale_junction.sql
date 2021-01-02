CREATE TABLE Book_Sales_junction(
Book_Id varchar2(256),
Sales_id int,
Quantity int,
PRIMARY KEY (Book_Id,Sales_id),
FOREIGN KEY(Book_Id) REFERENCES Books(Book_Id),
FOREIGN KEY (Sales_id) REFERENCES Sales(Sales_id)
);