# Learning Functional Programming

## Requirement
We need to implement an API endpoint where users can post a list of employee details as JSON payload,
and we need to insert/update those details in the database.

## Request Payload:

```json
{
   "employees": [
        {
          "name": "John",
          "email": "john@gmail.com",
          "salary": 10000,
          "address": "..."
        },
        {
          "name": "Jane",
          "email": "jane@gmail.com",
          "salary": 20000,
          "address": null
        }
   ]
}
```

## Business Rules
1. **Name**, **email** and **salary** are mandatory fields and **address** is optional.
2. **Name** should not be blank.
3. **Email** should not be blank and should be a valid email address.
4. **Email** should be unique in our system. (Assume in payload we don't get employee records with duplicate emails)
5. **Salary** should be a positive number.
6. If an employee already exists in the database with the given **email**, update the **name**, **salary** and **address**. Otherwise, insert a new record.

## Response Payload:

1. Success Response: return HTTP Status Code: 200
2. Invalid Request Response: If there is invalid data in the request payload, we need to return HTTP Status Code: 400
3. Internal Server Error: If there is any failure in processing the request, we need to return HTTP Status Code: 500


## Solution using Procedural or OOP approach
Irrespective of the approach, what I would do is break down the problem into smaller tasks and then solve them one by one.

### Task break down
1. Parse the request payload and convert it into List<Employee> objects.
2. Validate the List<Employee> objects.
3. If validation fails, return HTTP 400 response.
4. for each employee <- employees
   4.1. Check if employee email exists in the database.
   4.1. if employee email exists in the database, update the employee record in the database.
   4.2. Otherwise, update the employee record in the database.

If we are using a library/framework, some tasks can be taken care by the library/framework. 
For example, parsing the request payload and converting it into List<Employee> objects can be taken care by the library/framework. 
Similarly, validating the List<Employee> objects can be taken care by the library/framework.

Among those sub-tasks, some can be implemented as pure-functions and some will be functions with side-effects.

1. Parse the request payload and convert it into List<Employee> objects. **(Pure-function)**
2. Validate the List<Employee> objects. **(Pure-function)**
3. If validation fails, return HTTP 400 response.
4. for each employee <- employees 
   * Check if employee email exists in the database. **(Side-effect, involves DB interaction)**
   * if employee email exists in the database, update the employee record in the database. **(Side-effect, involves DB interaction)**
   * Otherwise, update the employee record in the database. **(Side-effect, involves DB interaction)**


## Solution using Functional Programming approach
???