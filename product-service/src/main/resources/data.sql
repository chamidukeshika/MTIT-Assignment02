INSERT INTO products (id, name, category, description, price, status) VALUES
  (1, 'Laptop', 'Electronics', '15 inch business laptop', 250000.00, 'AVAILABLE'),
  (2, 'Mouse', 'Accessories', 'Wireless mouse', 3500.00, 'AVAILABLE'),
  (3, 'Keyboard', 'Accessories', 'Mechanical keyboard', 12500.00, 'AVAILABLE');

ALTER TABLE products ALTER COLUMN id RESTART WITH 4;
