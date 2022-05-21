CREATE TABLE IF NOT EXISTS orders (
    ID BIGSERIAL PRIMARY KEY,
    TRACKING_NUMBER VARCHAR(255) UNIQUE NOT NULL,
    ITEMS JSONB
);


CREATE TABLE IF NOT EXISTS customer (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    joined_at TIMESTAMP
);