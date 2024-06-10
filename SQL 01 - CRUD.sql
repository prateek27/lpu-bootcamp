CREATE DATABASE LPUDB;

-- Select the Database
USE LPUDB;

-- Batches 
CREATE TABLE batches(
	 batchId INT auto_increment,
     batchName VARCHAR(200),
     PRIMARY KEY(batchId)
);

-- Insert data into batches
INSERT INTO batches(batchId,batchName) VALUES
(1,"CP Batch"),
(2,"System Design"),
(3,"Mern Stack");

-- Read 
SELECT * 
FROM batches;

CREATE TABLE students(
	studentId INT,
	studentName VARCHAR(200),
    batchId INT,
    PRIMARY KEY(studentId),
    FOREIGN KEY(batchId) REFERENCES batches(batchId) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO students VALUES 
(1,"Rahul",2),
(2,"Ankit",1),
(3,"Priyanka",3),
(4,"Amit",2);

SELECT * 
FROM students;

-- can we try to update a batch id?
UPDATE batches 
SET batchId = 22
WHERE batchId = 2;

-- syntax for delete 
DELETE FROM batches
WHERE batchId = 22;
-- 
-- alter16:24:03	DELETE FROM batches WHERE batchId = 22	Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`lpudb`.`students`, CONSTRAINT `students_ibfk_1` FOREIGN KEY (`batchId`) REFERENCES `batches` (`batchId`) ON DELETE RESTRICT ON UPDATE CASCADE)	0.0079 sec
-- tryout : ON UPDATE SET NULL, ON DELETE CASCADE


CREATE INDEX studentNameIdx 
ON students(studentName);

DROP INDEX studentNameIdx
ON students;

-- 

EXPLAIN ANALYZE
SELECT * 
FROM students
WHERE studentName="Amit";

-- '-> Index lookup on students using studentNameIdx (studentName=\'Amit\')  (cost=0.35 rows=1) (actual time=0.0767..0.0797 rows=1 loops=1)\n'
USE LPUDB;

CREATE TABLE lpubatches(
	 batchId INT auto_increment,
     batchName VARCHAR(200),
     batchMode ENUM("online","offline") NOT NULL,
     PRIMARY KEY(batchId)
);

INSERT INTO lpubatches(batchName,batchMode) VALUES
("MLAI","online"),
("DSACP","offline");


-- 12:38:04	INSERT INTO lpubatches(batchName,batchMode) VALUES ("MLAI","online"), ("DSACP","offline"), ("DSA","hybrid")	Error Code: 1265. Data truncated for column 'batchMode' at row 3	0.0012 sec

SELECT *
FROM lpubatches;

-- READ Operations 
USE sakila;

SELECT title,rating
FROM film;

SELECT *
FROM film;

SELECT "HEllo",5;

SELECT 5*3;

SELECT ROUND(4/3,2);

SELECT title, rating, ROUND(length/60,2) AS "Duration"
FROM film;

SELECT DISTINCT rating
FROM film;

SELECT DISTINCT rating, release_year
FROM film;


SELECT DISTINCT rating, release_year,film_id
FROM film;

SELECT DISTINCT category_id 
FROM film_category;

SELECT * 
FROM category;

-- Filter out rows based upon certain condition 
SELECT * 
FROM film
WHERE release_year=2008;

-- filter out films with rating G,PG
SELECT *
FROM film 
WHERE rating='G' OR rating='PG';

-- filter out films with rating PG-13 
-- and duration >=100 minutes
SELECT * 
FROM film 
WHERE NOT (rating='PG-13' AND length>=100);

-- Not 
SELECT * 
FROM film 
WHERE NOT rating='PG-13' OR NOT length>=100;

-- find out films description is greater than 100 chars.
SELECT title 
FROM film 
WHERE LENGTH(description)>100;

SELECT LENGTH("Hello");

-- Films which having rating G,PG,PG-13
SELECT * 
FROM film 
WHERE rating='G' OR rating='PG' OR rating='PG-13';

