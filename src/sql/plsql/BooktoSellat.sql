CREATE OR REPLACE PROCEDURE booktosellat(bid varchar2(256),qnt int)
    IS

    
    found int;
    sid int;
	cid varchar2(11);


BEGIN
	select Sales_id,Customer_id into sid,cid from Sales;

    select case
               when exists(select 1 from Sales where Sales_id = sid) then 1
               else  0
               end into found from DUAL;

    IF found=0 THEN
       INSERT INTO Book_Sales_junction VALUES(bid,sid,qnt);
    
    END IF;
END;
/