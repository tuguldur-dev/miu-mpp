-- Calculate the average salary of all employees
select AVG(e.salary ) as "Average Salary" from employee e
-- Find the maximum estimated_days for any single project.
select MAX(p.estimated_days ) from project p
-- For each department, report the dept_id and the total salary expenditure
select e.dept_id, SUM(e.salary ) from employee e group by e.dept_id
-- Find the dept_id of departments that have an average employee salary greater than $150,000.
select e.dept_id, AVG(e.salary) from employee e  group by e.dept_id having AVG(e.salary) > 150000