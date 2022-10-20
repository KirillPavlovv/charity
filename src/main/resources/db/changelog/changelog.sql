--liquibase formatted sql
--changeset charity:202210201200

CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NOT NULL
);

CREATE TABLE products
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(50) NOT NULL,
    price     DECIMAL(4, 2),
    quantity  NUMERIC,
    image     VARCHAR(100),
    is_edible BOOLEAN DEFAULT FALSE
);

CREATE TABLE orders
(
    id          UUID PRIMARY KEY,
    user_id     UUID REFERENCES users (id),
    total_price DECIMAL(5, 2)
);

CREATE TABLE order_line
(
    id         UUID PRIMARY KEY,
    order_id   UUID REFERENCES orders (id),
    product_id UUID REFERENCES products (id),
    quantity   NUMERIC
);

--changeset charity:202210201532

INSERT INTO users (id, first_name, last_name, email)
VALUES ('dce2d43e-cfc5-4297-a7e2-bd80535b5cca', 'Erki', 'Rebane', 'erkirebane@gmail.com');
INSERT INTO users (id, first_name, last_name, email)
VALUES ('af50bdb2-fcf9-4ce5-af72-9068a065b0d0', 'Ilvar', 'Rei', 'ilvar@gmail.com');
INSERT INTO users (id, first_name, last_name, email)
VALUES ('474f1e0d-123a-4326-8e7c-5599a88220c5', 'Mait', 'Hunt', 'maint@gmail.com');

INSERT INTO products (id, name, price, quantity, image, is_edible)
VALUES ('fde8d814-598e-4e4b-83b3-d612f3d7a31b', 'Brownie', 0.65, 48, 'brownie.jpg', true);
INSERT INTO products (id, name, price, quantity, image, is_edible)
VALUES ('7af0f84d-e85c-4ea6-969d-f1a2d644a6d4', 'Muffin', 1.00, 36, 'muffin.jpg', true);
INSERT INTO products (id, name, price, quantity, image, is_edible)
VALUES ('879bc36c-e946-4673-a668-a48e24d21089', 'Cake Pop', 1.35, 24, 'cake_pop.jpg', true);
INSERT INTO products (id, name, price, quantity, image, is_edible)
VALUES ('a9f4cfdb-ac39-4fb8-91d0-90e24d66d33e', 'Apple tart', 1.50, 60, 'apple_tart.jpg', true);
INSERT INTO products (id, name, price, quantity, image, is_edible)
VALUES ('067934b8-92cd-4b4a-8e45-f433f7066826', 'Water', 1.50, 30, 'water.jpg', true);

