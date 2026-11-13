

\# Employee Management System





\## Project Overview



The Employee Management System is a full-stack web application developed to manage employee and department information.



The application provides a user-friendly interface where users can register, log in, view employee details, search employees, and perform employee management operations.



The frontend is developed using React.js, while the backend is developed using Java Spring Boot. MySQL is used as the database.









\## Technologies Used



\### Frontend

\- React.js

\- JavaScript

\- HTML5

\- CSS3

\- Axios

\- Vite



\### Backend

\- Java 17

\- Spring Boot

\- Spring Security

\- Spring Data JPA

\- Hibernate

\- JWT Authentication

\- Maven



\### Database

\- MySQL



\### Development Tools

\- IntelliJ IDEA

\- Visual Studio Code

\- MySQL Workbench

\- Postman

\- Git and GitHub









\## Features



\### Authentication and Security

\- User Registration

\- User Login

\- JWT-based Authentication

\- Password Encryption using BCrypt

\- Protected REST APIs

\- Automatic Logout when an expired JWT is detected







\### Employee Management

\- View All Employees

\- Search Employee by ID

\- Department-wise Employee Search

\- Delete Employee

\- Add Employee

\- Employee Count Dashboard



\### Dashboard

\- Total Employee Count

\- Total Department Count



\### Frontend

\- Responsive Login and Registration Pages

\- Sidebar Navigation

\- Profile Dropdown

\- Logout Functionality

\- API Integration using Axios







\## Project Structure



Employee-Management-System/

│

├── Backend/

│   └── EmployeeApi/

│       ├── src/

│       ├── pom.xml

│       └── ...

│

└── Frontend/

&#x20;   └── EmployeeFrontend/

&#x20;       ├── src/

&#x20;       ├── public/

&#x20;       ├── package.json

&#x20;       └── ...



\## Installation and Setup



\### 1. Clone the Repository





git bash clone YOUR\_GITHUB\_REPOSITORY\_URL





\### 2. Backend Setup



\- Open the backend project in IntelliJ IDEA.

\- Configure MySQL database credentials in application.properties.

\- Create the required MySQL database.

\- Run the Spring Boot application.



Backend runs at:





http://localhost:8080





\### 3. Frontend Setup



Open the frontend project in VS Code.



Install dependencies:



npm install





Start the React application:





npm run dev





Frontend runs at:





http://localhost:5173



\## API Endpoints



| Method | Endpoint | Description |

|---|---|---|

| POST | /users/api/registerUsers | Register User |

| POST | /users/api/login | User Login |

| GET | /Employee/api/GetAll | Get All Employees |

| GET | /Employee/api/getById/{id} | Get Employee by ID |

| GET | /Employee/api/getByDeptName?name=... | Get Employees by Department |

| POST | /Employee/api/add | Add Employee |

| DELETE | /Employee/api/deleteByEmpId/{Id} | Delete Employee |

| GET | /Employee/api/totalCountEmp | Total Employee Count |

| GET | /Employee/api/totalCountDept | Total Department Count |









\## Security



\- Spring Security is used to secure backend APIs.

\- JWT tokens are generated after successful authentication.

\- Passwords are encrypted using BCrypt.

\- Axios automatically attaches JWT tokens to API requests.

\- Expired or invalid tokens trigger automatic logout.





\## Future Enhancements



\- Update Employee functionality

\- Pagination and Sorting

\- Advanced Search and Filtering

\- Improved Form Validation

\- Role-Based Access Control





\## Author



Developed as a Full Stack Development Project.



\## License



This project is developed for educational and learning purposes.



