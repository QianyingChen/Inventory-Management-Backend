# Inventory-Management-Backend

## Database Tables
### warehouses
| Name | Type   |  Description Description |  
|------|--------|-------------- |  
| id   | SERIAL    |Unique identifier for the warehouse
| name | VARCHAR |Name of the warehouse
| address | VARCHAR |Address of the warehouse
| contact_person | VARCHAR |Contact person for the warehouse
| phone_number   | VARCHAR |Phone number of the warehouse
| max_capacity   | INT    |Max Capacity  of the warehouse

### items
| Name | Type   |  Description Description |  
|------|--------|-------------- |  
| id   | SERIAL    | Unique identifier for the item
| name | VARCHAR |Name of the item
| quantity | INT | Quantity of the item in the warehouse
| max_capacity   | INT    |Maximum capacity of the item in the warehouse
| warehouse_id   | INT    |Foreign key referencing the warehouse table

### warehouses
| Name | Type   | Description Description |  
|------|--------|-------------- |  
| id   | SERIAL    |Unique identifier for the transaction
| transaction_date | TIMESTAMP |Date and time the transaction occurred
| transaction_type | VARCHAR |Type of transaction (e.g. in or out)
| quantity	 | INT |Quantity of items involved in the transaction
| item_id   | INT |Foreign key referencing the item table

### users
| Name | Type   | Description Description |  
|------|--------|-------------- |  
| id   | SERIAL    |Unique identifier for the user
| username | VARCHAR |Username for logging in
| password | VARCHAR |	Password for logging in
| role	 | VARCHARv |	Role of the user (e.g. admin, employee)

