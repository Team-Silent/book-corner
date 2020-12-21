
CREATE OR REPLACE PROCEDURE insertBook(title varchar2(128),author varchar2(128),purchase_price number(10,3),
                            selling_Price number(10,3),quantity int)

    IS
    cnt_title int;
    v_stock int;
    v_id varchar2(256);
BEGIN
    select COUNT(Title),Stock INTO cnt_title,v_stock
    FROM Books
    Where Title=title AND Author=author;

    IF cnt_title=1 THEN
        UPDATE Books set Stock=v_stock+quantity WHERE Title=title AND Author=author;
    ELSE
        v_id := CONCAT (title,author);
        INSERT INTO Books VALUES(v_id,title,author,purchase_price,selling_Price,quantity);
    END IF;
END;
/
