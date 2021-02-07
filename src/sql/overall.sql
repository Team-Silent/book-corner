--CREATE TABLE:

CREATE TABLE Customers(
                          Contact_Number varchar2(11),
                          Name varchar2(32),
                          Address varchar2(128),
                          PRIMARY KEY (Contact_Number)
);


CREATE TABLE Books(
                      Book_Id varchar2(256),
                      Title varchar2(128),
                      Author varchar2(128),
                      Purchase_price number(10,3),
                      Selling_Price number(10,3),
                      Stock int,
                      PRIMARY KEY (Book_Id)
);

CREATE TABLE Sales(
                      Sales_id int,
                      Customer_id varchar2(11),
                      Sales_Date date,
                      PRIMARY KEY (Sales_id),
                      constraint Sales_FK_CUSTOMER FOREIGN KEY(Customer_id) REFERENCES Customers(Contact_Number)
);


CREATE TABLE Book_customer_junction(
                                       Book_Id varchar2(256),
                                       Customer_id varchar2(128),
                                       Quantity int,
                                       PRIMARY KEY (Book_Id,Customer_id),
                                       CONSTRAINT Book_customer_junction_FK_Book FOREIGN KEY(Book_Id) REFERENCES Books(Book_Id),
                                       CONSTRAINT Book_customer_junction_FK_Cust FOREIGN KEY (Customer_id) REFERENCES Customers(Contact_Number)
);

CREATE TABLE Book_Sales_junction(
                                    Book_Id varchar2(256),
                                    Sales_id int,
                                    Quantity int,
                                    PRIMARY KEY (Book_Id,Sales_id),
                                    constraint Book_Sales_junction_FK_BOOK FOREIGN KEY(Book_Id) REFERENCES Books(Book_Id),
                                    constraint Book_Sales_junction_FK_SALE FOREIGN KEY (Sales_id) REFERENCES Sales(Sales_id)
);


--END CREATE TABLE

--SEED GOES HERE:







--END SEED

--PLSQL:
--END PLSQL