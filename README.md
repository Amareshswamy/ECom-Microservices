# E-commerce Microservices

## About
The E-commerce Microservices project is designed to provide a comprehensive platform for managing various aspects of an e-commerce application. This architecture allows for independent scaling and development of services such as product management, inventory control, order processing, and notification handling.

## Tech Stack
- **Java 21**: The latest version of Java, providing new features and enhancements.
- **Spring Boot**: A framework for building stand-alone, production-grade Spring-based applications.
- **Microservices**: An architectural style that structures an application as a collection of loosely coupled services.
- **Service Discovery**: Automatically detects services in the architecture.
- **Keycloak**: Provides authentication and authorization features.
- **Circuit Breaker**: A design pattern used to improve the stability of the application.
- **Resilience**: Techniques to ensure the application remains functional under various conditions.
- **Docker**: Containerization platform for deploying applications in isolated environments.
- **MySQL**: A relational database management system.
- **MongoDB**: A NoSQL database for storing unstructured data.
- **Kafka**: A distributed event streaming platform.
- **Grafana**: Monitoring tool for visualizing metrics.
- **Tempo**: Distributed tracing tool.
- **Postman**: API testing tool.
- **Spring Cloud**: A set of tools for building cloud-native applications.

## Services
- **Product Service**: Manages product information.
- **Inventory Service**: Handles stock management.
- **Order Service**: Manages customer orders.
- **Notification Service**: Sends notifications related to orders and inventory.
- **API Gateway**: Acts as a centralized entry point for all services.

**Note**: The order, inventory, and notification services will interact with each other, supporting both synchronous and asynchronous communication.

## APIs

### Product Service
- **GET** `/api/product` - Retrieve product information.
- **POST** `/api/product` - Add a new product.

### Order Service
- **GET** `/api/inventory` - Retrieve inventory information.
- **POST** `/api/order` - Place a new order.

### Inventory Service
- **GET** `/api/inventory` - Retrieve inventory data.

All APIs are accessed through the centralized API Gateway.

## Sample Images

### 1. Notification service
![NOtificaton image](images/Screenshot%202024-10-06%20122638.png)

### 2. Grafna and Tempo dashboard
![dashboard](images/Screenshot%202024-10-07%20215332.png)

### 3. Docker images
![Docker images](images/Screenshot%202024-10-07%20224637.png)

### 4. Requst api's
![All requests](images/Screenshot%202024-10-07%20225000.png)

### 5. Order api request
![API request](images/Screenshot%202024-10-07%20225016.png)
