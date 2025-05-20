**Runverve User Metrics API**:
🔹 Project Overview
This backend project manages health and fitness metrics using sample data imported from Strava. It provides a secure REST API for storing, retrieving, updating, and deleting user metrics such as hydration, fatigue, posture, heart rate, steps, calories burned, sleep data, and more.

Built with Java 17, Spring Boot, JWT Authentication, Spring Data JPA, and MySQL for persistent storage.


📌 Features
User registration and login with JWT authentication

Role-based access control (USER and ADMIN roles)

CRUD operations on user health metrics

Secure token-based authorization on protected endpoints

Sample data based on Strava for demonstration and testing

Swagger UI and Postman collection for API documentation and testing


**Swagger UI:
![image](https://github.com/user-attachments/assets/f297916f-7218-4a58-9aac-a7608065158d)

**Postman Collections:
![image](https://github.com/user-attachments/assets/50e76de6-3dac-4fb7-aa60-93bf4dc50ff1)

**DB diagram:
![image](https://github.com/user-attachments/assets/a7e3475c-1c34-4a6f-91cc-bd2fc12cffe3)




🚀 Tech Stack
Language: Java 17

Framework: Spring Boot

Security: Spring Security + JWT Authentication

Persistence: Spring Data JPA + MySQL

Documentation: Swagger UI

Testing: Postman Collection


📁 Project Structure
![image](https://github.com/user-attachments/assets/2bcf23bf-4140-4ae7-bc07-14d64576bb88)




🔐 Authentication Flow
Users register or login to receive a JWT token.

The JWT token must be sent in the Authorization header for all secured API requests:
Authorization: Bearer <JWT_TOKEN>



🔗 API Endpoints
Method	Endpoint	Access	Description
POST	/api/auth/register	Public	Register a new user
POST	/api/auth/login	Public	Login and receive JWT token
POST	/api/metrics/addmetric	User/Admin	Add a new user metric
GET	/api/metrics/{userId}	User/Admin	Retrieve metrics by user ID
GET	/api/metrics/by-user-and-date	User/Admin	Retrieve metrics filtered by user ID and date
PUT	/api/metrics/update/{id}	User/Admin	Update a metric by its ID
DELETE	/api/metrics/remove/{id}	User/Admin	Delete a metric by its ID
GET	/api/metrics	Admin Only	Retrieve all users’ metrics




👥 Roles and Permissions
USER: Can add, view, update, and delete their own metrics.

ADMIN: Can view and manage all users’ metrics.

Both users and admins must provide valid JWT tokens to perform update and delete operations.



🛠️ Setup Instructions
1.Clone the repository
![image](https://github.com/user-attachments/assets/05c936af-b8c9-4f5a-8741-00d89f3a6841)

2.Configure Database
Update src/main/resources/application.properties with your MySQL credentials:
![image](https://github.com/user-attachments/assets/fc3551c2-8c36-4064-b06c-ebf7938eb7df)

3.Run the application
![image](https://github.com/user-attachments/assets/decf9305-2481-40a5-b211-1ebeb66982a7)

4.Access Swagger UI
Open the API documentation in your browser:
![image](https://github.com/user-attachments/assets/33d2824a-ec5f-4803-b8dd-3fe7f221566e)


5.Import Postman Collection

Use the provided Postman collection in the repository to test all API endpoints easily.



















