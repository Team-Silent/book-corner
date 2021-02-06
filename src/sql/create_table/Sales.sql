CREATE TABLE Sales(
Sales_id int,
Customer_id varchar2(11),
Sales_Date date,
PRIMARY KEY (Sales_id),
constraint Sales_FK_CUSTOMER FOREIGN KEY(Customer_id) REFERENCES Customers(Contact_Number)
);
