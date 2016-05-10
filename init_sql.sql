CREATE TABLE country (
    country_id INT UNSIGNED NOT NULL,
    country VARCHAR(100) NOT NULL,
    PRIMARY KEY (country_id)
);

CREATE TABLE city (
    city_id INT UNSIGNED NOT NULL,
    city VARCHAR(100) NOT NULL,
    country_id INT UNSIGNED NOT NULL REFERENCES country(country_id),
    PRIMARY KEY (city_id)
);

CREATE TABLE permissions (
    permission_id INT UNSIGNED NOT NULL,
    permission VARCHAR(100) NOT NULL,
    PRIMARY KEY (permission_id)
);

CREATE TABLE group_names (
    group_id INT UNSIGNED NOT NULL,
    group_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (group_id)
);

CREATE TABLE group_permission (
    group_id INT UNSIGNED NOT NULL REFERENCES group_names(group_id),
    permission_id INT UNSIGNED NOT NULL REFERENCES permissions(permission_id),
    PRIMARY KEY (group_id, permission_id)
);

CREATE TABLE userdetails (
    fname VARCHAR(100) NOT NULL,
    lname VARCHAR(100) DEFAULT NULL,
    dob date NOT NULL,
    country enum('Sri Lanka','Japan','United Kingdom','United States','Australia') NOT NULL,
    email VARCHAR(100) NOT NULL,
    city_id INT UNSIGNED NOT NULL REFERENCES city(city_id),
    group_id INT UNSIGNED NOT NULL REFERENCES group_names(group_id),
    mnumber BIGINT(11) UNSIGNED NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (username)
);

