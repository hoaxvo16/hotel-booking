## Hotel Booking Application

Below is guideline how to start this application

### Use docker

Build docker image:

```bash
docker build -t hotel-booking-app .
```

Run docker compose to start the application

```bash
docker compose up -d
```

Access swagger at http://localhost:8080/swagger-ui/index.html

The default username to login is: ***john.doe@example.com***
and password is: ***password***

## System design for hotel booking application

**Disclaimer**: I have zero experience with AWS services. This is a high-level design, and each AWS service chosen is presumed suitable for the design.

### Constraints:

1. 3 million bookings per hour.
2. Many hotels rely on third-party providers for their reservation systems, leading to integration challenges and potential downtime.

### Assumptions:
Users need to perform a search, view room availability, view details, and then process bookings. This results in approximately 12 million reads per hour in the database (200k reads per second). Each booking requires reservation and payment processing, resulting in 6 million writes per hour in the database (100k writes per second).

### High-Level System Design:

![Hotel Booking System Design](/src/main/resources/static/Hotel%20Booking%20System%20Design.png)

- **Microservice Architecture**: Each service has a separate concern and database.
- **Load Balancer**: Positioned between the user application and the backend system to reduce latency and improve performance.
- **Amazon EKS**: Services are deployed on Amazon Elastic Kubernetes Service, which scales horizontally to handle a large number of requests per second.
- **Amazon RDS**: Due to the significant read/write data operations, scaling out using sharding techniques on Amazon Relational Database Service is ideal.
- **Amazon MSK**: Communication between the reservation and payment services uses Kafka (Amazon Managed Streaming for Apache Kafka) to achieve fault tolerance and asynchronous data flow, addressing integration challenges with third-party providers.
- **Third-Party Integration**: External third parties communicate with backend services via message queues or callback APIs for processing payments and reservations.

### Future Enhancements and Notes:

- **Transaction Management**: The design does not currently address transaction management. From my basic knowledge, the Saga pattern can be used to handle transactions in a microservice architecture.
- **Caching Layer**: Due to the high number of read operations, adding a caching layer between the service and the database can reduce the database load.




