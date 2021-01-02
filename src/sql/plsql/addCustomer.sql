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