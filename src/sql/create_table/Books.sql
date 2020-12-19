 CREATE TABLE Books(
   Book_Id varchar2(256),
   Title varchar2(128),
   Author varchar2(128),
   Purchase_price number(10,3),
   Selling_Price number(10,3),
   Stock int,
   PRIMARY KEY (Book_Id)
   );
