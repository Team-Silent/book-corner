CREATE OR REPLACE PROCEDURE insertBook(
                        p_title BOOKS.TITLE%TYPE,
                        p_author BOOKS.AUTHOR%TYPE,
                        p_purchase_price BOOKS.PURCHASE_PRICE%TYPE,
                        p_selling_Price BOOKS.SELLING_PRICE%TYPE,
                        p_quantity BOOKS.STOCK%TYPE)
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
