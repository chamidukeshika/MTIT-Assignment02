INSERT INTO inventory (id, product_id, quantity_available, warehouse_location, stock_status) VALUES
  (1, 1, 25, 'Warehouse A', 'IN_STOCK'),
  (2, 2, 75, 'Warehouse B', 'IN_STOCK'),
  (3, 3, 10, 'Warehouse A', 'LOW_STOCK');

ALTER TABLE inventory ALTER COLUMN id RESTART WITH 4;
