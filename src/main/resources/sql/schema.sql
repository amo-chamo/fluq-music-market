-- USER, ARTIST, ADMIN

CREATE TABLE users
(
    id                SERIAL       NOT NULL PRIMARY KEY,
    username          VARCHAR(100) NOT NULL UNIQUE,
    email             VARCHAR(100) NOT NULL UNIQUE,
    password_hash     TEXT         NOT NULL,
    balance           NUMERIC(10, 2)        DEFAULT 0.00,
    registration_date DATE         NOT NULL DEFAULT CURRENT_DATE
);


CREATE TABLE artists
(
    id              SERIAL PRIMARY KEY,
    artist_name     VARCHAR(100) NOT NULL UNIQUE,
    bio             TEXT           DEFAULT NULL,
    email           VARCHAR(100) NOT NULL UNIQUE,
    password_hash   TEXT         NOT NULL,
    total_earnings  NUMERIC(10, 2) DEFAULT 0.00,
    is_verified     BOOLEAN        DEFAULT FALSE,
    created_at      DATE           DEFAULT CURRENT_DATE,
    profile_picture BYTEA
);


CREATE TABLE admin
(
    id            SERIAL PRIMARY KEY,
    email         VARCHAR(100) NOT NULL UNIQUE,
    password_hash TEXT         NOT NULL
);


-- ARTIST RELATED

CREATE TYPE request_status AS ENUM ('PENDING', 'APPROVED', 'REJECTED');

CREATE TABLE registration_request
(
    id           SERIAL PRIMARY KEY,
    artist_id    INTEGER NOT NULL UNIQUE REFERENCES artists (id) ON DELETE CASCADE,
    status       request_status DEFAULT 'PENDING',
    submitted_at TIMESTAMP      DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE upload_request
(
    id               SERIAL PRIMARY KEY,
    artist_id        INTEGER      NOT NULL REFERENCES artists (id) ON DELETE CASCADE,
    title            VARCHAR(100) NOT NULL,
    price            NUMERIC(10, 2) DEFAULT 0.00,
    duration_seconds INTEGER      NOT NULL,
    release_year     INTEGER      NOT NULL,
    music_file       BYTEA        NOT NULL,
    preview_file     BYTEA        NOT NULL,
    cover_image      BYTEA        NOT NULL,
    status           request_status DEFAULT 'PENDING',
    submitted_at     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE track
(
    id               SERIAL PRIMARY KEY,
    artist_id        INTEGER      NOT NULL REFERENCES artists (id) ON DELETE CASCADE,
    title            VARCHAR(100) NOT NULL,
    price            NUMERIC(10, 2) DEFAULT 0.00,
    duration_seconds INTEGER      NOT NULL,
    release_year     INTEGER      NOT NULL,
    music_file       BYTEA        NOT NULL,
    preview_file     BYTEA        NOT NULL,
    cover_image      BYTEA        NOT NULL
);


-- USER RELATED

CREATE TABLE cart
(
    id      SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE REFERENCES users (id) ON DELETE CASCADE
);


CREATE TABLE wishlist
(
    id      SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE REFERENCES users (id) ON DELETE CASCADE
);


CREATE TABLE library
(
    id      SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE REFERENCES users (id) ON DELETE CASCADE
);


CREATE TABLE playlist
(
    id               SERIAL PRIMARY KEY,
    library_id       INTEGER NOT NULL REFERENCES library (id) ON DELETE CASCADE,
    name             TEXT    NOT NULL DEFAULT 'New Playlist',
    is_uncategorized BOOLEAN          DEFAULT FALSE
);


CREATE TABLE credit_card
(
    id          SERIAL PRIMARY KEY,
    card_number VARCHAR(19) NOT NULL,
    holder_name TEXT        NOT NULL,
    expiry_date VARCHAR(5)  NOT NULL,
    cvc_hash    TEXT        NOT NULL
);

CREATE TYPE transaction_type AS ENUM ('FUND ADD', 'PURCHASE');

CREATE TYPE payment_method AS ENUM ('FUNDS', 'CARD');

CREATE TABLE transaction
(
    id             SERIAL PRIMARY KEY,
    user_id        INTEGER          NOT NULL REFERENCES users (id) ON DELETE NO ACTION,
    type           transaction_type NOT NULL,
    amount         NUMERIC(10, 2)   NOT NULL,
    payment_method payment_method   NOT NULL,
    card_id        INTEGER REFERENCES credit_card (id) ON DELETE NO ACTION,
    datetime       TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    details        TEXT             NOT NULL
);


-- MAPPING TABLES

CREATE TABLE user_credit_card
(
    user_id INTEGER NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    card_id INTEGER NOT NULL REFERENCES credit_card (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, card_id)
);


CREATE TABLE playlist_tracks
(
    playlist_id INTEGER NOT NULL REFERENCES playlist (id) ON DELETE CASCADE,
    track_id    INTEGER NOT NULL REFERENCES track (id) ON DELETE CASCADE,
    PRIMARY KEY (playlist_id, track_id)
);


CREATE TABLE cart_tracks
(
    cart_id  INTEGER NOT NULL REFERENCES cart (id) ON DELETE CASCADE,
    track_id INTEGER NOT NULL REFERENCES track (id) ON DELETE CASCADE,
    PRIMARY KEY (cart_id, track_id)
);


CREATE TABLE wishlist_tracks
(
    wishlist_id INTEGER NOT NULL REFERENCES wishlist (id) ON DELETE CASCADE,
    track_id    INTEGER NOT NULL REFERENCES track (id) ON DELETE CASCADE,
    PRIMARY KEY (wishlist_id, track_id)
);