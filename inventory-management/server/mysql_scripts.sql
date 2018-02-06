use sbw;

CREATE TABLE raw_material (
    id varchar(60) NOT NULL,
    name varchar(255) NOT NULL,
    type varchar(255) NOT NULL,
    unit varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE rm_types (
    id varchar(60) NOT NULL,
    type varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

insert into rm_types Values("1", "Main");
insert into rm_types Values("2", "Toasting");
insert into rm_types Values("3", "Labeling");
insert into rm_types Values("4", "Packaging");

CREATE TABLE rm_units (
    id varchar(60) NOT NULL,
    unit varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

insert into rm_units Values("1", "kg");
insert into rm_units Values("2", "muttha");
insert into rm_units Values("3", "latti");
insert into rm_units Values("4", "gm");


CREATE TABLE contractor (
    id varchar(60) NOT NULL,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    phone varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE product_brand (
    id varchar(60) NOT NULL,
    name varchar(255) NOT NULL UNIQUE,
    type varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
{
	"name": "Pintu delux",
	"type": "Neat"
}

CREATE TABLE product_type (
    id varchar(60) NOT NULL,
    name varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
{
	"name": "Others"
}


CREATE TABLE rm_godown (
    id varchar(60) NOT NULL,
    name varchar(255) NOT NULL UNIQUE,
    type varchar(255) NOT NULL,
    area varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    phone varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE rm_factory (
    id varchar(60) NOT NULL,
    name varchar(255) NOT NULL UNIQUE,
    type varchar(255) NOT NULL,
    area varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    phone varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
{
	"name": "pakur_fac_02",
	"type": "repo",
	"area": "122222 sq ft",
	"address": "ballavpur",
	"phone": "1234566788"
}


