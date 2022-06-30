CREATE TABLE member(
member_number serial,
last_name char(50) NOT NULL,
first_name char (50) NOT NULL,
email_address varchar(100) NOT NULL,
phone_number int (15),
dob date NOT NULL,
flag_email boolean NOT NULL,
CONSTRAINT PK_member PRIMARY KEY (member_number)
);

CREATE TABLE interest_group(
group_number serial,
group_name varchar(50) NOT NULL;
members int NOT NULL,
CONSTRAINT PK_interest_group PRIMARY KEY (group_number),
CONSTRAINT UQ_interest_group_group_name UNIQUE (group_name),
);

CREATE TABLE event(
event_number serial,
event_name varchar(50) NOT NULL,
description varchar(150) NOT NULL,
start_date date NOT NULL,
start_time time NOT NULL,
duration int NOT NULL,
group_id int NOT NULL,
CONSTRAINT PK_event PRIMARY KEY (event_number),
CONSTRAINT FK_group_id FOREIGN KEY (group_number),
CONSTRAINT CHK_duration CHECK (duration >= 30),
);