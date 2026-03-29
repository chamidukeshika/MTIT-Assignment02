INSERT INTO payments (id, order_id, amount, payment_method, payment_status) VALUES
  (1, 1, 250000.00, 'CARD', 'PAID'),
  (2, 2, 7000.00, 'CASH_ON_DELIVERY', 'PENDING'),
  (3, 3, 12500.00, 'BANK_TRANSFER', 'PAID');

ALTER TABLE payments ALTER COLUMN id RESTART WITH 4;
