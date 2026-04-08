-- Creating a Database View
create view EmployeeDetails as select e.emp_id, e."name" as "employee_name", e.salary, d."name" as "dept_name" , p.project_name  from employee_project ep join employee e on ep.emp_id =e.emp_id join project p on p.project_id =ep.project_id left join department d on e.dept_id =d.dept_id


