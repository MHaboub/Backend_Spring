-- Admin user (password = "admin123")
INSERT INTO users (username, password, role) VALUES 
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EHsM8', 'ADMIN');

-- Reset test users with proper BCrypt-encoded passwords
UPDATE users SET password = '$2a$10$ckC0Cxs4YFqZfISGfk1Lz.B8kF8krt.6ux6xmB0HGHLe3wZuu8NYu' WHERE username = 'habib'; -- password = 'admin123'
UPDATE users SET password = '$2a$10$ckC0Cxs4YFqZfISGfk1Lz.B8kF8krt.6ux6xmB0HGHLe3wZuu8NYu' WHERE username = 'habayb'; -- password = 'admin123'
UPDATE users SET password = '$2a$10$ckC0Cxs4YFqZfISGfk1Lz.B8kF8krt.6ux6xmB0HGHLe3wZuu8NYu' WHERE username = 'fedy'; -- password = 'admin123'