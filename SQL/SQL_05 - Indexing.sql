DROP INDEX studentNameIdx 
ON students;

CREATE INDEX idx_studentName 
ON students(studentName);

-- Read students
EXPLAIN 
SELECT *
FROM students
WHERE studentName = "S_Mohit";
-- '-> Filter: (students.studentName = \'S_Mohit\')  (cost=0.85 rows=1) (actual time=0.0752..0.0822 rows=1 loops=1)\n    -> Table scan on students  (cost=0.85 rows=6) (actual time=0.0579..0.0675 rows=6 loops=1)\n'

-- Read students
EXPLAIN ANALYZE
SELECT *
FROM students
WHERE studentName = "S_Mohit";
-- Index lookup on students using idx_studentName (studentName='S_Mohit')  (cost=0.35 rows=1) (actual time=0.0861..0.0905 rows=1 loops=1)

EXPLAIN 
SELECT *
FROM students
JOIN batches
USING (batchId);

-- film title 

-- 25 nodes, approx 40 rows per node 
SELECT DISTINCT SUBSTR(title,1,1)
FROM film;

-- 613 nodes, approx 2 rows per node 
SELECT DISTINCT SUBSTR(title,1,3)
FROM film;

-- 951 nodes, approx 1 rows per node 
SELECT DISTINCT SUBSTR(title,1,6)
FROM film;

--  987 nodes -- approx 1 record per node
SELECT DISTINCT SUBSTR(title,1,8)
FROM film;


-- Full text index  
SELECT * 
FROM film;

CREATE FULLTEXT INDEX idx_film_title_description 
ON film(title,description);

SELECT *
FROM film
WHERE MATCH(title,description) AGAINST ("machine learning database robot");

-- '113', 'CALIFORNIA BIRDS', 'A Thrilling Yarn of a Database Administrator And a Robot who must Battle a Database Administrator in Ancient India', 2006, '1', NULL, '4', '4.99', '75', '19.99', 'NC-17', 'Trailers,Commentaries,Deleted Scenes', '2006-02-15 05:03:42'



