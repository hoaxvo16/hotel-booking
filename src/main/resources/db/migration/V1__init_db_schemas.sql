CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE hotel
(
    id            BIGINT  NOT NULL,
    name          VARCHAR(255),
    code          VARCHAR(255),
    phone_number  VARCHAR(255),
    email         VARCHAR(255),
    is_available  BOOLEAN NOT NULL,
    location_code VARCHAR(255),
    CONSTRAINT pk_hotel PRIMARY KEY (id)
);

CREATE TABLE location
(
    code  VARCHAR(255) NOT NULL,
    city  VARCHAR(255),
    state VARCHAR(255),
    CONSTRAINT pk_location PRIMARY KEY (code)
);

CREATE TABLE payment
(
    id             BIGINT NOT NULL,
    status         VARCHAR(255),
    method         VARCHAR(255),
    amount         BIGINT,
    currency       VARCHAR(255),
    created_date   TIMESTAMP with time zone,
    completed_date TIMESTAMP with time zone,
    reservation_id BIGINT,
    CONSTRAINT pk_payment PRIMARY KEY (id)
);

CREATE TABLE reservation
(
    id             BIGINT NOT NULL,
    check_in_date  TIMESTAMP with time zone,
    check_out_date TIMESTAMP with time zone,
    price          BIGINT,
    is_canceled    BOOLEAN,
    cancel_reason  VARCHAR(255),
    user_id        BIGINT,
    room_id        BIGINT,
    CONSTRAINT pk_reservation PRIMARY KEY (id)
);

CREATE TABLE role
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE room
(
    id              BIGINT NOT NULL,
    capacity        INTEGER,
    room_number     VARCHAR(255),
    type            VARCHAR(255),
    price_per_night BIGINT,
    currency        VARCHAR(255),
    hotel_id        BIGINT NOT NULL,
    CONSTRAINT pk_room PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (role_id, user_id)
);

CREATE TABLE users
(
    id           BIGINT NOT NULL,
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    email        VARCHAR(255),
    phone_number VARCHAR(255),
    password     VARCHAR(255),
    is_enabled   BOOLEAN,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE hotel
    ADD CONSTRAINT uc_hotel_code UNIQUE (code);

ALTER TABLE reservation
    ADD CONSTRAINT uc_reservation_room UNIQUE (room_id);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_phone_number UNIQUE (phone_number);

ALTER TABLE hotel
    ADD CONSTRAINT FK_HOTEL_ON_LOCATION_CODE FOREIGN KEY (location_code) REFERENCES location (code);

ALTER TABLE payment
    ADD CONSTRAINT FK_PAYMENT_ON_RESERVATION FOREIGN KEY (reservation_id) REFERENCES reservation (id);

ALTER TABLE reservation
    ADD CONSTRAINT FK_RESERVATION_ON_ROOM FOREIGN KEY (room_id) REFERENCES room (id);

ALTER TABLE reservation
    ADD CONSTRAINT FK_RESERVATION_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE room
    ADD CONSTRAINT FK_ROOM_ON_HOTEL FOREIGN KEY (hotel_id) REFERENCES hotel (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES role (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);