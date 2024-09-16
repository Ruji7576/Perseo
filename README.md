# Perseo Project

This project is a platform for managing courses, shopping carts, experiences, payments, and user details.

## Getting Started

To get started with the project:

 **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/perseo.git
   cd perseo
 ```
## API Endpoints

### `AuthController`
- **POST /api/auth/login**: Authenticate a user and return a JWT token.
- **POST /api/auth/register**: Register a new user and return a JWT token.

### `CartController`
- **GET /api/cart/getById/{id}**: Get a cart by ID.
- **GET /api/cart**: Get all carts.
- **GET /api/cart/getAllBy/{user_id}**: Get all carts for a user.
- **DELETE /api/cart/delete/{id}**: Delete a cart by ID.
- **PUT /api/cart/update/{id}**: Update a cart by ID.
- **POST /api/cart/create**: Create a new cart.

### `CoursesController`
- **GET /api/course/getById/{id}**: Get a course by ID.
- **GET /api/course**: Get all courses.
- **DELETE /api/course/delete/{id}**: Delete a course by ID.
- **PUT /api/course/update/{id}**: Update a course by ID.
- **POST /api/course/create**: Create a new course.

### `ExperienceController`
- **GET /api/experience/getById/{id}**: Get an experience by ID.
- **GET /api/experience**: Get all experiences.
- **GET /api/experience/getAllBy/{user_id}**: Get all experiences for a user.
- **DELETE /api/experience/delete/{id}**: Delete an experience by ID.
- **PUT /api/experience/update/{id}**: Update an experience by ID.
- **POST /api/experience/create**: Create a new experience.

### `PayementController`
- **POST /api/payement/buy/{user_id}**: Make a course purchase.
- **GET /api/payement/getAll**: Get all payments.
- **GET /api/payement/getAll/{user_id}**: Get all payments for a user.
- **DELETE /api/payement/delete/{id}**: Delete a payment by ID.
- **PUT /api/payement/update/{id}**: Update a payment by ID.

### `UserCourseController`
- **GET /api/userCourse/getAll**: Get all user courses.
- **GET /api/userCourse/getAll/{user_id}**: Get all courses for a user.
- **DELETE /api/userCourse/delete/{id}**: Delete a user course by ID.
- **PUT /api/userCourse/update/{id}**: Update a user course by ID.
- **PUT /api/userCourse/complete/{user_id}**: Mark a course as completed for a user.

### `UserDetailsController`
- **GET /api/userDetails/getById/{id}**: Get user details by ID.
- **GET /api/userDetails**: Get all user details.
- **GET /api/userDetails/getAllBy/{user_id}**: Get all user details for a user.
- **DELETE /api/userDetails/delete/{id}**: Delete user details by ID.
- **PUT /api/userDetails/update/{id}**: Update user details by ID.
- **POST /api/userDetails/create**: Create new user details.

## Technologies Used

- **Java**: The programming language used.
- **Spring Boot**: Framework for building the application.
- **Spring Security**: For handling authentication and authorization.
- **Lombok**: To reduce boilerplate code.
- **JUnit**: For unit testing.
- **Mockito**: For mocking dependencies in tests.
- **Maven**: For project management and build automation.

## Database Schema

You can add a screenshot or image of the database schema here:
![Database Schema](https://github.com/maksym7576/Perseo/blob/main/src/Images/Base%20of%20date.png?raw=true)

