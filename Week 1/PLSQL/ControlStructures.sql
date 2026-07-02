SET SERVEROUTPUT ON;

DECLARE
    num NUMBER := 15;
BEGIN

    IF MOD(num,2)=0 THEN
        DBMS_OUTPUT.PUT_LINE('Even Number');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Odd Number');
    END IF;

    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('Value : ' || i);
    END LOOP;

END;
/