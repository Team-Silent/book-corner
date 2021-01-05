CREATE OR REPLACE PROCEDURE book_to_sell_at(
                            cid Sales.Customer_id%TYPE,
                            bid BOOK_CUSTOMER_JUNCTION.Book_Id%TYPE,
                            qnt BOOK_CUSTOMER_JUNCTION.Quantity%TYPE
)
    IS

    
    found int;

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

    select case
               when exists(select 1 from Sales where Sales_id = sid) then 1
               else  0
               end into found from DUAL;

    IF found=0 THEN
       INSERT INTO Book_Sales_junction VALUES(bid,sid,qnt);

       select Stock into stock
       from Books
       Where Book_Id=bid;

       updated_stock:=stock-qnt;

       UPDATE Books
       SET Stock=updated_stock
       where Book_Id=bid;
    END IF;
END;
/