CREATE DATABASE IF NOT EXISTS fullstack;
USE fullstack;

-- Create User table
CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    );

-- Insert sample data (optional)
INSERT INTO User (username, name, email) VALUES
    ('user1', 'John Doe', 'john@example.com'),
    ('user2', 'Jane Doe', 'jane@example.com');