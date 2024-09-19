# Spring Boot application for Tech Course Purchases with Razorpay Integration

This repository contains the codebase for a **Spring Boot application** designed to facilitate the purchase of Tech Courses through the **Razorpay payment gateway**.

### Features

- **HomePage:** Enter personal details and select a course.
- **SuccessPage:** Display a success message after payment.
- **Order Creation:** Click the **Pay** button to create orders and generate payment links.
- **Dynamic Pricing:** Course prices are updated automatically based on selection.

### Course Pricing

- **Frontend:** ₹7,000
- **Backend:** ₹9,000
- **Fullstack:** ₹12,000
- **DSA:** ₹6,000

### Quality and Security Assurance

The application includes the following tools for code quality and security:

- **SonarQube:** For code quality analysis.
- **OWASP Scanner:** For dependency checks.
- **JaCoCo:** For code coverage.
- **Jasypt:** For secure encryption and decryption of passwords.

### CI/CD Pipeline

A **Dockerfile** is included to containerize the application, along with a **Jenkinsfile** for setting up a CI/CD pipeline that includes:

- **GIT Checkout** from SCM
- **Maven** Build and Install
- **OWASP Scanner** for dependency checks
- **SonarQube Scanner** for code quality analysis
- **Docker** image build and push to DockerHub

## Prerequisites

- Java 17 
- Maven 
- Spring Boot 
- Spring Data JPA 
- H2 Database 
- Thymeleaf 
- HTML 
- CSS 
- Javascript
- GIT
- Jacoco
- OWASP Scanner
- Sonarqube Scanner
- Jasypt
- Jenkins Pipeline
- Docker

## Installation Steps

### Using Maven:
1. **Clone the repository:**
   
       git clone https://github.com/KarthikeyanNagarajan/Integrating-Payment-Gateway.git

2. **Create an account in [RazorPay](https://dashboard.razorpay.com/#/access/signup) and Generate secretID and secretKey.** 
	  - Add your Razorpay API key and secret in application.properties,
		  
		    razorpay.key.id = <your_key_id>
		    razorpay.key.secret = <your_key_secret> 

3. **Change Jasypt key (If needed):**
      
     > Change the ****jasypt.encryptor.password**** value according to your needs. If changed then add the updated encrypted password in ****application.properties**** file.
     
4. **Build the project:**
	  
       cd Integrating-Payment-Gateway
       mvn -Djasypt.encryptor.password=karthik clean install

5. **Run the application:**
	  
       java -Djasypt.encryptor.password=karthik -jar target/Integrating-Payment-Gateway-0.0.1-SNAPSHOT.jar

6. **Now run below URL in browser. Select the course and click on ***Pay*** button.**
       
       http://localhost:8082/

### Using Docker:

1. **Pull the Image from DockerHub Repository:**

       docker pull karthikeyan97/integrating-payment-gateway:latest

2. **Run below command to run the pulled image:**
 
       docker run --name Payment-Gateway -d -p 8082:8082 karthikeyan97/integrating-payment-gateway:latest
       
3. **Now run below URL in browser. Select the course and click on ***Pay*** button.**
       
       http://localhost:8082/
       
For more reference visit **https://docs.razorpay.com/v1/page/orders**

## Working flow

Below Image explains Payment flow between appliction and Razorpay,

<img width="600" alt="1" src="https://github.com/user-attachments/assets/13b842ed-fd24-42f3-986a-fddbf67d3e7f">

## Screenshots

Attaching artifacts of application for reference.

![2](https://github.com/user-attachments/assets/c9c377d0-eed8-4a97-8f68-28d8391e9bcb)
![3](https://github.com/user-attachments/assets/b87a39ea-b2fe-4967-a809-a14fe86d3814)
![4](https://github.com/user-attachments/assets/80e0c314-d35b-43ea-8fa0-00122cf700a5)
![5](https://github.com/user-attachments/assets/c09ed1e7-b534-4ed5-bd9f-a3b30b49be17)
![6](https://github.com/user-attachments/assets/f247475d-0c77-41cb-a3a6-10392b79ec05)

## Contributing
Contributions are welcome! Please fork the repository and create a pull request.
