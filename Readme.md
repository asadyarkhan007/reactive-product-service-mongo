# Reactive Product Service

This is a reactive product service application built using Spring WebFlux and MongoDB. It provides endpoints to perform CRUD operations on products.

## Endpoints

### Get Product by ID

```
GET /products/{id}
```

Retrieves a product by its ID.

**Path Parameters:**
- `id` (string): The ID of the product.

**Response:**
- Status Code: 200 (OK)
- Body: JSON representation of the product.

### Get All Products

```
GET /products
```

Retrieves all products.

**Query Parameters:**
- `minPrice` (optional, double): The minimum price of the products to filter.
- `maxPrice` (optional, double): The maximum price of the products to filter.

**Response:**
- Status Code: 200 (OK)
- Body: JSON array of product objects.

### Create Product

```
POST /products
```

Creates a new product.

**Request Body:**
- JSON representation of the product to be created.

**Response:**
- Status Code: 201 (Created)
- Body: JSON representation of the created product.

### Update Product

```
PUT /products/{id}
```

Updates an existing product.

**Path Parameters:**
- `id` (string): The ID of the product to update.

**Request Body:**
- JSON representation of the updated product.

**Response:**
- Status Code: 200 (OK)
- Body: JSON representation of the updated product.

### Delete Product

```
DELETE /products/{id}
```

Deletes a product.

**Path Parameters:**
- `id` (string): The ID of the product to delete.

**Response:**
- Status Code: 204 (No Content)

## Usage

Here are the instructions to start and stop the application using the `docker-compose` command:

To start the application:
1. Open a terminal or command prompt.
2. Navigate to the directory where your `docker-compose.yml` file is located.
3. Run the following command to start the application:

```
docker-compose up
```

This command will build the Docker image for the application, start the MongoDB container, and start the application container. The logs from the containers will be displayed in the terminal.

To stop the application:
1. Open a separate terminal or command prompt.
2. Navigate to the directory where your `docker-compose.yml` file is located.
3. Run the following command to stop the application:

```
docker-compose down
```

This command will stop and remove the containers created by Docker Compose.

Make sure you have Docker and Docker Compose installed on your machine before running these commands. Adjust the commands according to your specific setup if necessary.
