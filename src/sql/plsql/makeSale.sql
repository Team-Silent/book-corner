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