# Dummy Data

### student table:

| id | name | email | created_at |
|---|---|---|---|
| 1 | Aarav Patel | aarav.patel@mail.com | 2024-01-10 09:00:00 |
| 2 | Divya Krishnan | divya.k@mail.com | 2024-01-15 10:30:00 |
| 3 | Rohan Gupta | rohan.gupta@mail.com | 2024-02-01 08:45:00 |
| 4 | Meera Iyer | meera.iyer@mail.com | 2024-02-14 11:00:00 |
| 5 | Karthik Reddy | karthik.r@mail.com | 2024-03-05 14:20:00 |
| 6 | Anya Singh | anya.singh@mail.com | 2024-03-18 09:15:00 |
| 7 | Nikhil Joshi | nikhil.joshi@mail.com | 2024-04-02 16:00:00 |
| 8 | Pooja Desai | pooja.desai@mail.com | 2024-04-20 13:30:00 |
| 9 | Siddharth Bose | siddharth.b@mail.com | 2024-05-07 10:00:00 |
| 10 | Lakshmi Menon | lakshmi.menon@mail.com | 2024-05-22 12:45:00 |

### student_profile table:

| id | bio | avatar_url | date_of_birth |
|---|---|---|---|
| 1 | "Aspiring backend developer learning Spring Boot." | "https://i.pravatar.cc/150?u=1" | |
| 2 | "Frontend enthusiast exploring full-stack development." | "https://i.pravatar.cc/150?u=2" | "1999-07-25" |
| 3 | "DevOps learner interested in cloud and containers." | "https://i.pravatar.cc/150?u=3" | "2001-01-08" |
| 4 | "Data science student with a love for SQL." | "https://i.pravatar.cc/150?u=4" | "2000-11-30" |
| 5 | "Self-taught programmer focusing on Java." | "https://i.pravatar.cc/150?u=5" | "1998-06-14" |
| 6 | "Computer science undergrad building side projects." | "https://i.pravatar.cc/150?u=6" | |
| 7 | "Preparing for software engineering interviews." | "https://i.pravatar.cc/150?u=7" | "2001-04-03" |
| 8 | "Freelance developer upskilling in modern Java." | "https://i.pravatar.cc/150?u=8" | "1997-12-22" |
| 9 | "Backend intern learning REST APIs and Spring." | "https://i.pravatar.cc/150?u=9" | "2003-02-17" |
| 10 | "Graduate student bridging theory and practice." | "https://i.pravatar.cc/150?u=10" | "1999-08-05" |

### instructor table:

| id | name | email | bio |
|---|---|---|---|
| 1 | Arjun Mehta | arjun.mehta@learnhub.io | Backend engineer with 10 years of Java and Spring experience. |
| 2 | Priya Nair | priya.nair@learnhub.io | Full-stack developer and open-source contributor. Loves React and Node. |
| 3 | Vikram Sharma | vikram.sharma@learnhub.io | |
| 4 | Sneha Rao | sneha.rao@learnhub.io | DevOps practitioner with expertise in Docker, Kubernetes, and CI/CD. |

### course table:

| id | title | description | price | level | created_at | instructor_id |
|---|---|---|---|---|---|---|
| 1 | Spring Boot from Scratch | Build production-ready REST APIs using Spring Boot and Spring Data JPA. | 1499.99 | BEGINNER | 2024-01-05 10:00:00 | 1 |
| 2 | Spring Security Masterclass | Secure your Spring applications with JWT, OAuth2, and method-level security. | 2499.00 | INTERMEDIATE | 2024-02-01 10:00:00 | 1 |
| 3 | Full-Stack with React and Spring | Connect a React frontend to a Spring Boot backend with REST and CORS. | 2999.00 | INTERMEDIATE | 2026-10-24 13:10:24.105642 | 2 |
| 4 | SQL and JPA Deep Dive | Master SQL, JPQL, Criteria API, and Specifications from the ground up. | 1999.00 | INTERMEDIATE | 2024-03-01 10:00:00 | 3 |
| 5 | Docker and Kubernetes for Developers | Containerise your Spring applications and deploy them on Kubernetes. | 3499.00 | ADVANCED | 2024-03-20 10:00:00 | 4 |
| 6 | Java Testing with JUnit and Mockito | Write unit tests, integration tests, and mocks for Spring Boot applications. | 999.00 | BEGINNER | 2024-04-10 10:00:00 | 1 |

### module table:

| id | title | order_index | course_id |
|---|---|---|---|
| 1 | Introduction to Spring Boot | 1 | 1 |
| 2 | Building REST Endpoints | 2 | 1 |
| 3 | Spring Data JPA Basics | 3 | 1 |
| 4 | Authentication with Spring Security | 1 | 2 |
| 5 | JWT Token Implementation | 2 | 2 |
| 6 | Method-Level Security | 3 | 2 |
| 7 | Setting Up React and Spring | 1 | 3 |
| 8 | REST API Integration | 2 | 3 |
| 9 | State Management and Forms | 3 | 3 |
| 10 | SQL Fundamentals | 1 | 4 |
| 11 | JPQL and Named Queries | 2 | 4 |
| 12 | Criteria API and Specifications | 3 | 4 |
| 13 | Docker Fundamentals | 1 | 5 |
| 14 | Dockerising Spring Boot Apps | 2 | 5 |
| 15 | Kubernetes Basics | 3 | 5 |
| 16 | JUnit 5 Basics | 1 | 6 |
| 17 | Mockito and Mocking | 2 | 6 |
| 18 | Integration Testing in Spring | 3 | 6 |

### assignment table:

