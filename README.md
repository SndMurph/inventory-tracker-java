# Inventory Tracker (Java + MySQL)

A simple Java-based inventory management app that connects to a MySQL database using JDBC. Built as a standalone CLI application to demonstrate CRUD operations and database connectivity.

---

##  Features

-  View all inventory items  
-  Add new items  
-  Update item quantities  
-  Delete items or reduce quantity  
-  MySQL backend using JDBC  
-  CLI-based user interface  
-  Easy to extend with new features  

---

##  Technologies Used

- Java (JDK 17+)
- MySQL
- JDBC (mysql-connector-j-9.3.0.jar)
- Command Line Interface (CLI)

---

##  Setup & Run

1. Clone this repo:
   ```bash
   git clone https://github.com/SndMurph/inventory-tracker-java.git
   cd inventory-tracker-java
   ```

2. Make sure MySQL is running and create a database:
   ```sql
   CREATE DATABASE inventory_db;
   USE inventory_db;

   CREATE TABLE items (
       id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(255),
       quantity INT
   );
   ```

3. Build and run the app:
   ```bash
   javac -cp .;mysql-connector-j-9.3.0.jar inventorymanage/*.java
   java -cp .;mysql-connector-j-9.3.0.jar inventorymanage.InventoryApp
   ```

   Or use the provided `run_inventory_app.bat`.

---

##  Project Structure

```
InventoryManage/
├── inventorymanage/            # Java source files
│   ├── InventoryApp.java       # Main UI loop
│   ├── DatabaseManager.java    # Handles DB interaction
│   ├── InventoryItem.java      # Model class
├── mysql-connector-j-9.3.0.jar # JDBC driver
├── run_inventory_app.bat       # Windows launch script
├── .gitignore
└── README.md
```

---

##  What I Learned
> This project helped me refresh JDBC, SQL basics, and how to structure a Java app that interacts with a real database. 
>It also refreshed me on how to push a full project to GitHub and use `.gitignore`.

---

##  Status

📍 In progress — planning to add a GUI version and more advanced features like search, categories, and login authentication.