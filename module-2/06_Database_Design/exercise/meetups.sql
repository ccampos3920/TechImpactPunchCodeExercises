BEGIN TRANSACTION;

DROP TABLE IF EXISTS member, interest_group, event, interest_group_member, event_member CASCADE;

CREATE TABLE member(
member_number serial,
last_name char (50) NOT NULL,
first_name char (50) NOT NULL,
email_address varchar(100) NOT NULL,
phone_number int (15),
dob date NOT NULL,
email_check boolean NOT NULL,

CONSTRAINT PK_member PRIMARY KEY (member_number);
);

CREATE TABLE interest_group(
group_id serial,
group_name varchar(50) NOT NULL,
members int NOT NULL,

CONSTRAINT PK_group_number PRIMARY KEY interest_group(group_number),
CONSTRAINT UQ_group_name UNIQUE (group_name),
);

CREATE TABLE event(
event_number serial,
event_name varchar(50) NOT NULL,
description text,
start_date date NOT NULL,
start_time time NOT NULL,
duration int NOT NULL,
group_id int NOT NULL,

CONSTRAINT PK_event PRIMARY KEY(event_number),
CONSTRAINT FK_event_group_id FOREIGN KEY(group_id) REFERENCES interest_group(group_id),
CONSTRAINT CHK_duration CHECK(duration >= 30),
);

CREATE TABLE interest_group_member (
	group_id int NOT NULL,
	member_number int NOT NULL,
	CONSTRAINT PK_interest_group_member PRIMARY KEY (group_id, member_number),
	CONSTRAINT FK_interest_group_member_interest_group FOREIGN KEY (group_id) REFERENCES interest_group(group_id),
	CONSTRAINT FK_interest_group_member_member FOREIGN KEY (member_number) REFERENCES member(member_number)
);

CREATE TABLE event_member (
	event_id int NOT NULL,
	member_id int NOT NULL,
	CONSTRAINT PK_event_member PRIMARY KEY (event_number, member_number),
	CONSTRAINT FK_event_member_event FOREIGN KEY (event_number) REFERENCES event(event_number),
	CONSTRAINT FK_event_member_member FOREIGN KEY (member_id) REFERENCES member(member_number)
);

CREATE TABLE

-- Events --
INSERT INTO event(event_name, start_date, start_time, duration, group_id)
VALUES('LAN Party', '2022-30-06', '18:00', 35, 1);

INSERT INTO event(event_name, start_date, start_time, duration, group_id)
VALUES('Korean BBQ Party', '2022-20-07', '17:00', 120, 2);

INSERT INTO event(event_name, start_date, start_time, duration, group_id)
VALUES('Movie Showcase: Blade Runner', '2022-22-09', '19:00', 180, 3);

INSERT INTO event(event_name, start_date, start_time, duration, group_id)
VALUES('Movie Showcase: Star Wars: Revenge of the Sith', '2022-13-11', '18:00', 180, 4);

--Group names --
INSERT INTO interest_group(group_id,group_name,members)
VALUES(1, 'Boston Uprising', 20);

INSERT INTO interest_group(group_id,group_name,members)
VALUES(2, 'The Boys', 10);

INSERT INTO interest_group(group_id,group_name,members)
VALUES(3, 'The Movie Critics', 7);

INSERT INTO interest_group(group_id,group_name,members)
VALUES(4, 'Star Wars Fans United', 8);

-- Member Names --
INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Gonazales', 'Juan', 'ElRancho@ElSuper.com', '1984-10-02', true);

INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Gomez', 'Estaban', 'ElCuh24@ElSuper.com', '2001-04-08', true);

INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Carlos', 'John', 'N/A', '2005-03-08', false);

INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Alvarez', 'Jaime', 'N/A', '1984-03-08', false);

INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Ignacio', 'Tete', 'N/A', '1984-03-08', false);

INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Smith', 'John', 'gijng@gmail.com', '1989-03-08', true);

INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Orange', 'Kiwi', 'N/A', '1989-03-08', true);

INSERT INTO member(last_name, first_name, email_address, dob, email_check)
VALUES('Ribeye', 'Banana', 'N/A', '1992-06-09', false);

COMMIT;