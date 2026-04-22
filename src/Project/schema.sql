-- EEMS Database Schema
-- Run this script to create all tables and populate with sample data.

DROP TABLE IF EXISTS project_client CASCADE;
DROP TABLE IF EXISTS department_project CASCADE;
DROP TABLE IF EXISTS employee_project CASCADE;
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS project CASCADE;
DROP TABLE IF EXISTS department CASCADE;

-- Core tables

CREATE TABLE department (
    department_id SERIAL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    location      VARCHAR(100) NOT NULL,
    budget        NUMERIC(15, 2) NOT NULL CHECK (budget >= 0)
);

CREATE TABLE employee (
    employee_id   SERIAL PRIMARY KEY,
    full_name     VARCHAR(150) NOT NULL,
    title         VARCHAR(100) NOT NULL,
    hire_date     DATE NOT NULL,
    salary        NUMERIC(12, 2) NOT NULL CHECK (salary >= 0),
    department_id INT NOT NULL REFERENCES department(department_id)
);

CREATE TABLE project (
    project_id  SERIAL PRIMARY KEY,
    name        VARCHAR(150) NOT NULL,
    description TEXT,
    start_date  DATE NOT NULL,
    end_date    DATE NOT NULL,
    budget      NUMERIC(15, 2) NOT NULL CHECK (budget >= 0),
    status      VARCHAR(50) NOT NULL DEFAULT 'Active' CHECK (status IN ('Active', 'Completed', 'On Hold', 'Cancelled')),
    CHECK (end_date > start_date)
);

CREATE TABLE client (
    client_id     SERIAL PRIMARY KEY,
    name          VARCHAR(150) NOT NULL,
    industry      VARCHAR(100) NOT NULL,
    contact_name  VARCHAR(150) NOT NULL,
    contact_phone VARCHAR(30),
    contact_email VARCHAR(200)
);

-- Junction tables (Many-to-Many)

CREATE TABLE employee_project (
    employee_id    INT NOT NULL REFERENCES employee(employee_id) ON DELETE CASCADE,
    project_id     INT NOT NULL REFERENCES project(project_id) ON DELETE CASCADE,
    allocation_pct NUMERIC(5, 2) NOT NULL CHECK (allocation_pct > 0 AND allocation_pct <= 100),
    PRIMARY KEY (employee_id, project_id)
);

CREATE TABLE department_project (
    department_id INT NOT NULL REFERENCES department(department_id) ON DELETE CASCADE,
    project_id    INT NOT NULL REFERENCES project(project_id) ON DELETE CASCADE,
    PRIMARY KEY (department_id, project_id)
);

CREATE TABLE project_client (
    project_id INT NOT NULL REFERENCES project(project_id) ON DELETE CASCADE,
    client_id  INT NOT NULL REFERENCES client(client_id) ON DELETE CASCADE,
    PRIMARY KEY (project_id, client_id)
);

-- ============================================================
-- Sample Data (5 rows per table)
-- ============================================================

INSERT INTO department (name, location, budget) VALUES
    ('Engineering',       'Building A',   750000.00),
    ('Marketing',         'Building B',   300000.00),
    ('Human Resources',   'Building C',   200000.00),
    ('Finance',           'Building D',   400000.00),
    ('Product Management','Building A',   350000.00);

INSERT INTO employee (full_name, title, hire_date, salary, department_id) VALUES
    ('Alice Johnson',  'Senior Engineer',    '2019-03-10', 110000.00, 1),
    ('Bob Martinez',   'Marketing Manager',  '2020-07-01', 90000.00,  2),
    ('Carol White',    'HR Specialist',      '2021-01-15', 72000.00,  3),
    ('David Lee',      'Financial Analyst',  '2018-11-20', 85000.00,  4),
    ('Eva Chen',       'Product Manager',    '2022-05-03', 105000.00, 5);

INSERT INTO project (name, description, start_date, end_date, budget, status) VALUES
    ('Platform Rewrite',    'Full backend modernization',       '2024-01-01', '2024-09-30', 500000.00, 'Completed'),
    ('Mobile App Launch',   'iOS and Android app release',      '2025-02-01', '2025-08-31', 300000.00, 'Active'),
    ('Data Pipeline',       'ETL pipeline for analytics',       '2025-03-01', '2025-12-31', 200000.00, 'Active'),
    ('HR Portal Upgrade',   'Self-service HR portal redesign',  '2025-01-15', '2025-06-30', 120000.00, 'Active'),
    ('Budget Forecasting',  'Automated annual budget tool',     '2025-04-01', '2026-01-31', 180000.00, 'Active');

INSERT INTO client (name, industry, contact_name, contact_phone, contact_email) VALUES
    ('Acme Corp',       'Technology',   'James Brown',   '555-0101', 'james@acme.com'),
    ('Global Finance',  'Finance',      'Laura Torres',  '555-0202', 'laura@globalfin.com'),
    ('MediCare Ltd',    'Healthcare',   'Samuel Green',  '555-0303', 'samuel@medicare.com'),
    ('Retail Giant',    'Retail',       'Nina Patel',    '555-0404', 'nina@retailgiant.com'),
    ('EduSoft Inc',     'Education',    'Omar Khalid',   '555-0505', 'omar@edusoft.com');

INSERT INTO employee_project (employee_id, project_id, allocation_pct) VALUES
    (1, 2, 80.00),
    (1, 3, 20.00),
    (2, 2, 50.00),
    (4, 5, 60.00),
    (5, 4, 100.00);

INSERT INTO department_project (department_id, project_id) VALUES
    (1, 2),
    (1, 3),
    (2, 2),
    (3, 4),
    (4, 5);

INSERT INTO project_client (project_id, client_id) VALUES
    (2, 1),
    (2, 4),
    (3, 2),
    (4, 3),
    (5, 5);
