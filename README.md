🌟 Runverve User Metrics API
🔹 Project Overview
This backend project powers a health & fitness tracking system using sample Strava-like data. It provides a secure REST API for managing user metrics like:

💧 Hydration, 💤 Sleep, ❤️ Heart rate, 🦶 Steps, 🔥 Calories, 🧍 Posture, and more...

Built with:
☕ Java 17 • ⚙️ Spring Boot • 🔐 JWT Auth • 🗃️ Spring Data JPA • 🐬 MySQL

📌 Key Features
✅ User Registration & Login (JWT based)
✅ Role-based Access Control (USER, ADMIN)
✅ Full CRUD for health metrics
✅ Token-secured API endpoints
✅ Swagger UI & Postman Collection for easy testing
✅ Sample data modeled after Strava

🧪 API Documentation
🔹 Swagger UI
Easily test and explore APIs through your browser.
![Screenshot 2025-05-20 180625](https://github.com/user-attachments/assets/bebde035-5e46-44e3-b11d-a4d28479b66b)



🔹 Postman Collection
Import into Postman for instant testing!
![Screenshot 2025-05-20 173141](https://github.com/user-attachments/assets/11b6ce69-e410-4ff1-ae7a-9bd173cd58dc)



🗂️ Database Design
Visual representation of the database schema.
![Screenshot 2025-05-20 173723](https://github.com/user-attachments/assets/9340c250-33bb-4669-87be-bbc8ba84d20f)



🚀 Tech Stack
Language: Java 17

Framework: Spring Boot

Security: Spring Security + JWT

Database: MySQL

ORM: Spring Data JPA

Docs & Testing: Swagger UI, Postman



🧱 Project Structure
Organized for scalability and clarity.
![image](https://github.com/user-attachments/assets/6467d50a-dd88-48e9-abf3-b09057160e0b)

![image](https://github.com/user-attachments/assets/0c3adc95-0109-4b27-b293-ef4b4ea0af1a)



👥 Roles & Permissions
Role	Permissions
👤 USER	Can add, view, update, delete their own metrics
👑 ADMIN	Can view & manage all user metrics

🔐 JWT Token Required for all protected operations.

🛠️ Setup Instructions
1. Clone the Repository
![image](https://github.com/user-attachments/assets/081a9b20-daec-4913-82b5-ad995ba342c0)




2. Configure Database
Update application.properties with your MySQL credentials.
![image](https://github.com/user-attachments/assets/319f5327-d9e4-4632-b602-242297284c44)


3. Run the Application
Use your IDE or ./mvnw spring-boot:run
![image](https://github.com/user-attachments/assets/56021b4f-8ee4-4a85-8da1-aa80c15aedd9)



5. Access Swagger Docs
Open in browser: http://localhost:8080/swagger-ui/index.html
![image](https://github.com/user-attachments/assets/4ce991d7-4638-4106-b1e0-b9bcc05d0115)



7. Test with Postman
Import the Postman collection from the repo for full API coverage.
