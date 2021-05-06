## Medic shipping
> **Nota:** crearemos el frontend en ReactJS.


### Descripción

* Venta de medicamentos online, desarrollado en el lenguaje **Java** con el framework **Spring Boot** y base de datos en **postgreSQL**.

### Comencemos!
1. Entra a la carpeta del proyecto y abre la carpeta *server* luego corre **Application.java** esto iniciara la aplicación el el puerto *port 8083* la url completa debe ser `http://localhost:8083`.

1. Get all user path - Read
   - /user/all
2. Register usere path - Create
   - /register/user
3. Delete user path - Delete
   - /delete/user/{*userEmail*}
4. Update user path - Update
   - /update/user

### Base de datos(postgreSQL) - medic_shopping
```
CREATE TABLE users(
   user_Email VARCHAR (100) PRIMARY KEY,
   user_Address INT NOT NULL,
   user_Password VARCHAR (30) NOT NULL,
   user_FCM_Token VARCHAR (50) NOT NULL,
   user_Name VARCHAR (50) NOT NULL,
   user_Last VARCHAR (101) NOT NULL,
   user_Cellphone INT NOT NULL,
   user_URL_Picture VARCHAR (500) NOT NULL,
   user_Type VARCHAR (1) NOT NULL,
   User_Pharmacy INT NOT NULL
);
--INSERT INTO users VALUES('alex@gmail.com', 1, 'asdf1357', 'token1', 'Alex', 'Loaiza', 6677550033, 'alex.png', 'U', 1);
```

```
CREATE TABLE products(
   productID serial PRIMARY KEY,
   categoryID INT NOT NULL,
   product_Name VARCHAR (100) NOT NULL,
   active_Substance VARCHAR (50) NOT NULL,
   brand VARCHAR (50) NOT NULL,
   product_Description VARCHAR (250) NOT NULL,
   unit_Price DOUBLE PRECISION NOT NULL,
   product_URL_Picture VARCHAR (500) NOT NULL,
   product_Status BOOL NOT NULL
);

```

```
CREATE TABLE shoppingcart(
   user_Email VARCHAR (100) NOT NULL,
   productID INT NOT NULL,
   quantity INT NOT NULL,
   shoppingcart_Status BOOL NOT NULL,
   PRIMARY KEY(user_Email,productID),
   CONSTRAINT fk_users
      FOREIGN KEY(user_Email) 
	      REFERENCES users(user_Email),
   CONSTRAINT fk_products
      FOREIGN KEY(productID) 
	      REFERENCES products(productID)
);
--INSERT INTO shoppingcart VALUES('alex3@gmail.com', 2, 10, true);

```
