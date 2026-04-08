CREATE TABLE Employee (
                          emp_id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          salary int NOT NULL,
                          address_id int4 NOT NULL,
                          dept_id int4 NOT NULL NULL;
)

CREATE TABLE Address (
                         address_id SERIAL PRIMARY KEY,
                         city VARCHAR(100) NOT NULL,
                         state VARCHAR(100) NOT NULL,
                         zipcode int NOT NULL
)

CREATE TABLE Department (
                            dept_id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT null
)

CREATE TABLE Project (
                         project_id SERIAL PRIMARY KEY,
                         project_name VARCHAR(100) NOT null,
                         estimated_days int NOT null,
                         location VARCHAR(100) NOT null
)

CREATE TABLE public.employee_project (
                     emp_id int4 NULL,
                     project_id int4 NULL
);



ALTER TABLE public.employee ADD CONSTRAINT employee_address_fk FOREIGN KEY (address_id) REFERENCES public.address(address_id);
ALTER TABLE public.employee ADD CONSTRAINT employee_department_fk FOREIGN KEY (dept_id) REFERENCES public.department(dept_id);
ALTER TABLE public.employee_project ADD CONSTRAINT employee_project_employee_fk FOREIGN KEY (emp_id) REFERENCES public.employee(emp_id);
ALTER TABLE public.employee_project ADD CONSTRAINT employee_project_project_fk FOREIGN KEY (project_id) REFERENCES public.project(project_id);

