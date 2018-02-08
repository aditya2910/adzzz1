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


CREATE TABLE dataentry_rm_inward_master (
	id varchar(60) NOT NULL,
    no_of_items varchar(255) NOT NULL,
    date_of_entry varchar(255) NOT NULL,
    supplier_code varchar(255) NOT NULL,
    godown_code varchar(255) NOT NULL,
    dispatched_from varchar(255) NOT NULL,
    recceived_at varchar(255) NOT NULL,
    challan_no varchar(255) NOT NULL,
    challan_date varchar(255) NOT NULL,
    vehicle_type varchar(255) NOT NULL,
    vehicle_no varchar(255) NOT NULL,
    waybill_no varchar(255) NOT NULL,
    advance_freight_amount varchar(255) NOT NULL,
    total_amount varchar(255) NOT NULL,
    factory_code varchar(255) NOT NULL,
    transporter_name varchar(255) NOT NULL,
    transporter_address varchar(255) NOT NULL,
    transporter_phone varchar(255) NOT NULL,
    identifier varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE dataentry_rm_inward (
	de_id varchar(60) NOT NULL,
	identifier varchar(60) NOT NULL,
	id varchar(60) NOT NULL,
	PRIMARY KEY (de_id),
	FOREIGN KEY (id) REFERENCES dataentry_rm_inward_master(id)
);
-- RAW Material - Inward Data Entry
{
	"noOfItems": "2",
	"dateOfEntry": "06-02-2018",
	"supplierCode": "7e008080616a579a01616a5bd52a0001",
	"godownCode": "7e008080616a579a01616a5bd52a0002",
	"dispatchedFrom": "Allahabad",
	"recceivedAt": "Pakur",
	"challanNo": "abc/de/123",
	"challanDate": "02-02-2018",
	"vehicleType": "truck",
	"vehicleNo": "UP-12J-5257",
	"waybillNo": "002-123-01",
	"advanceFreightAmount": "2000",
	"totalAmount": "10000",
	"factoryCode": "7e008080616a579a01616a5bd52a0003",
	"transporterName": "Transporter Name 1",
	"transporterAddress": "#12, Trinity road, Lukhnow-560037, U.P.",
	"transporterPhone": "1234567890",
	"rawMaterialInwardDataEntries": [
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagQuantity": "21",
			"unitQuantity": "41",
			"valueRupees": "34341"
		},
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagQuantity": "21",
			"unitQuantity": "41",
			"valueRupees": "34341"
		},
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagQuantity": "21",
			"unitQuantity": "41",
			"valueRupees": "34341"
		}
		
	]
}



-- RAW Material - WareHouse Transfer Data Entry
{
	"challanNo": "abc/de/123",
	"receivedOrIssuedDate": "06-02-2018",
	"receiverGodownCode": "7e008080616a579a01616a5bd52a0001",
	"issuerGodownCode": "7e008080616a579a01616a5bd52a0002",
	"vehicleType": "truck",
	"vehicleNo": "WB-12J-5257",
	"transporterName": "Transporter Name 1",
	"transporterAddress": "#12, Trinity road, Lukhnow-560037, U.P.",
	"transporterPhone": "1234567890",
	"noOfItems": "5",
	"rawMaterialWarehouseTransferDataEntries": [
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagUnit": "1",
			"rate": "1",
			"grossWeight": "1",
			"quantityInWeight": "1",
			"valueRupees": "1"
		},
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagUnit": "1",
			"rate": "1",
			"grossWeight": "1",
			"quantityInWeight": "1",
			"valueRupees": "1"
		},
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagUnit": "1",
			"rate": "1",
			"grossWeight": "1",
			"quantityInWeight": "1",
			"valueRupees": "1"
		}
		
	]
}


--http://localhost:8082/rawMaterialIssueForConsumptionDataEntry
{
	"dateOfEntry": "06-02-2018",
	"challanNo": "abc/de/123",
	"challanDate": "02-02-2018",
	"godownCode": "7e008080616a579a01616a5bd52a0003",
	"noOfItems": "51",
	"rawMaterialIssueForConsumptionDataEntries": [
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagQuantity": "21",
			"quantityInWeight": "41"
		},
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagQuantity": "21",
			"quantityInWeight": "41"
		},
		{
			"rmCode": "ab121",
			"rmType": "type1",
			"bagQuantity": "21",
			"quantityInWeight": "41"
		}
		
	]
}

