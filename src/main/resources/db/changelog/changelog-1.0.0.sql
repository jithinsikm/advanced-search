CREATE TABLE tbl_employees (
    id UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT,
    salary DOUBLE PRECISION,
    bonus DECIMAL(10, 2),
    is_active BOOLEAN,
    created_date TIMESTAMP,
    PRIMARY KEY (id)
);