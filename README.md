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


🔹 Postman Collection
Import into Postman for instant testing!


🗂️ Database Design
Visual representation of the database schema.


🚀 Tech Stack
Language: Java 17

Framework: Spring Boot

Security: Spring Security + JWT

Database: MySQL

ORM: Spring Data JPA

Docs & Testing: Swagger UI, Postman

🧱 Project Structure
Organized for scalability and clarity.



👥 Roles & Permissions
Role	Permissions
👤 USER	Can add, view, update, delete their own metrics
👑 ADMIN	Can view & manage all user metrics

🔐 JWT Token Required for all protected operations.

🛠️ Setup Instructions
1. Clone the Repository

bash
Copy
Edit
git clone <repo-link>


2. Configure Database
Update application.properties with your MySQL credentials.


3. Run the Application
Use your IDE or ./mvnw spring-boot:run


4. Access Swagger Docs
Open in browser: http://localhost:8080/swagger-ui/index.html


5. Test with Postman
Import the Postman collection from the repo for full API coverage.
