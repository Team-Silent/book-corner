CREATE OR REPLACE PROCEDURE insertBook(
                        p_title varchar2,
                        p_author varchar2,
                        p_purchase_price number,
                        p_selling_Price number,
                        p_quantity int)
    IS

    found_stock int;
    found int;
    v_id varchar2(256):=p_title||p_author;

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
