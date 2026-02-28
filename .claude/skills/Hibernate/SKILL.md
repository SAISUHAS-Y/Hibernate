# Hibernate Development Patterns

> Auto-generated skill from repository analysis

## Overview

This skill teaches Hibernate ORM development patterns based on Maven project structures. The codebase demonstrates enterprise-level Java persistence patterns including entity relationships, CRUD operations, and advanced querying techniques. Projects follow standard Maven conventions with clear separation between entities, DAOs, and application logic.

## Coding Conventions

### File Naming
- **Classes**: PascalCase (e.g., `App.java`, `StudentEntity.java`, `UserDao.java`)
- **Packages**: lowercase with descriptive names (`entity`, `dao`, `hql`, `criteria`)
- **Configuration**: lowercase with extensions (`hibernate.cfg.xml`, `pom.xml`)

### Project Structure
```
src/
├── main/java/
│   ├── {package}/
│   │   ├── App.java
│   │   ├── entity/
│   │   └── dao/
│   └── hibernate.cfg.xml
└── test/java/
    └── {package}/
        └── AppTest.java
```

### Import Style
- Mixed import patterns depending on functionality
- Hibernate imports: `org.hibernate.*`
- JPA annotations: `javax.persistence.*`

### Commit Patterns
- Freeform commit messages
- Average 22 characters in length
- Focus on functionality rather than conventional prefixes

## Workflows

### New Hibernate Maven Project
**Trigger:** When someone wants to create a new Hibernate project from scratch
**Command:** `/new-hibernate-project`

1. Create Maven project structure with `.classpath`, `.project`, and `.settings/` files
2. Add `pom.xml` with Hibernate dependencies including:
   ```xml
   <dependency>
       <groupId>org.hibernate</groupId>
       <artifactId>hibernate-core</artifactId>
   </dependency>
   ```
3. Create main `App.java` file with SessionFactory configuration
4. Add entity classes in `entity/` package with JPA annotations
5. Create DAO classes in `dao/` package for data access
6. Add `hibernate.cfg.xml` configuration with database connection properties
7. Create `AppTest.java` in test directory for unit testing
8. Generate compiled classes in `target/classes/` directory

### Hibernate Entity Relationship Setup
**Trigger:** When someone wants to implement entity relationships in Hibernate
**Command:** `/add-entity-relationship`

1. Create related entity classes with proper JPA annotations:
   ```java
   @OneToOne
   @OneToMany(mappedBy = "parent")
   @ManyToOne
   @ManyToMany
   ```
2. Add relationship annotations with appropriate cascade and fetch strategies
3. Create main `App.java` to demonstrate relationship functionality
4. Configure `hibernate.cfg.xml` with entity mappings:
   ```xml
   <mapping class="com.example.entity.Student"/>
   <mapping class="com.example.entity.Course"/>
   ```
5. Generate compiled classes in `target/` directory
6. Test relationship operations (save, fetch, update cascades)

### Hibernate CRUD Operations
**Trigger:** When someone wants to add comprehensive CRUD functionality
**Command:** `/add-crud-operations`

1. Create `App_Insert.java` for create operations with Session.save()
2. Create `App_Fetch.java` for read operations with Session.get() and Session.load()
3. Create `App_Update.java` for update operations with Session.update() and Session.merge()
4. Create `App_Delete.java` for delete operations with Session.delete()
5. Add corresponding entity classes with proper annotations
6. Configure `hibernate.cfg.xml` with transaction settings
7. Implement proper session management and transaction handling
8. Compile all classes to `target/` directory

### Hibernate Query Implementation
**Trigger:** When someone wants to add advanced querying capabilities
**Command:** `/add-query-types`

1. Create `App_HQL.java` for HQL queries:
   ```java
   Query query = session.createQuery("FROM Student WHERE name = :name");
   ```
2. Create `App_SQL.java` for native SQL queries:
   ```java
   SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM student");
   ```
3. Create `App_Criteria.java` for deprecated Criteria API
4. Create `App_CriteriaBuilder.java` for JPA Criteria Builder API:
   ```java
   CriteriaBuilder cb = session.getCriteriaBuilder();
   CriteriaQuery<Student> cq = cb.createQuery(Student.class);
   ```
5. Add entity classes with appropriate fields for querying
6. Configure Hibernate mapping for all query types
7. Implement proper result handling and type safety

## Testing Patterns

### Test Structure
- Test files follow `*.test.*` pattern
- Located in `src/test/java/` directory
- Named as `AppTest.java` for main application tests
- Framework appears to be standard JUnit (specific version undetected)

### Test Conventions
- Test database configuration separate from production
- Session factory initialization in test setup
- Proper cleanup after test execution
- Entity persistence verification

## Commands

| Command | Purpose |
|---------|---------|
| `/new-hibernate-project` | Create a complete Maven-based Hibernate project structure |
| `/add-entity-relationship` | Implement entity relationships (OneToOne, OneToMany, etc.) |
| `/add-crud-operations` | Add comprehensive CRUD operations with separate App files |
| `/add-query-types` | Implement HQL, SQL, and Criteria API querying capabilities |