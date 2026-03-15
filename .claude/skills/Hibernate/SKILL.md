# Hibernate Development Patterns

> Auto-generated skill from repository analysis

## Overview

This skill teaches enterprise-level Hibernate ORM development patterns commonly used in Java applications. The codebase demonstrates comprehensive Hibernate functionality including project setup, entity relationship modeling, caching strategies, and various querying approaches. It follows Maven-based project structure with Eclipse IDE integration and emphasizes practical implementations of Hibernate features for database persistence layer development.

## Coding Conventions

### File Naming
- **Entities**: PascalCase with descriptive names (`Employee.java`, `Company.java`, `Mobile.java`)
- **Applications**: `App.java` for main classes, `App_<Feature>.java` for specific implementations
- **Packages**: Lowercase with feature grouping (`entity`, `hql`, `criteria`, `criteriabuilder`)

### Project Structure
```
project-root/
├── pom.xml
├── .classpath
├── .project
├── .settings/
├── src/main/java/
│   ├── entity/
│   ├── hql/
│   ├── criteria/
│   └── App.java
├── src/test/java/
├── hibernate.cfg.xml
└── target/classes/
```

### Configuration Style
- Mixed import styles with preference for specific imports
- Hibernate configuration via `hibernate.cfg.xml` or `META-INF/persistence.xml`
- Maven dependencies managed in `pom.xml`
- Eclipse IDE integration with `.classpath` and `.project` files

## Workflows

### New Hibernate Project Creation
**Trigger:** When someone wants to create a new Hibernate project module  
**Command:** `/new-hibernate-project`

1. **Create Maven project structure**
   ```xml
   <!-- pom.xml with Hibernate dependencies -->
   <dependency>
       <groupId>org.hibernate</groupId>
       <artifactId>hibernate-core</artifactId>
   </dependency>
   ```

2. **Generate Eclipse IDE configuration files**
   - Create `.classpath` with Maven dependencies
   - Create `.project` with Java project nature
   - Add `.settings/` folder with IDE preferences

3. **Create source directories**
   - `src/main/java/` for application code
   - `src/test/java/` for test files
   - Package structure with `entity/` subfolder

4. **Add Hibernate configuration**
   ```xml
   <!-- hibernate.cfg.xml -->
   <hibernate-configuration>
       <session-factory>
           <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
           <property name="hibernate.hbm2ddl.auto">update</property>
       </session-factory>
   </hibernate-configuration>
   ```

5. **Create entity classes and main App class**
6. **Generate Maven target directory with compiled classes**

### Entity Relationship Setup
**Trigger:** When someone wants to model database relationships using Hibernate annotations  
**Command:** `/new-entity-relationship`

1. **Create entity classes with JPA annotations**
   ```java
   @Entity
   public class Employee {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       
       @ManyToOne
       @JoinColumn(name = "company_id")
       private Company company;
   }
   ```

2. **Define relationship mappings**
   - `@OneToOne` for one-to-one relationships (Person-Aadhar)
   - `@OneToMany` and `@ManyToOne` for parent-child relationships
   - `@ManyToMany` for many-to-many relationships (Customer-Product)

3. **Create main application class to test relationships**
   ```java
   public class App {
       public static void main(String[] args) {
           SessionFactory factory = new Configuration().configure().buildSessionFactory();
           Session session = factory.openSession();
           // Relationship testing code
       }
   }
   ```

4. **Configure Hibernate settings for relationship handling**
5. **Generate compiled classes and test files**

### Hibernate Caching Implementation
**Trigger:** When someone wants to optimize Hibernate performance using caching strategies  
**Command:** `/add-hibernate-caching`

1. **Create entity classes with cache annotations**
   ```java
   @Entity
   @Cacheable
   @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
   public class Mobile {
       @Id
       private int id;
       private String brand;
   }
   ```

2. **Configure cache settings in hibernate.cfg.xml**
   ```xml
   <property name="hibernate.cache.use_second_level_cache">true</property>
   <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
   ```

3. **Implement cache testing in main application**
   - Demonstrate Level 1 cache (session-level)
   - Show Level 2 cache (SessionFactory-level) behavior

4. **Set up both first and second level cache examples**
5. **Generate cache-enabled compiled classes**

### Query Methods Implementation
**Trigger:** When someone wants to demonstrate different querying approaches in Hibernate  
**Command:** `/add-query-methods`

1. **Create entity class for query operations**
   ```java
   @Entity
   public class Actor {
       @Id
       private int actorId;
       private String firstName;
       private String lastName;
   }
   ```

2. **Implement HQL query examples**
   ```java
   // App_HQL.java
   Query query = session.createQuery("FROM Actor WHERE firstName = :fname");
   query.setParameter("fname", "John");
   ```

3. **Create Criteria API examples**
   ```java
   // App_Criteria.java
   Criteria criteria = session.createCriteria(Actor.class);
   criteria.add(Restrictions.eq("firstName", "John"));
   ```

4. **Build CriteriaBuilder examples for CRUD operations**
   - `App_CriteriaBuilder.java` for select queries
   - `App_CriteriaDelete.java` for delete operations
   - `App_CriteriaUpdate.java` for update operations

5. **Add native SQL query implementations**
   ```java
   // App_SQL.java
   SQLQuery query = session.createSQLQuery("SELECT * FROM actor");
   ```

6. **Generate query-specific application classes**

## Testing Patterns

- Test files follow `*.test.*` pattern
- Testing framework not explicitly detected, likely JUnit
- Test structure mirrors main source directory
- Integration tests focus on database operations and entity relationships
- Unit tests verify individual component functionality

## Commands

| Command | Purpose |
|---------|---------|
| `/new-hibernate-project` | Creates complete Hibernate Maven project with IDE configuration |
| `/new-entity-relationship` | Sets up entity classes with JPA relationship annotations |
| `/add-hibernate-caching` | Implements Level 1 and Level 2 caching with configuration |
| `/add-query-methods` | Creates examples of HQL, Criteria, CriteriaBuilder, and SQL queries |