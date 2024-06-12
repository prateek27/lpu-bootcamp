-- Joins 

SELECT * 
FROM batches;

SELECT * 
FROM students
JOIN batches
ON students.batchId = batches.batchId;


SELECT * 
FROM students
JOIN batches
ON students.batchId = batches.batchId
WHERE studentName = "Rahul";
-- you are create intermediate table
-- you are filtering 
SELECT * 
FROM students
JOIN batches
ON students.batchId = batches.batchId
WHERE studentName = "Rahul";

EXPLAIN ANALYZE
SELECT * 
FROM students
JOIN batches
ON students.batchId = batches.batchId 
AND students.studentName = "Rahul";

-- Find out all student enrolled in system design
SELECT s.*, batchName, instructor
FROM students s
JOIN batches b
ON s.batchId = b.batchId 
AND b.batchName = "System Design";

SELECT s.*, batchName, instructor
FROM students s
JOIN batches b
ON s.batchId = b.batchId;

-- SELF-JOIN 
USE classicmodels;

SELECT * 
FROM employees;

-- inner join
SELECT emp.employeeNumber, emp.firstName,  mgr.firstName AS "Manager name"
FROM employees emp
JOIN employees mgr
ON emp.reportsTo = mgr.employeeNumber;

SELECT emp.employeeNumber, emp.firstName,  mgr.firstName AS "Manager name" 
FROM employees mgr
JOIN employees emp
ON emp.reportsTo = mgr.employeeNumber;
-- ON emp.employeeNumber = mgr.reportsTo


-- left join
SELECT * 
FROM employees emp
LEFT JOIN employees mgr
ON emp.reportsTo = mgr.employeeNumber;

-- Syntactic Sugars 
-- if you have two tables with same colm name

SELECT s.batchId
FROM students s
JOIN batches b
ON s.batchId = b.batchId;

SELECT *
FROM students s
JOIN batches b
USING (batchId);

-- Natural Join 
-- based upon equality of all colms that have same name
-- T1 (a,b,c) 
-- T2 (d,b,e,c) 

SELECT * 
FROM students 
NATURAL JOIN batches;

-- CROSS JOIN
SELECT * 
FROM students
JOIN batches;

-- Implicit Join (Cross join without using the join keyword)
SELECT * 
FROM students,batches;

-- Implicit Join + Where 
-- avoid because intermediate table is very big 
-- because cross join + filtering 
SELECT * 
FROM students s,batches b
WHERE s.batchId = b.batchId;

-- more efficient
SELECT * 
FROM students s
JOIN batches b
USING(batchId);

-- Query 1: You have to find all the films that were released
-- within -+2 years from a given film and their rental rate was more than or equal
-- rental of selected film 
SELECT * 
FROM film f1 
JOIN film f2 
ON f2.release_year BETWEEN f1.release_year - 2 AND f1.release_year + 2 
AND f2.rental_rate >= f1.rental_rate AND f2.film_id!=f1.film_id;

-- Aggregate Queries 
-- COUNT(), SUM(), AVG(), MAX(), MIN()

SELECT COUNT(batchId)
FROM students;

SELECT COUNT(studentId)
FROM students;

SELECT COUNT(*) AS totalStudents
FROM students;

SELECT SUM(length)
FROM sakila.film;

-- 13:23:04	SELECT SUM(length),title FROM sakila.film	Error Code: 1140. In aggregated query without GROUP BY, expression #2 of SELECT list contains nonaggregated column 'sakila.film.title'; this is incompatible with sql_mode=only_full_group_by	0.00047 sec

SELECT SUM(length),SUM(LENGTH(title))
FROM sakila.film;

SELECT AVG(length), MAX(length), MIN(length)
FROM sakila.film;

-- Find the 3rd highest movie length 
-- Bonus: Print all the movies with that length
SELECT * 
FROM film 
WHERE length = (SELECT DISTINCT length 
FROM film 
ORDER BY length DESC
LIMIT 1 OFFSET 2);


-- GROUP BY 

SELECT COUNT(*),batchId,batchName
FROM students
JOIN batches
USING (batchId)
GROUP BY batchId;

