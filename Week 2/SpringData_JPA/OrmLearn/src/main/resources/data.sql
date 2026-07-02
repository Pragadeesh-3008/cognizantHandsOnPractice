-- ============================================================
--  OrmLearn — Initial Seed Data (data.sql)
--  Runs after Hibernate creates tables (defer-datasource-initialization=true)
-- ============================================================

-- ---- Country Data ------------------------------------------
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States');
INSERT INTO country (co_code, co_name) VALUES ('GB', 'Great Britain');
INSERT INTO country (co_code, co_name) VALUES ('AU', 'Australia');
INSERT INTO country (co_code, co_name) VALUES ('CN', 'China');
INSERT INTO country (co_code, co_name) VALUES ('ZA', 'South Africa');
INSERT INTO country (co_code, co_name) VALUES ('ZW', 'Zimbabwe');
INSERT INTO country (co_code, co_name) VALUES ('ZM', 'Zambia');
INSERT INTO country (co_code, co_name) VALUES ('MX', 'Mexico');
INSERT INTO country (co_code, co_name) VALUES ('CA', 'Canada');
INSERT INTO country (co_code, co_name) VALUES ('FR', 'France');
INSERT INTO country (co_code, co_name) VALUES ('DE', 'Germany');
INSERT INTO country (co_code, co_name) VALUES ('JP', 'Japan');
INSERT INTO country (co_code, co_name) VALUES ('BR', 'Brazil');
INSERT INTO country (co_code, co_name) VALUES ('RU', 'Russia');
-- Countries containing "ou"
INSERT INTO country (co_code, co_name) VALUES ('EC', 'Ecuador');
INSERT INTO country (co_code, co_name) VALUES ('HN', 'Honduras');

-- ---- Department Data ----------------------------------------
INSERT INTO department (de_name) VALUES ('Engineering');
INSERT INTO department (de_name) VALUES ('Marketing');
INSERT INTO department (de_name) VALUES ('Finance');
INSERT INTO department (de_name) VALUES ('Human Resources');

-- ---- Skill Data --------------------------------------------
INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('Spring Boot');
INSERT INTO skill (sk_name) VALUES ('Hibernate');
INSERT INTO skill (sk_name) VALUES ('Python');
INSERT INTO skill (sk_name) VALUES ('SQL');

-- ---- Employee Data -----------------------------------------
INSERT INTO employee (em_name, em_salary, em_permanent, em_dob, em_de_id)
    VALUES ('Alice Johnson', 75000.00, TRUE, '1990-05-15', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_dob, em_de_id)
    VALUES ('Bob Smith', 60000.00, FALSE, '1993-08-22', 2);
INSERT INTO employee (em_name, em_salary, em_permanent, em_dob, em_de_id)
    VALUES ('Carol White', 90000.00, TRUE, '1985-11-30', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_dob, em_de_id)
    VALUES ('David Brown', 55000.00, TRUE, '1996-03-10', 3);
INSERT INTO employee (em_name, em_salary, em_permanent, em_dob, em_de_id)
    VALUES ('Eva Green', 80000.00, FALSE, '1991-07-04', 4);

-- ---- Employee-Skill Junction --------------------------------
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 4);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 5);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 5);

-- ---- Stock Data (Facebook FB — September 2019) -------------
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('FB', '2019-09-03', 186.00, 187.50, 14500000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('FB', '2019-09-04', 187.50, 189.20, 13200000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('FB', '2019-09-05', 189.20, 188.90, 11000000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('FB', '2019-09-06', 188.90, 191.00, 15800000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('FB', '2019-09-09', 191.00, 190.20, 12400000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('FB', '2019-09-10', 190.20, 193.50, 17200000);

-- ---- Stock Data (Google GOOG — price > 1250) ---------------
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('GOOG', '2019-09-03', 1192.00, 1198.00, 950000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('GOOG', '2019-09-04', 1198.00, 1255.50, 1100000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('GOOG', '2019-09-05', 1255.50, 1263.00, 880000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('GOOG', '2019-09-06', 1263.00, 1270.20, 920000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('GOOG', '2019-09-09', 1270.20, 1245.00, 870000);

-- ---- Stock Data (Netflix NFLX) -----------------------------
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('NFLX', '2019-09-03', 294.00, 296.50, 5100000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('NFLX', '2019-09-04', 296.50, 291.20, 6800000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('NFLX', '2019-09-05', 291.20, 287.50, 7500000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('NFLX', '2019-09-06', 287.50, 290.00, 9200000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('NFLX', '2019-09-09', 290.00, 285.30, 11000000);
INSERT INTO stock (st_label, st_date, st_open, st_close, st_volume)
    VALUES ('NFLX', '2019-09-10', 285.30, 282.10, 12400000);

-- ---- Quiz: Users -------------------------------------------
INSERT INTO users (us_name, us_email) VALUES ('John Doe', 'john@example.com');
INSERT INTO users (us_name, us_email) VALUES ('Jane Doe', 'jane@example.com');

-- ---- Quiz: Questions ----------------------------------------
INSERT INTO question (qu_text) VALUES ('What is Spring Boot?');
INSERT INTO question (qu_text) VALUES ('What is JPA?');

-- ---- Quiz: Options ------------------------------------------
INSERT INTO option (op_text, op_correct, op_qu_id) VALUES ('A framework', TRUE,  1);
INSERT INTO option (op_text, op_correct, op_qu_id) VALUES ('A database',  FALSE, 1);
INSERT INTO option (op_text, op_correct, op_qu_id) VALUES ('ORM spec',    TRUE,  2);
INSERT INTO option (op_text, op_correct, op_qu_id) VALUES ('A web server',FALSE, 2);

-- ---- Quiz: Attempts -----------------------------------------
INSERT INTO attempt (at_us_id, at_date) VALUES (1, '2024-01-10');

-- ---- Quiz: AttemptQuestions ---------------------------------
INSERT INTO attempt_question (aq_at_id, aq_qu_id) VALUES (1, 1);
INSERT INTO attempt_question (aq_at_id, aq_qu_id) VALUES (1, 2);

-- ---- Quiz: AttemptOptions -----------------------------------
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 1, TRUE);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 3, TRUE);
