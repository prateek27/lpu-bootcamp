SELECT * FROM LPUDB.students;

SET AUTOCOMMIT = 0;

UPDATE students 
SET studentName = "Mohit"
WHERE studentId = 1;

COMMIT;

SELECT * 
FROM students;


ROLLBACK;

SELECT * 
FROM students;


-- Left Transaction 
SHOW VARIABLES LIKE "transaction_isolation";
SET AUTOCOMMIT = 0;

UPDATE students 
SET studentName = "Rohit"
WHERE studentId = 1;

commit;

-- Left  Side 
SELECT * 
FROM students;

UPDATE students 
SET studentName = "Icecream"
WHERE studentId = 1;

commit;

BEGIN;
UPDATE students 
SET studentName = "MangoIcecream"
WHERE studentId = 1;

SELECT * 
FROM students;
COMMIT;

BEGIN;
UPDATE students 
SET studentName = "PinkIcecream"
WHERE studentId = 1;

COMMIT;

BEGIN;
SELECT * FROM students;
commit;


INSERT INTO students(studentId,studentName,batchId) VALUES
(6,"Naman",22);

-- Left Session 

BEGIN;
SELECT * FROM students ;


SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
SHOW VARIABLES LIKE "transaction_isolation";
BEGIN;
SELECT * 
FROM students 
WHERE studentId IN (2,3) FOR UPDATE;
commit;

BEGIN;
SELECT * 
FROM students 
WHERE studentId=2 FOR UPDATE;

SELECT * 
FROM students 
WHERE studentId=3 FOR UPDATE;








