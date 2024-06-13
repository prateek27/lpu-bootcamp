SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SHOW VARIABLES LIKE "transaction_isolation";
SET AUTOCOMMIT = 0;


SELECT * 
FROM students;

COMMIT;


SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SELECT *
FROM students;
commit;

BEGIN;
SELECT * FROM students;
SELECT * FROM students;

commit;

BEGIN;
UPDATE students 
SET studentName = "YellowIcecream"
WHERE studentId = 1;


commit;
SET AUTOCOMMIT = 0;
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SELECT * FROM students;
commit;

BEGIN;
SELECT * 
FROM students;

UPDATE students 
SET studentName = CONCAT("S_",studentName);

SELECT * 
FROM students;
commit;


BEGIN;
SELECT * 
FROM students;

UPDATE students 
SET studentName = CONCAT("S_",studentName);
commit;

SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
BEGIN;
SELECT * 
FROM students 
WHERE studentId IN (3,4) FOR UPDATE;
commit;
-- 
BEGIN;
SELECT * 
FROM students 
WHERE studentId=3 FOR UPDATE;

SELECT * 
FROM students 
WHERE studentId=2 FOR UPDATE;


-- 15:49:05	SELECT *  FROM students  WHERE studentId=2 FOR UPDATE	Error Code: 1213. Deadlock found when trying to get lock; try restarting transaction	0.0029 sec







