drop schema if exists myBank;

CREATE TABLE users
(
    id         serial primary key,
    first_name varchar(20),
    last_name  varchar(20),
    email      varchar(255) unique,
    role       enum("CUSTOMER", "ADMIN"),
    password   varchar(255) not null,
    isActive   boolean,

);
CREATE TABLE account
(
    id       serial primary key,
    number   varchar(255),
    balance  decimal(15, 2),
    isActive boolean,
    user_id  bigint,
    foreign key (user_id) references user_data (id)

);
CREATE TABLE card
(
    id             serial primary key,
    card_name      enum ("UNIVERSAL", "CREDIT", "GOLD"),
    number         bigint,
    card_condition enum("ACTIVE", "BLOCKED", "PENDING"),
    accountId      bigint,
    foreign key (accountId) references account (id)

);
CREATE TABLE payment
(
    id                serial primary key,
    date              datetime,
    debit_account_id  bigint,
    credit_account_id bigint,
    amount            decimal(15, 2),
    description       varchar(255),
    status            enum("SAVE", "PAID", "PENDING"),
    foreign key (debit_account_id) references account (id),
    foreign key (credit_account_id) references account (id)
);

