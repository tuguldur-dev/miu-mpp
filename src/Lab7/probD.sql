-- Find the name of the employee who has the highest salary (Use a subquery in the WHERE clause).
SELECT e."name" FROM employee e WHERE e.salary = (SELECT MAX(e1.salary) FROM employee e1);
-- List the names of employees who work on a project that has an estimated_days of 180 (Use an IN or EXISTS subquery)
select e."name"  from employee e where e.emp_id in ( select ep.emp_id  from employee_project ep join project p on ep.project_id =p.project_id  where p.estimated_days =180 )
-- Find the project_id of all projects that have an estimated duration greater than the average estimated duration of all projects (Use a subquery in the WHERE clause)
select p.project_id  from project p where p.estimated_days > (select AVG(p2.estimated_days )  from project p2 )