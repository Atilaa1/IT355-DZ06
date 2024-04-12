drop table if exists products,cart;
CREATE TABLE products (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255),
    price DOUBLE
    );
CREATE TABLE cart (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255),
    price DOUBLE
    );

INSERT INTO products (id,name, price) VALUES (1,'Laptop', 799.99);
INSERT INTO products (id,name, price) VALUES (2,'Smartphone', 499.99);
INSERT INTO products (id,name, price) VALUES (3,'Headphones', 99.99);
