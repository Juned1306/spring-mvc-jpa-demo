# Spring MVC JPA Demo

This project demonstrates how **Spring MVC** improves upon traditional Servlet-based applications by introducing a **Front Controller design pattern** and centralized request handling. It also integrates **Spring Data JPA** with Oracle Database for persistence and uses JSP for views.

---

## 📖 Learning Notes

### 🔹 Traditional Servlet Approach
- In plain Servlets, **every request must be manually managed**:
  - You write code to read request parameters using `request.getParameter()`.
  - Bind those parameters to Java objects manually.
  - Forward them to business logic or JSPs.
- There is **no centralized request handler** — each servlet is responsible for its own request mapping and logic.
- This leads to:
  - **Tight coupling** between request handling and business logic.
  - **Repetitive boilerplate code** across multiple servlets.
  - Difficult maintenance as the application grows.

---

### 🔹 How MVC Improves This
- **MVC introduces the Front Controller pattern**:
  - All requests first go to the **Servlet Container** (Tomcat).
  - The container forwards requests (like `.mvc` or `.html`) to the **Front Controller**.
  - In Spring MVC, the Front Controller is the **DispatcherServlet**.
  
- **DispatcherServlet responsibilities**:
  1. **Validate the request** → ensures it matches configured mappings.
  2. **Apply common pre/post-processing logic** → logging, security, etc.
  3. **Forward the request to the correct Request Handler (Controller)**.
  4. **Controller delegates to Service → Repository → Database** for business logic and persistence.
  5. **Controller returns a logical view name** (e.g., `"registration"`), not the actual JSP file.
  6. **ViewResolver** (e.g., `InternalResourceViewResolver`) maps the logical view name to the actual JSP file by adding prefix/suffix (e.g., `/WEB-INF/view/registration.jsp`).
  
- This makes the system:
  - **Loosely coupled** → controllers don’t need to know about JSP paths.
  - **Easier to maintain** → centralized request handling.
  - **Cleaner separation of concerns** → Controller handles web requests, Service handles business logic, Repository handles persistence.

---

### 🔹 Why Spring MVC is Better than Manual Config
- In classic MVC (without Spring Boot):
  - You had to configure `DispatcherServlet` manually in `web.xml`.
  - You had to configure `ViewResolver` in `dispatcher-servlet.xml`.
- With **Spring Boot + Spring MVC**:
  - These configurations are **auto-managed by IoC container**.
  - You only need to define controllers, services, repositories, and JSPs.
  - Spring Boot wires everything together automatically.

---

## ⚙️ Spring MVC Advantages
- **Centralized request handling** via DispatcherServlet.
- **Automatic binding** of request parameters to Java objects.
- **Cleaner architecture**: Controller → Service → Repository → View.
- **Loose coupling** between logical view names and actual JSPs.
- **Reduced boilerplate** compared to raw Servlets.

---

## 🔄 Request Flow in Spring MVC

👉 **Client (Browser)**  
⬇️  
🖥️ **Servlet Container (Tomcat)**  
⬇️  
🚦 **DispatcherServlet (Front Controller)**  
⬇️  
🗂️ **Handler Mapping**  
⬇️  
🎯 **Controller**  
⬇️  
⚙️ **Service Layer**  
⬇️  
💾 **Repository (DAO)**  
⬇️  
🗄️ **Database (Oracle)**  
⬆️  
🎯 **Controller returns Logical View Name**  
⬇️  
🧩 **ViewResolver (InternalResourceViewResolver)**  
⬇️  
📄 **Actual JSP Page (View)**


## 🚀 Technologies Used
- Spring Boot
- Spring MVC
- Spring Data JPA
- Oracle Database
- JSP
- Maven

---

## ▶️ How to Run
1. Clone the repository:
  ```bash
   git clone https://github.com/Juned1306/spring-mvc-jpa-demo.gitcd spring-mvc-jpa-demo
```
cd spring-mvc-jpa-demo

mvn clean install
mvn spring-boot:run

Access in browser:

http://localhost:8080/register → Registration page

http://localhost:8080/printDetail → Submit form

http://localhost:8080/fetch → View all users
