-- List the employee name and the city where they live. (Join Employee and Address).
select e."name" , a.city  from employee e left join address a on e.address_id =a.address_id
-- List all departments and the names of the employees who belong to them. Include departments that may not currently have any employees.
select d.*, e."name" as "employee_name" from department d left join employee e on d.dept_id =e.dept_id
-- Find the employee name and the name of the projects they are working on
select e."name", p.project_name  from employee_project ep join employee e on ep.emp_id =e.emp_id join project p on p.project_id =ep.project_id