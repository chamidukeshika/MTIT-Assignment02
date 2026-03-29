INSERT INTO orders (id, customer_id, product_id, quantity, total_amount, order_status) VALUES
  (1, 1, 1, 1, 250000.00, 'PENDING'),
  (2, 2, 2, 2, 7000.00, 'CONFIRMED'),
  (3, 3, 3, 1, 12500.00, 'SHIPPED');

ALTER TABLE orders ALTER COLUMN id RESTART WITH 4;
