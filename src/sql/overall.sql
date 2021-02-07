--DROP TABLE:
drop table BOOK_CUSTOMER_JUNCTION;
drop table BOOK_SALES_JUNCTION;
drop table SALES;
drop table BOOKS;
drop table CUSTOMERS;
drop sequence SALES_SEQ;
--END DROP



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
insert into CUSTOMERS VALUES ('1','customer_1','address_1');
insert into CUSTOMERS VALUES ('2','customer_2','address_2');
insert into CUSTOMERS VALUES ('3','customer_3','address_3');
insert into CUSTOMERS VALUES ('4','customer_4','address_4');
insert into CUSTOMERS VALUES ('5','customer_5','address_5');

insert into BOOKS VALUES ('book1 by author1','book1','author1',100,190,100);
insert into BOOKS VALUES ('book2 by author2','book2','author2',200,290,120);
insert into BOOKS VALUES ('book3 by author3','book3','author3',300,390,150);
insert into BOOKS VALUES ('book4 by author4','book4','author4',400,490,80);
insert into BOOKS VALUES ('book5 by author5','book5','author5',500,590,110);
insert into BOOKS VALUES ('book4 by author7','book4','author7',400,490,80);
insert into BOOKS VALUES ('book4 by author3','book4','author3',520,580,110);

insert into SALES values (1,1,sysdate-3);
insert into SALES values (2,2,sysdate-3);
insert into SALES values (3,4,sysdate-3);
insert into SALES values (4,1,sysdate-2);
insert into SALES values (5,3,sysdate-2);
insert into SALES values (6,5,sysdate-2);
insert into SALES values (7,2,sysdate-1);
insert into SALES values (8,4,sysdate-1);
insert into SALES values (9,5,sysdate-1);



insert into book_sales_junction values ('book1 by author1',1,5);
insert into book_sales_junction values ('book2 by author2',1,3);
insert into book_sales_junction values ('book3 by author3',1,2);

insert into book_sales_junction values ('book4 by author4',2,3);
insert into book_sales_junction values ('book4 by author7',2,2);
insert into book_sales_junction values ('book4 by author3',2,3);
insert into book_sales_junction values ('book2 by author2',2,1);

insert into book_sales_junction values ('book5 by author5',3,2);
insert into book_sales_junction values ('book1 by author1',3,4);
insert into book_sales_junction values ('book4 by author4',3,2);

insert into book_sales_junction values ('book4 by author7',4,2);
insert into book_sales_junction values ('book4 by author3',4,3);
insert into book_sales_junction values ('book2 by author2',4,1);
insert into book_sales_junction values ('book1 by author1',4,5);

insert into book_sales_junction values ('book4 by author3',5,3);
insert into book_sales_junction values ('book2 by author2',5,1);
insert into book_sales_junction values ('book5 by author5',5,2);

insert into book_sales_junction values ('book2 by author2',6,4);
insert into book_sales_junction values ('book5 by author5',6,1);

insert into book_sales_junction values ('book5 by author5',7,1);
insert into book_sales_junction values ('book2 by author2',7,1);

insert into book_sales_junction values ('book4 by author3',8,3);
insert into book_sales_junction values ('book2 by author2',8,1);

insert into book_sales_junction values ('book1 by author1',9,1);
insert into book_sales_junction values ('book5 by author5',9,1);
insert into book_sales_junction values ('book4 by author3',9,1);

--END SEED

--PLSQL:

CREATE OR REPLACE PROCEDURE addCustomer(
    Name Customers.name%TYPE,
    Contact_no Customers.Contact_Number%TYPE,
    Address Customers.Address%TYPE
)
    IS


    found int;


BEGIN
    select case
               when exists(select 1 from Customers where Contact_Number = Contact_no) then 1
               else  0
               end into found from DUAL;

    IF found=0 THEN
        INSERT INTO Customers VALUES(Contact_no,Name,Address);

    END IF;
END;
/




CREATE OR REPLACE PROCEDURE book_to_sale_for(
    cid Sales.Customer_id%TYPE,
    bid BOOK_CUSTOMER_JUNCTION.Book_Id%TYPE,
    qnt BOOK_CUSTOMER_JUNCTION.Quantity%TYPE
)
    IS
    sid int;
    updated_stock int;
    stock int;

BEGIN
    select Sales_id into sid
    from(
            SELECT Sales_id
            from Sales
            Where Customer_id=cid
            ORDER BY Sales_id DESC)
    Where ROWNUM = 1;

    INSERT INTO Book_Sales_junction VALUES(bid,sid,qnt);

    select Stock into stock
    from Books
    Where Book_Id=bid;

    updated_stock:=stock-qnt;

    UPDATE Books
    SET Stock=updated_stock
    where Book_Id=bid;

END;
/


CREATE OR REPLACE PROCEDURE insertBook(
    p_title BOOKS.TITLE%TYPE,
    p_author BOOKS.AUTHOR%TYPE,
    p_purchase_price BOOKS.PURCHASE_PRICE%TYPE,
    p_selling_Price BOOKS.SELLING_PRICE%TYPE,
    p_quantity BOOKS.STOCK%TYPE)
    IS

    found_stock int;
    found int;
    v_id varchar2(256):=p_title||' by '||p_author;

BEGIN
    select case
               when exists(select 1 from BOOKS where BOOK_ID = v_id) then 1
               else  0
               end into found from DUAL;

    IF found=1 THEN
        select STOCK into found_stock from BOOKS where BOOK_ID = v_id;
        UPDATE Books set Stock=found_stock+p_quantity WHERE BOOK_ID = v_id;
    ELSE
        INSERT INTO Books VALUES(v_id,p_title,p_author,p_purchase_price,p_selling_Price,p_quantity);
    END IF;
END;
/


create or replace procedure buy(
    p_book_id BOOK_CUSTOMER_JUNCTION.BOOK_ID%TYPE,
    p_customer_id BOOK_CUSTOMER_JUNCTION.CUSTOMER_ID%TYPE,
    p_quantity BOOK_CUSTOMER_JUNCTION.QUANTITY%TYPE
)

    IS

    found int := 1;
    found_quantity int;


BEGIN

    select case
               when exists(select 1
                           from BOOK_CUSTOMER_JUNCTION
                           where BOOK_ID = p_book_id and
                                   CUSTOMER_ID = p_customer_id ) then 1
               else  0
               end into found from DUAL;
    If found = 1 THEN
        select Quantity into found_quantity from BOOK_CUSTOMER_JUNCTION
        where BOOK_ID = p_book_id and
                CUSTOMER_ID = p_customer_id;

        UPDATE BOOK_CUSTOMER_JUNCTION
        set QUANTITY = found_quantity+p_quantity
        WHERE BOOK_ID = p_book_id and
                CUSTOMER_ID = p_customer_id;
    ELSE
        INSERT INTO BOOK_CUSTOMER_JUNCTION values (p_book_id,p_customer_id,p_quantity);
    end if;

end;
/
show errors;



CREATE SEQUENCE sales_seq START WITH 10;


CREATE OR REPLACE TRIGGER sales_bir
    BEFORE INSERT ON Sales
    FOR EACH ROW

BEGIN
    SELECT sales_seq.NEXTVAL
    INTO   :new.Sales_id
    FROM   dual;
END;
/



CREATE OR REPLACE PROCEDURE makeSales(
    v_customerid Sales.Customer_id%TYPE
)
    IS




BEGIN

    INSERT INTO Sales(Customer_id,Sales_Date) VALUES(v_customerid,sysdate);

END;
/
--END PLSQL