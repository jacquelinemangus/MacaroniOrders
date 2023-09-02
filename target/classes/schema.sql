DROP TABLE IF EXISTS cheese_order;
DROP TABLE IF EXISTS macaroni_orders;
DROP TABLE IF EXISTS noodle_shape;
DROP TABLE IF EXISTS cheese;
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  customer_id INT AUTO_INCREMENT NOT NULL,
  customer_order INT NOT NULL,
  customer_first_name VARCHAR(128) NOT NULL,
  customer_last_name VARCHAR(128) NOT NULL,
  customer_email VARCHAR(128) NOT NULL,
  PRIMARY KEY (customer_id)
);
CREATE TABLE cheese (
  cheese_id INT AUTO_INCREMENT NOT NULL,
  cheese_type VARCHAR(128) NOT NULL,
  cheese_region VARCHAR(128) NOT NULL,
  cheese_spice_level VARCHAR(128) NOT NULL,
  PRIMARY KEY (cheese_id)
);
CREATE TABLE noodle_shape (
  noodle_shape_id INT AUTO_INCREMENT NOT NULL,
  macaroni TEXT NOT NULL,
  rotini TEXT NOT NULL,
  farfalle TEXT NOT NULL,
  PRIMARY KEY (noodle_shape_id)
);
CREATE TABLE macaroni_orders (
  macaroni_order_id INT AUTO_INCREMENT NOT NULL,
  noodle_shape_id INT NOT NULL,
  customer_id INT NOT NULL,
  herb_topping_choice VARCHAR(128) NOT NULL,
  PRIMARY KEY (macaroni_order_id),
  FOREIGN KEY (noodle_shape_id) REFERENCES noodle_shape (noodle_shape_id) ON DELETE CASCADE,
  FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);
CREATE TABLE cheese_order (
  macaroni_order_id INT NOT NULL,
  cheese_id INT NOT NULL,
  FOREIGN KEY (macaroni_order_id) REFERENCES macaroni_orders (macaroni_order_id) ON DELETE CASCADE,
  FOREIGN KEY (cheese_id) REFERENCES cheese (cheese_id) ON DELETE CASCADE,
  UNIQUE KEY (macaroni_order_id, cheese_id)
);
