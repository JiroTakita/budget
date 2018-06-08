DROP TABLE IF EXISTS Budget;
CREATE TABLE Budget (
  id   IDENTITY,
  NAME VARCHAR(50),
  DATE DATE NOT null,
  COST DECIMAL,
  PAYMENTTYPE INTEGER default 0,
  TYPE boolean NOT Null,
  SUFFIX boolean NOT Null Default true,
  DIFFERENCIES DECIMAL NOT null Default 0.00,
  ADD BOOLEAN NOT Null Default true,
  MEMO TEXT Default '',
  SETTINGID INTEGER Not null,
  CREATEDATE DATE NOT Null default now(),
  UPDATEDATE DATE NOT Null default now(),
  VALID BOOLEAN NOT Null Default true
);

DROP TABLE IF EXISTS Settings;
CREATE TABLE Settings (
	id	IDENTITY,
	STARTDATE INTEGER,
	DEFAULTTYPE boolean NOT null default true,
	GROUPNAME VARCHAR(50) NOT Null,
	CREATEDATE DATE NOT Null default now(),
	UPDATEDATE DATE NOT Null default now(),
	VALID BOOLEAN NOT Null Default true
);

DROP TABLE IF EXISTS User;
CREATE TABLE User (
	id IDENTITY,
	userId VARCHAR(50) NOT Null,
	name VARCHAR(100) NOT Null,
	password VARCHAR(100) NOT Null,
	email VARCHAR(100) NOT Null,
	role VARCHAR(50) NOT Null,
	CREATEDATE DATE NOT Null default now(),
	UPDATEDATE DATE NOT Null default now(),
	VALID BOOLEAN NOT Null Default true
);

DROP TABLE IF EXISTS Categories;
CREATE TABLE Categories (
	id IDENTITY,
	mainName VARCHAR(50) NOT Null,
	parentId INTEGER NOT Null default 0,
	orderNumber INTEGER NOT Null default 0,
	type BOOLEAN NOT Null,
	deletable BOOLEAN NOT Null default true,
	CREATEDATE DATE NOT Null default now(),
	UPDATEDATE DATE NOT Null default now(),
	VALID BOOLEAN NOT Null Default true
);
