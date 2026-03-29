INSERT INTO customers (id, first_name, last_name, email, phone, address) VALUES
  (1, 'Nimal', 'Perera', 'nimal.perera@example.com', '0771234567', 'Colombo'),
  (2, 'Kamal', 'Silva', 'kamal.silva@example.com', '0719876543', 'Kandy'),
  (3, 'Ayesha', 'Fernando', 'ayesha.fernando@example.com', '0765554433', 'Galle');

ALTER TABLE customers ALTER COLUMN id RESTART WITH 4;
