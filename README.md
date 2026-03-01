# 🚀 Hibernate & JPA Practice Projects

## 📌 Overview

This repository contains hands-on projects built using **Hibernate ORM and JPA (Java Persistence API)** to understand object-relational mapping concepts, entity relationships, caching mechanisms, and query handling.

The projects are structured progressively — starting from basic Hibernate setup to advanced topics like caching, custom queries, relationships, and a complete shopping cart implementation.

These projects strengthen backend persistence layer knowledge required for Spring Boot and enterprise applications.

---

# 📚 Project List (As per Repository Structure)

1️⃣ Hibernet_Demo  
2️⃣ Hibernate_Project  
3️⃣ Hibernate_JPA  
4️⃣ Hibernate_Relationship  
5️⃣ Hibernate_Query  
6️⃣ Hibernate-Chache  
7️⃣ HibernateProject_Actor_Movie  
8️⃣ Hibernate_ShoppingCart  

---

# 📁 Detailed Project Explanation

---

## 1️⃣ Hibernet_Demo

**Description:** Basic Hibernate setup and configuration.

**Concepts Covered:**
- hibernate.cfg.xml
- SessionFactory
- Session
- Transaction
- Basic CRUD operations

---

## 2️⃣ Hibernate_Project

**Description:** Demo project for Hibernate entity persistence.

**Concepts Covered:**
- Entity mapping
- @Entity annotation
- Primary key mapping
- Basic insert & fetch operations

---

## 3️⃣ Hibernate_JPA

**Description:** JPA specification implementation using Hibernate.

**Concepts Covered:**
- JPA annotations
- EntityManager
- Persistence Unit
- JPA vs Hibernate difference

---

## 4️⃣ Hibernate_Relationship

**Description:** Hibernate Entity Relationships.

**Concepts Covered:**
- One-to-One mapping
- One-to-Many mapping
- Many-to-One mapping
- Many-to-Many mapping
- Cascade types
- Fetch types (EAGER vs LAZY)

---

## 5️⃣ Hibernate_Query

**Description:** Custom Query Implementation.

**Concepts Covered:**
- HQL (Hibernate Query Language)
- Native SQL Query
- Criteria API
- Named Queries
- Pagination

---

## 6️⃣ Hibernate-Chache

**Description:** Caching mechanism using Level 1 & Level 2 cache.

**Concepts Covered:**
- First-level cache (Session level)
- Second-level cache
- Cache configuration
- Performance optimization techniques

---

## 7️⃣ HibernateProject_Actor_Movie

**Description:** Example project demonstrating entity relationship mapping.

**Concepts Covered:**
- Many-to-Many relationship
- Join table
- Bidirectional mapping
- Association management

---

## 8️⃣ Hibernate_ShoppingCart

**Description:** Mini project simulating Shopping Cart functionality.

**Concepts Covered:**
- Entity relationships
- Cart → Product mapping
- Order processing logic
- Real-world database structure design

---

# 🏗️ Architecture Layer Demonstrated
Java Application
↓
Hibernate ORM / JPA
↓
Session / EntityManager
↓
MySQL Database


---

# 🛠️ Tech Stack Used

- Java
- Hibernate ORM
- JPA
- MySQL
- Maven
- Eclipse IDE

---

# ⚙️ Prerequisites

Before running the projects:

- Java 8+
- Maven installed
- MySQL Database
- Proper database schema created
- Update DB credentials in `hibernate.cfg.xml` or `persistence.xml`

---

# ▶️ How to Run the Projects

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/your-repository-name.git

---

## 2️⃣ Import into IDE

- Open **Eclipse** or **IntelliJ IDEA**
- Choose: `Import → Existing Maven Project`
- Select the project folder

---

## 3️⃣ Configure Tomcat

- Add **Apache Tomcat** in your IDE
- Configure server runtime
- Deploy the required project

---

## 4️⃣ Run on Server

- Right-click project → **Run on Server**
- Open in browser: http://localhost:8080/project-name/


