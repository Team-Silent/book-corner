insert into CUSTOMERS VALUES ('1','customer_1','address_1');
insert into CUSTOMERS VALUES ('2','customer_2','address_2');
insert into CUSTOMERS VALUES ('3','customer_3','address_3');
insert into CUSTOMERS VALUES ('4','customer_4','address_4');
insert into CUSTOMERS VALUES ('5','customer_5','address_5');

insert into BOOKS VALUES ('book1author1','book1','author1',1000,1900,10);
insert into BOOKS VALUES ('book2author2','book2','author2',2000,2900,12);
insert into BOOKS VALUES ('book3author3','book3','author3',3000,3900,15);
insert into BOOKS VALUES ('book4author4','book4','author4',4000,4900,8);
insert into BOOKS VALUES ('book5author5','book5','author5',5000,5900,11);
insert into BOOKS VALUES ('book4author7','book4','author7',4000,4900,8);
insert into BOOKS VALUES ('book4author3','book4','author3',5000,5900,11);

insert into SALES values (1,1,sysdate);
insert into SALES values (2,2,sysdate);
insert into SALES values (3,4,sysdate);
insert into SALES values (4,1,sysdate);
insert into SALES values (5,3,sysdate);
insert into SALES values (6,5,sysdate);

insert into Book_Customer_Junction values ('book4author4',3,10);
insert into Book_Customer_Junction values ('book5author5',2,8);
insert into Book_Customer_Junction values ('book4author4',2,4);
insert into Book_Customer_Junction values ('book1author1',1,2);
insert into Book_Customer_Junction values ('book3author3',4,6);
insert into Book_Customer_Junction values ('book2author2',4,8);
insert into Book_Customer_Junction values ('book3author3',5,5);
insert into Book_Customer_Junction values ('book4author4',5,4);
insert into Book_Customer_Junction values ('book5author5',1,4);
insert into Book_Customer_Junction values ('book2author2',5,1);

/* Some values gives error ...*/
insert into book_sales_junction values ('book5author5',3,8);
insert into book_sales_junction values ('book5author5',3,1);
insert into book_sales_junction values ('book3author3',3,3);
insert into book_sales_junction values ('book2author2',1,4);
insert into book_sales_junction values ('book1author1',1,4);
insert into book_sales_junction values ('book5author5',2,2);
insert into book_sales_junction values ('book2author2',2,1);
insert into book_sales_junction values ('book3author3',2,2);
insert into book_sales_junction values ('book1author1',4,5);
insert into book_sales_junction values ('book5author5',4,3);
insert into book_sales_junction values ('book2author2',5,4);
insert into book_sales_junction values ('book3author3',5,5);
insert into book_sales_junction values ('book5author5',5,1);
insert into book_sales_junction values ('book3author3',6,3);
insert into book_sales_junction values ('book1author1',6,1);
insert into book_sales_junction values ('book4author4',6,5);
