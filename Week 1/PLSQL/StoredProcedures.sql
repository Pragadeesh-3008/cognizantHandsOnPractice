CREATE OR REPLACE PROCEDURE GetEmployeeDetails(
    emp_id NUMBER
)
IS
    emp_name VARCHAR2(50);
    emp_salary NUMBER;
BEGIN

    SELECT employee_name,salary
    INTO emp_name,emp_salary
    FROM employees
    WHERE employee_id = emp_id;

    DBMS_OUTPUT.PUT_LINE(
        'Name : ' || emp_name
    );

    DBMS_OUTPUT.PUT_LINE(
        'Salary : ' || emp_salary
    );

EXCEPTION

    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(
            'Employee Not Found'
        );

END;
/