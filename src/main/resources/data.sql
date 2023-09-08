select * from cheese;
select * from customer;
select * from cheese_order;
select * from macaroni_orders;
select * from noodle_shape;

INSERT INTO macaroni_orders.noodle_shape (macaroni, rotini, farfalle) VALUES('test', 'test', 'test');
INSERT INTO macaroni_orders.cheese (cheese_type, cheese_region, cheese_spice_level) VALUES('cheddar', 'england', 'medium');
INSERT INTO macaroni_orders.cheese (cheese_type, cheese_region, cheese_spice_level) VALUES('brie', 'france', 'mild');
INSERT INTO macaroni_orders.cheese (cheese_type, cheese_region, cheese_spice_level) VALUES('american', 'american', 'mild');
INSERT INTO macaroni_orders.cheese (cheese_type, cheese_region, cheese_spice_level) VALUES('colby jack', 'america', 'medium');
INSERT INTO macaroni_orders.macaroni_orders (noodle_shape_id, customer_id, herb_topping_choice) VALUES('1', '1', 'oregano');
INSERT INTO macaroni_orders.macaroni_orders (noodle_shape_id, customer_id, herb_topping_choice) VALUES('2', '2', 'basil');
INSERT INTO macaroni_orders.cheese_order (macaroni_order_id , cheese_id) VALUES('2', '2');
