# Image Upload Project
This module is a high-level architecture for an image upload and analysis platform. 
Core CRUD APIs for image management have been implemented.

We would keep the implementation quite simple to use a simple RDBMS as a backend DB and use Spring Boot to implement a few core APIs. 
The architecture however would be more detailed and we would cover a lot more details as the project is implemented.

### Getting started

1. Setup docker locally and pull mysql. It is already configured to create the database when this application starts. We use image_upload_db as a database. 
2. We need to create tables as provided in the resources.
3. Check connectivity to the database
4. Postman collection has been added in the resources.
5. Run the application and try the postman collection APIs