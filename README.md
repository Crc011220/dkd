# dkd - Vending Machine Backend Management System

## Overview

The **dkd** project is a comprehensive backend management system designed to handle various administrative tasks for a vending machine network. This system includes features for managing nodes, devices, products, and work orders, along with a secure and scalable front-end interface for operations and order management. The project is integrated with **Ruoyi-vue3**, a front-end and back-end separation version of the popular Ruoyi system, providing a rich and responsive user interface and basic backend logics.

## Key Features

### 1. **Features**
- **Node Management**: Provides functionality to manage vending machine nodes, ensuring smooth operation across a distributed network.
- **Device Management**: Allows administrators to manage connected devices, monitor their status, and perform necessary configurations.
- **Product Management**: Enables easy management of products available in vending machines, including inventory updates and pricing adjustments.
- **Work Order Management**: Handles service requests and work orders for machine maintenance or issue resolution.

### 2. **RUOYI-vue3 Integration**
- Integrated **RUOYI-vue3**, a front-end and back-end separation version, to provide a responsive and intuitive user interface for managing the vending machine system.
- This integration allows for a clean architecture that separates concerns between the front-end and back-end, making the system more maintainable and scalable.

### 3. **Storage & Scalability**
- **Amazon S3 Integration**: Efficiently stores and manages static assets like images and documents, enabling scalable and secure handling of project resources.
  
### 4. **Performance Optimization**
- **MyBatis Integration**: Optimized database operations with MyBatis to handle high-volume transactions efficiently, reducing response time and improving scalability.
- **Redis Caching**: Implemented Redis caching for login authentication, significantly improving performance by reducing the load on the database and ensuring faster user verification.

### 5. **Security**
- **Spring Security Framework**: Integrated Spring Security to ensure secure authentication and restrict data access to authorized roles, improving application security and data integrity.

## Technologies Used
- **Back-End**: Java, Spring Boot, MyBatis, Redis, Spring Security
- **Front-End**: HTML, CSS, JavaScript (Vue.js)
- **Database**: MySQL
- **Cloud Storage**: Amazon S3

