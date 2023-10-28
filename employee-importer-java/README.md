# Employee Importer

## Requirement
Given a JSON file containing a list of employee details, 
we need to insert/update those details in the database.

## Sample Input File

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
4. **Email** should be unique in our system. (Assume in file we don't get employee records with duplicate emails)
5. **Salary** should be a positive number.
6. If an employee already exists in the database with the given **email**, update the **name**, **salary** and **address**. Otherwise, insert a new record.

## Response Payload:

1. Success Response: `{ "status": "success", "message": "Imported successfully"  }`
2. Invalid Request Response: `{ "status": "error", "message": "Invalid data" }`
3. Unknown Error: `{ "status": "error", "message": "Internal Server Error" }`

## Solution using Procedural or OOP approach
Irrespective of the approach, what I would do is break down the problem into smaller tasks and then solve them one by one.

### Task break down
1. Parse the input file and convert it into List<Employee> objects.
2. Validate the List<Employee> objects.
3. If validation fails, return error response.
4. for each employee <- employees
   4.1. Check if employee email exists in the database.
   4.1. if employee email exists in the database, update the employee record in the database.
   4.2. Otherwise, update the employee record in the database.

Among those subtasks, some can be implemented as pure-functions and some will be functions with side-effects.

1. Parse the input file and convert it into List<Employee> objects. **(Side-effect)**
2. Validate the List<Employee> objects. **(Pure-function)**
3. If validation fails, return error response.
4. for each employee <- employees 
   * Check if employee email exists in the database. **(Side-effect, involves DB interaction)**
   * if employee email exists in the database, update the employee record in the database. **(Side-effect, involves DB interaction)**
   * Otherwise, update the employee record in the database. **(Side-effect, involves DB interaction)**
