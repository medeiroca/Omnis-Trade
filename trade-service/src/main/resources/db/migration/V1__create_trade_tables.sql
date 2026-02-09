CREATE TABLE orders (
    order_id VARCHAR(255) PRIMARY KEY,
    asset_pair VARCHAR(50) NOT NULL,
    price DECIMAL(18, 8) NOT NULL,
    quantity DECIMAL(18, 8) NOT NULL,
    side VARCHAR(10) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS tokenentry (
    processorname VARCHAR(255) NOT NULL,
    segment INTEGER NOT NULL,
    token BYTEA,
    tokentype VARCHAR(255),
    timestamp VARCHAR(255) NOT NULL,
    owner VARCHAR(255),
    PRIMARY KEY (processorname, segment)
);