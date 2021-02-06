
 CREATE TABLE Book_customer_junction(
    Book_Id varchar2(256),
    Customer_id varchar2(128),
    Quantity int,
    PRIMARY KEY (Book_Id,Customer_id),
    CONSTRAINT Book_customer_junction_FK_Book FOREIGN KEY(Book_Id) REFERENCES Books(Book_Id),
    CONSTRAINT Book_customer_junction_FK_Cust FOREIGN KEY (Customer_id) REFERENCES Customers(Contact_Number)
    );