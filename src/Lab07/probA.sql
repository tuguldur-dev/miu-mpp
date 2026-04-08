-- List the name and salary of all employees.
select name, salary from employee e;
-- Find the names of all projects located in Florida (FL)
select p.project_name  from project p where p."location" ='FL';
-- Retrieve the emp_id and project_id for employees working on Project 1.
select * from employee_project ep where ep.project_id =1;
-- Find all unique (distinct) states where employee addresses are located.
select DISTINCT a.state  from address a where a.address_id in (select e.address_id  from employee e )
-- List the names and salaries of all employees who earn a salary less than $150,000.
select e.name, e.salary  from employee e where e.salary < 150000
-- List the project names and their estimated days, ordered from the longest duration to the shortest.
select p.project_name, p.estimated_days  from project p order by p.estimated_days desc
-- Find the emp_ids of employees who are assigned to a project, listing each emp_id only once
select e.emp_id  from employee e where e.emp_id in (select ep.emp_id  from employee_project ep )