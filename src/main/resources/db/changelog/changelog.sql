--liquibase formatted sql
--changeset charity:202210201200

CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(50)
);

CREATE TABLE products_category
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(50) NOT NULL,
    price     DECIMAL(4, 2),
    image     VARCHAR(255),
    is_edible BOOLEAN DEFAULT FALSE
);

CREATE TABLE products_stock
(
    id       uuid REFERENCES products_category (id),
    quantity NUMERIC CHECK ( quantity>=0 )
);

CREATE TABLE orders
(
    id          UUID PRIMARY KEY,
    user_id     UUID REFERENCES users (id),
    total_price DECIMAL(5, 2)
);

INSERT INTO users (id, first_name, last_name, email)
VALUES ('dce2d43e-cfc5-4297-a7e2-bd80535b5cca', 'Erki', 'Rebane', 'erkirebane@gmail.com');
INSERT INTO users (id, first_name, last_name, email)
VALUES ('af50bdb2-fcf9-4ce5-af72-9068a065b0d0', 'Ilvar', 'Rei', 'ilvar@gmail.com');
INSERT INTO users (id, first_name, last_name, email)
VALUES ('474f1e0d-123a-4326-8e7c-5599a88220c5', 'Mait', 'Hunt', 'maint@gmail.com');

INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('fde8d814-598e-4e4b-83b3-d612f3d7a31b', 'Brownie', 0.65, 'https://upload.wikimedia.org/wikipedia/commons/6/68/Chocolatebrownie.JPG', true);
INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('7af0f84d-e85c-4ea6-969d-f1a2d644a6d4', 'Muffin', 1.00, 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Muffin_NIH.jpg/800px-Muffin_NIH.jpg', true);
INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('879bc36c-e946-4673-a668-a48e24d21089', 'Cake Pop', 1.35, 'https://www.iheartnaptime.net/wp-content/uploads/2020/06/easy-cake-pop-recipe-500x500.jpg', true);
INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('a9f4cfdb-ac39-4fb8-91d0-90e24d66d33e', 'Apple tart', 1.50, 'https://res.cloudinary.com/hksqkdlah/image/upload/22419_sfs-french-apple-tart-15.jpg', true);
INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('067934b8-92cd-4b4a-8e45-f433f7066826', 'Water', 1.50, 'https://www.news-medical.net/image.axd?picture=2021%2F7%2Fshutterstock_1548860402.jpg', true);

INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('df6e78d8-045a-417f-b548-bf6d70a39ffa', 'Shirt', 2.00, 'https://contents.mediadecathlon.com/p1484240/ab565f3675dbdd7e3c486175e2c16583/p1484240.jpg', true);
INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('2f7e6726-89bf-4189-802a-d5ca7b083b2b', 'Pants', 3.00, 'https://w3-offload-yamatomichi-upload.s3.ap-northeast-1.amazonaws.com/wp-content/uploads/2019/02/2022_5-Pocket_Pants_Blue_Gray.jpg', true);
INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('000287f2-5e7f-44aa-8045-12988b2be8b9', 'Jacket', 4.00, 'https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/429453/item/goods_69_429453.jpg?width=1008&impolicy=quality_75', true);
INSERT INTO products_category (id, name, price, image, is_edible)
VALUES ('bc204e15-fcb2-456f-8353-521622d91e01', 'Toy', 1.00, 'https://www.ikea.com/om/en/images/products/fabler-bjoern-soft-toy-beige__0710165_pe727396_s5.jpg?f=s', true);

INSERT INTO products_stock(id, quantity)
VALUES ('fde8d814-598e-4e4b-83b3-d612f3d7a31b', 48);
INSERT INTO products_stock(id, quantity)
VALUES ('7af0f84d-e85c-4ea6-969d-f1a2d644a6d4', 36);
INSERT INTO products_stock(id, quantity)
VALUES ('879bc36c-e946-4673-a668-a48e24d21089', 24);
INSERT INTO products_stock(id, quantity)
VALUES ('a9f4cfdb-ac39-4fb8-91d0-90e24d66d33e', 60);
INSERT INTO products_stock(id, quantity)
VALUES ('067934b8-92cd-4b4a-8e45-f433f7066826', 30);

INSERT INTO products_stock(id, quantity)
VALUES ('df6e78d8-045a-417f-b548-bf6d70a39ffa', 10);
INSERT INTO products_stock(id, quantity)
VALUES ('2f7e6726-89bf-4189-802a-d5ca7b083b2b', 20);
INSERT INTO products_stock(id, quantity)
VALUES ('000287f2-5e7f-44aa-8045-12988b2be8b9', 30);
INSERT INTO products_stock(id, quantity)
VALUES ('bc204e15-fcb2-456f-8353-521622d91e01', 40);


