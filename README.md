
## About

This is a simple STUDENT MANAGEMENT SYSTEM where there are 3 types of users based on their role. These are ADMIN, TEACHER, and STUDENT. STUDENT can register themselves to the system to enroll in the offered course. All users can perform only these actions, which are allowed based on their role. After successfully completing the registration, a user can get the confirmation email. And there is a scheduled notification system for the alert notification of how many pending students are available in the system. This notification only gets to the super admin at a specific time based on the scheduled time.


## Worked on

- Java and Spring Boot
- Spring Securities, Hibernate, CACHE, Scheduling, Job-Queue
- JWT authentication and authorization
- Mailtrap service is used for sending email.
- MySQL
- Global Error Handing
- Implemented JPA query for some features
- POST for API testing


## MAILTRAP Config


    spring:
        mail:
          host: sandbox.smtp.mailtrap.io
          port: 2525
          username: 556aafdab5107d
          password: 09c99b6e5c25b2
      
          properties:
            mail:
              smtp:
                auth: true
                starttls:
                  enable: true