| id | title | max_score | due_date | module_id |
|---|---|---|---|---|
| 1 | Hello World REST API | 100.00 | 2024-02-15 00:00:00 | 2 |
| 2 | JPA Entity Design | 100.00 | 2024-03-01 00:00:00 | 3 |
| 3 | Secure a REST Endpoint | 100.00 | 2024-03-20 00:00:00 | 4 |
| 4 | Implement JWT Login | 100.00 | 2024-04-05 00:00:00 | 5 |
| 5 | Apply @PreAuthorize | 100.00 | 2024-04-20 00:00:00 | 6 |
| 6 | React Component with API Call | 100.00 | 2024-04-01 00:00:00 | 8 |
| 7 | SQL Aggregation Queries | 100.00 | 2024-03-25 00:00:00 | 10 |
| 8 | Write JPQL Queries | 100.00 | 2024-04-10 00:00:00 | 11 |
| 9 | Specifications Filter | 100.00 | 2024-05-01 00:00:00 | 12 |
| 10 | Write a Dockerfile | 100.00 | 2024-05-05 00:00:00 | 14 |
| 11 | Deploy to Minikube | 100.00 | 2024-06-01 00:00:00 | 15 |
| 12 | Unit Test a Service Class | 100.00 | 2024-05-20 00:00:00 | 16 |
| 13 | Mock a Repository | 100.00 | 2024-06-05 00:00:00 | 17 |

### submission table:

| id | score | submitted_at | assignment_id | student_id |
|---|---|---|---|---|
| 1 | 88.00 | "2024-02-14 18:00:00" | 1 | 1 |
| 2 | 76.00 | "2024-03-01 20:00:00" | 2 | 1 |
| 3 | 91.00 | "2024-02-16 09:30:00" | 1 | 2 |
| 4 | 88.00 | "2024-03-25 15:00:00" | 7 | 4 |
| 5 | 88.00 | "2024-04-09 11:00:00" | 8 | 4 |
| 6 | 88.00 | "2024-04-30 22:00:00" | 9 | 4 |
| 7 | 88.00 | "2024-03-22 17:00:00" | 3 | 5 |
| 8 | 88.00 | "2024-04-06 14:00:00" | 4 | 5 |
| 9 | 88.00 | "2024-04-01 10:00:00" | 6 | 6 |
| 10 | 88.00 | "2024-05-08 19:00:00" | 8 | 7 |
| 11 | 88.00 | "2024-06-10 23:00:00" | 11 | 7 |
| 12 | 88.00 | "2026-10-24 13:10:24.698469" | 12 | 6 |
| 13 | 88.00 | "2024-06-06 20:00:00" | 13 | 6 |
| 14 | 88.00 | "2024-02-20 08:00:00" | 1 | 8 |
| 15 | 88.00 | "2024-04-20 17:30:00" | 3 | 8 |
| 16 | 88.00 | "2024-05-12 13:00:00" | 12 | 9 |
| 17 | 88.00 | "2024-04-08 21:00:00" | 8 | 10 |
| 18 | 88.00 | "2024-05-03 18:00:00" | 9 | 10 |

### enrollment table:

| "student_id" | "course_id" | "enrolled_at" | "status" |
|---|---|---|---|
| 1 | 1 | "2024-01-20 09:00:00" | "COMPLETED" |
| 1 | 2 | "2024-03-01 09:00:00" | "ACTIVE" |
| 1 | 6 | "2024-04-15 09:00:00" | "ACTIVE" |
| 2 | 1 | "2024-01-25 10:00:00" | "COMPLETED" |
| 2 | 3 | "2024-03-10 10:00:00" | "ACTIVE" |
| 3 | 5 | "2026-10-24 13:10:24.899494" | "ACTIVE" |
| 4 | 4 | "2024-03-05 11:00:00" | "COMPLETED" |
| 4 | 1 | "2024-01-30 11:00:00" | "COMPLETED" |
| 5 | 1 | "2024-02-10 14:00:00" | "DROPPED" |
| 5 | 2 | "2026-10-24 13:10:24.957744" | "ACTIVE" |
| 6 | 3 | "2024-04-01 09:00:00" | "ACTIVE" |
| 6 | 6 | "2024-05-01 09:00:00" | "ACTIVE" |
| 7 | 4 | "2024-03-20 16:00:00" | "ACTIVE" |
| 7 | 5 | "2024-04-10 16:00:00" | "ACTIVE" |
| 8 | 1 | "2024-02-20 13:00:00" | "COMPLETED" |
| 8 | 2 | "2024-04-01 13:00:00" | "ACTIVE" |
| 9 | 6 | "2024-05-10 10:00:00" | "ACTIVE" |
| 9 | 1 | "2024-02-28 10:00:00" | "ACTIVE" |
| 10 | 4 | "2024-04-05 12:00:00" | "ACTIVE" |
| 10 | 3 | "2024-05-01 12:00:00" | "ACTIVE" |

### tag table:

| id | name |
|---|---|
| 1 | Java |
| 2 | Spring Boot |
| 3 | Spring Security |
| 4 | JPA |
| 5 | SQL |
| 6 | REST API |
| 7 | DevOps |
| 8 | Docker |
| 9 | React |
| 10 | JavaScript |
| 11 | Databases |
| 12 | Testing |

### course_tag table:

| course_id | tag_id |
|---|---|
| 1 | 4 |
| 1 | 1 |
| 1 | 6 |
| 1 | 2 |
| 2 | 3 |
| 2 | 1 |
| 2 | 2 |
| 3 | 1 |
| 3 | 6 |
| 3 | 9 |
| 3 | 2 |
| 3 | 10 |
| 4 | 4 |
| 4 | 11 |
| 4 | 1 |
| 4 | 5 |
| 5 | 8 |
| 5 | 7 |
| 6 | 12 |
| 6 | 1 |
| 6 | 2 |
