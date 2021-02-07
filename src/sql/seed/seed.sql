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

/* Some values gives error ...*/
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