SELECT * 
FROM students;

-- Sakila Film: Find out number of films for each type of rating (G, PG...)
-- Saikla: Find out total number of rentals made by each customer.
-- Find out the average rental for each release year 

SELECT COUNT(*),rating
FROM film
GROUP BY rating;

SELECT AVG(rental_rate),release_year
FROM film
GROUP BY release_year;

SELECT COUNT(*) AS TotalOrders,customer_id,CONCAT(c.first_name," ",c.last_name)
FROM rental
JOIN customer c
USING (customer_id)
GROUP BY customer_id;

-- Find out customers who have made atleast 30 rentals
SELECT COUNT(*) AS TotalOrders,rental_id,customer_id,CONCAT(c.first_name," ",c.last_name)
FROM rental
JOIN customer c
USING (customer_id)
WHERE c.first_name LIKE "A%"
GROUP BY customer_id
HAVING TotalOrders>=30
ORDER BY TotalOrders
LIMIT 3;


-- Query: find all pairs of actors who have done atleast 2 films together
SELECT COUNT(*) AS filmsTogether, a1.actor_id,a2.actor_id
FROM film_actor a1
JOIN film_actor a2 
ON a1.film_id = a2.film_id AND 
a1.actor_id < a2.actor_id
GROUP BY a1.actor_id,a2.actor_id
HAVING filmsTogether>=2
ORDER BY filmsTogether DESC
LIMIT 3;

-- Retrieve the total revenue earned by each film category 
-- but include categories where the revenue is atleast 1000$ 
-- ordre the categories based upon revenue 
-- Goal : Payment ---> Film Category 

SELECT SUM(amount) as Revenue,c.category_id, c.name
FROM payment
JOIN rental 
using (rental_id) 
JOIN inventory
USING (inventory_id)
JOIN film_category 
USING (film_id)
JOIN category c 
USING (category_id)
GROUP BY category_id
HAVING Revenue >=1000
ORDER BY Revenue DESC;

-- Revenue of Drama Category 
SELECT SUM(amount) as Revenue
FROM payment
JOIN rental 
using (rental_id) 
JOIN inventory
USING (inventory_id)
JOIN film_category 
USING (film_id)
JOIN category c 
USING (category_id)
WHERE c.name = "Drama";

-- filter out categories with revenue higher than drama revenue 
SELECT SUM(amount) as Revenue,c.category_id, c.name
FROM payment
JOIN rental 
using (rental_id) 
JOIN inventory
USING (inventory_id)
JOIN film_category 
USING (film_id)
JOIN category c 
USING (category_id)
GROUP BY category_id
HAVING Revenue >=
	(SELECT SUM(amount) as Revenue
	FROM payment
	JOIN rental 
	using (rental_id) 
	JOIN inventory
	USING (inventory_id)
	JOIN film_category 
	USING (film_id)
	JOIN category c 
	USING (category_id)
	WHERE c.name = "Drama");











CREATE VIEW category_revenue AS
SELECT SUM(amount) as Revenue,c.category_id, c.name
FROM payment
JOIN rental 
using (rental_id) 
JOIN inventory
USING (inventory_id)
JOIN film_category 
USING (film_id)
JOIN category c 
USING (category_id)
GROUP BY category_id;

-- simplified using a view 
SELECT * 
FROM category_revenue 
HAVING Revenue >=
	(SELECT revenue
	FROM category_revenue
	WHERE name = "Drama");
    
-- From the film table, find out all the ratings categories where average rental of films of that rating 
-- was more than the global average rental.

SELECT AVG(rental_rate) AS avgRental,rating 
FROM film
GROUP BY rating
HAVING avgRental > (SELECT AVG(rental_rate) 
FROM film);

-- 
SELECT *
FROM students 
WHERE marks > 	
	(SELECT MAX(marks) 
		FROM 
        (SELECT MIN(marks)
		FROM students 
		GROUP BY batchId) minPspTable
	);

-- simplified syntax using ALL
SELECT * 
FROM students
WHERE marks > ALL(
		SELECT MIN(marks)
		FROM students 
		GROUP BY batchId);

-- EXISTS 



















