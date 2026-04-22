## 1. UML Class Diagram

```mermaid
classDiagram
    class Department {
        +int departmentId
        +String name
        +String location
        +double budget
        +getDepartmentId() int
        +getName() String
        +getLocation() String
        +getBudget() double
        +setDepartmentId(id: int) void
        +setName(n: String) void
        +setLocation(l: String) void
        +setBudget(b: double) void
    }

    class Employee {
        +int employeeId
        +String fullName
        +String title
        +LocalDate hireDate
        +double salary
        +int departmentId
        +getEmployeeId() int
        +getFullName() String
        +getTitle() String
        +getHireDate() LocalDate
        +getSalary() double
        +getDepartmentId() int
        +setEmployeeId(id: int) void
        +setFullName(n: String) void
        +setTitle(t: String) void
        +setHireDate(d: LocalDate) void
        +setSalary(s: double) void
        +setDepartmentId(id: int) void
    }

    class Project {
        +int projectId
        +String name
        +String description
        +LocalDate startDate
        +LocalDate endDate
        +double budget
        +String status
        +getProjectId() int
        +getName() String
        +getDescription() String
        +getStartDate() LocalDate
        +getEndDate() LocalDate
        +getBudget() double
        +getStatus() String
        +setProjectId(id: int) void
        +setName(n: String) void
        +setDescription(d: String) void
        +setStartDate(d: LocalDate) void
        +setEndDate(d: LocalDate) void
        +setBudget(b: double) void
        +setStatus(s: String) void
    }

    class Client {
        +int clientId
        +String name
        +String industry
        +String contactName
        +String contactPhone
        +String contactEmail
        +getClientId() int
        +getName() String
        +getIndustry() String
        +getContactName() String
        +getContactPhone() String
        +getContactEmail() String
        +setClientId(id: int) void
        +setName(n: String) void
        +setIndustry(i: String) void
        +setContactName(n: String) void
        +setContactPhone(p: String) void
        +setContactEmail(e: String) void
    }

    class EmployeeProject {
        +int employeeId
        +int projectId
        +double allocationPct
        +getEmployeeId() int
        +getProjectId() int
        +getAllocationPct() double
        +setEmployeeId(id: int) void
        +setProjectId(id: int) void
        +setAllocationPct(pct: double) void
    }

    class DepartmentProject {
        +int departmentId
        +int projectId
        +getDepartmentId() int
        +getProjectId() int
        +setDepartmentId(id: int) void
        +setProjectId(id: int) void
    }

    class ProjectClient {
        +int projectId
        +int clientId
        +getProjectId() int
        +getClientId() int
        +setProjectId(id: int) void
        +setClientId(id: int) void
    }

    Department "1" --> "0..*" Employee : employs
    Department "1" --> "0..*" DepartmentProject : hosts
    Project "1" --> "0..*" DepartmentProject : belongs to
    Employee "1" --> "0..*" EmployeeProject : assigned to
    Project "1" --> "0..*" EmployeeProject : has
    Project "1" --> "0..*" ProjectClient : linked to
    Client "1" --> "0..*" ProjectClient : sponsors
```

---

## 2. Use Case Diagram

```mermaid
flowchart LR
    Actor(["Admin User"])

    subgraph EEMS["EEMS System"]
        subgraph Departments["Manage Departments"]
            UC1(Create Department)
            UC2(Read Department)
            UC3(Update Department)
            UC4(Delete Department)
        end

        subgraph Employees["Manage Employees"]
            UC5(Create Employee)
            UC6(Read Employee)
            UC7(Update Employee)
            UC8(Delete Employee)
            UC9(Transfer Employee to Department)
        end

        subgraph Projects["Manage Projects"]
            UC10(Create Project)
            UC11(Read Project)
            UC12(Update Project)
            UC13(Delete Project)
            UC14(Calculate Project HR Cost)
            UC15(Get Active Projects by Department)
        end

        subgraph Clients["Manage Clients"]
            UC16(Create Client)
            UC17(Read Client)
            UC18(Update Client)
            UC19(Delete Client)
            UC20(Find Clients by Upcoming Deadline)
        end

        subgraph Assignments["Manage Assignments"]
            UC21(Assign Employee to Project)
            UC22(Assign Department to Project)
            UC23(Link Client to Project)
        end
    end

    Actor --> UC1 & UC2 & UC3 & UC4
    Actor --> UC5 & UC6 & UC7 & UC8 & UC9
    Actor --> UC10 & UC11 & UC12 & UC13 & UC14 & UC15
    Actor --> UC16 & UC17 & UC18 & UC19 & UC20
    Actor --> UC21 & UC22 & UC23
```

---

## 3. Sequence Diagram 

```mermaid
sequenceDiagram
    participant Main
    participant ProjectController
    participant ProjectService
    participant ProjectRepository
    participant EmployeeProjectRepository
    participant EmployeeRepository
    participant DB as PostgreSQL DB

    Main->>ProjectController: calculateHRCost(projectId)
    ProjectController->>ProjectService: calculateProjectHRCost(projectId)

    ProjectService->>ProjectRepository: findById(projectId)
    ProjectRepository->>DB: SELECT * FROM project WHERE project_id = ?
    DB-->>ProjectRepository: ResultSet (project row)
    ProjectRepository-->>ProjectService: Project (startDate, endDate)

    ProjectService->>ProjectService: months = ceil(days / 30.0)

    ProjectService->>EmployeeProjectRepository: findByProjectId(projectId)
    EmployeeProjectRepository->>DB: SELECT * FROM employee_project WHERE project_id = ?
    DB-->>EmployeeProjectRepository: ResultSet (employee_id, allocation_pct rows)
    EmployeeProjectRepository-->>ProjectService: List<EmployeeProject>

    loop For each EmployeeProject
        ProjectService->>EmployeeRepository: findById(employeeId)
        EmployeeRepository->>DB: SELECT * FROM employee WHERE employee_id = ?
        DB-->>EmployeeRepository: ResultSet (employee row)
        EmployeeRepository-->>ProjectService: Employee (salary)
        ProjectService->>ProjectService: cost += (salary/12) * months * (allocationPct/100)
    end

    ProjectService-->>ProjectController: totalCost (double)
    ProjectController->>Main: prints and returns totalCost
```

---

## 4. Database Schema

### Tables Overview

| Table | Type | Description |
|---|---|---|
| `department` | Core | Organizational units |
| `employee` | Core | Workforce members (FK → department) |
| `project` | Core | Operational tasks |
| `client` | Core | External sponsors |
| `employee_project` | Junction (M:M) | Employee ↔ Project with allocation % |
| `department_project` | Junction (M:M) | Department ↔ Project hosting |
| `project_client` | Junction (M:M) | Project ↔ Client sponsorship |

---
