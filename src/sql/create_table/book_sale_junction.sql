CREATE TABLE Book_Sales_junction(
Book_Id varchar2(256),
Sales_id int,
Quantity int,
PRIMARY KEY (Book_Id,Sales_id),
constraint Book_Sales_junction_FK_BOOK FOREIGN KEY(Book_Id) REFERENCES Books(Book_Id),
constraint Book_Sales_junction_FK_SALE FOREIGN KEY (Sales_id) REFERENCES Sales(Sales_id)
);