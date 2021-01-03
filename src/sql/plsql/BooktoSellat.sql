CREATE OR REPLACE PROCEDURE booktosellat()
    IS

    
    found int;
    sid int;
	cid varchar2(11);
	qnt int;
	bid varchar2(256);

BEGIN
	select Sales_id,Customer_id into sid,cid from Sales;
	select Book_Id, Quantity into bid, qnt from Book_customer_junction where Customer_id=cid;
    select case
               when exists(select 1 from Sales where Sales_id = sid) then 1
               else  0
               end into found from DUAL;

    IF found=0 THEN
       INSERT INTO Book_Sales_junction VALUES(bid,sid,qnt);
    
    END IF;
END;
/