SELECT * 
FROM film 
WHERE rating IN ('G','PG','PG-13');

-- Create a Table FilmMetadata (title,rating) of all films 
CREATE TABLE film_metadata(
	title VARCHAR(100),
    rating VARCHAR(10)
);

-- copying selected data into a new table 
INSERT INTO film_metadata
SELECT title,rating
FROM film
WHERE rating IN ('G',"PG","PG-13");


SELECT *
FROM film_metadata;

-- Todo:: Copy unique districts from "address" into a new table 
SELECT DISTINCT district
FROM address;


-- BETWEEN 
SELECT * 
FROM film
WHERE release_year>=2005 AND release_year<=2009;

-- between is inclusive of both start and end
SELECT * 
FROM film
WHERE release_year BETWEEN 2005 AND 2009;

-- like strings, datetime 
SELECT *
FROM film 
WHERE title BETWEEN "apple" and "mango";

-- find out film titles "lovely", "univ"
SELECT *
FROM film
WHERE title BETWEEN "lovely" and "univ";

-- LIKE Operator 
-- find out films where title ends with man 
SELECT * 
FROM film 
WHERE title LIKE "%man";

-- man as subtstring in the title 
SELECT * 
FROM film 
WHERE title LIKE "%man%";

-- any word in the title ends with man. 
-- batman vs cat
-- powers of hanuman and lord ram
-- cat vs batman
SELECT *
FROM film 
WHERE title LIKE "%man %" OR title LIKE "%man";

-- REGEXP 
SELECT * 
FROM film 
WHERE title REGEXP "^mind";

SELECT * 
FROM film 
WHERE title REGEXP "man$";


-- movies title like 3 instances of "bla"
SELECT * 
FROM film
WHERE title REGEXP "o{2}";

-- create a regex for 10 digit phone no 
-- phone no must have digits 
-- phone no should not begin 0 

-- ^[1-9][0-9]{9}$

-- IS NULL 
SELECT * 
FROM address
WHERE address2 IS NULL;

SELECT * 
FROM address
WHERE address2 IS NOT NULL;

-- ORDER BY 
SELECT *
FROM film 
ORDER BY title DESC;

-- More cols
SELECT title,rating
FROM film 
ORDER BY rating ASC,title DESC;

-- last 5 movies which were recently updated


-- rank movies according to duration 
SELECT title,length
FROM film
WHERE title LIKE "A%"
ORDER BY length
LIMIT 10;

-- 11 to 20
SELECT title,length
FROM film
WHERE title LIKE "A%"
ORDER BY length
LIMIT 10 OFFSET 10;

-- 21 to 45 
SELECT title,length
FROM film
WHERE title LIKE "A%"
ORDER BY length
LIMIT 25 OFFSET 20;

-- row 11 to 20 
(SELECT title,length
FROM film
WHERE title LIKE "A%"
ORDER BY length
LIMIT 10 OFFSET 10)
UNION
(SELECT title,length
FROM film
WHERE title LIKE "A%"
ORDER BY length
LIMIT 10 OFFSET 40);

-- C R U D 
UPDATE film 
SET rating='NC-17',
release_year = 2024
WHERE film_id = 2;

SELECT *
FROM film 
WHERE film_id = 2;

-- update the film title to "Batman" + original title 
-- wherever film contains the word man
-- ex : catmanfish 
-- output: batmancatmanfish 
UPDATE film
SET title = CONCAT("batman",title)
WHERE title LIKE "%man%";

UPDATE film
SET title = CONCAT("batman",title)
WHERE film_id IN (5,6,7);

SELECT * 
FROM film;

-- Alter Table 
USE LPUDB;

ALTER TABLE batches ADD instructor VARCHAR(200);

UPDATE batches
SET instructor = "Prateek"
WHERE batchId > 0;

SELECT * 
FROM batches;

-- Create an instructor table
-- delete the instructor col from batch table 
-- add the instructor id column as foreign key in the batch table






























