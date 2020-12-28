create or replace procedure buy(
                            p_customer_id varchar2,
                            p_book_id varchar2,
                            p_quantity integer
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
