INSERT INTO shipping (id, order_id, shipping_address, courier_name, tracking_number, shipping_status) VALUES
  (1, 1, 'Colombo 05', 'Domex', 'TRK-1001', 'PROCESSING'),
  (2, 2, 'Kandy', 'Pronto', 'TRK-1002', 'PACKED'),
  (3, 3, 'Galle', 'Domex', 'TRK-1003', 'DELIVERED');

ALTER TABLE shipping ALTER COLUMN id RESTART WITH 4;
