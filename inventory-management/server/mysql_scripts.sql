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
-- RAW Material - Inward Data Entry -- http://localhost:8082/rawMaterialInwardDataEntry
{
	"noOfItems": "1",
	"dateOfEntry": "08-02-2018",
	"supplierCode": "7e0080806175ae05016175c6984d0022",
	"godownCode": "7e0080806175ae05016175af00ef0000",
	"dispatchedFrom": "Gujarat",
	"recceivedAt": "Pakur",
	"challanNo": "abc/de/123",
	"challanDate": "02-02-2018",
	"vehicleType": "truck",
	"vehicleNo": "UP-12J-5257",
	"waybillNo": "002-123-01",
	"advanceFreightAmount": "2000",
	"totalAmount": "10000",
	"factoryCode": "7e0080806175ae05016175cff18e0024",
	"transporterName": "Transporter Name 1",
	"transporterAddress": "#12, Trinity road, Lukhnow-560037, U.P.",
	"transporterPhone": "1234567890",
	"rawMaterialInwardDataEntries": [
		{
			"rmCode": "4028abfe6175980b0161759b41cb0002",
			"rmType": "Bags",
			"bagQuantity": "21",
			"unitQuantity": "500KG",
			"valueRupees": "100000"
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
	"dateOfEntry": "08-02-2018",
	"challanNo": "abc/de/123",
	"challanDate": "02-02-2018",
	"godownCode": "7e0080806175ae05016175b237170004",
	"brandCode": "7e0080806175ae05016175bbb0b70017",
	"noOfItems": "8",
	"rawMaterialIssueForConsumptionDataEntries": [
		{
			"rmCode": "4028abfe6175980b0161759c9a4d0005",
			"rmType": "new gunny bags",
			"bagQuantity": "5Piece",
			"quantityInWeight": ""
		},
		{
			"rmCode": "4028abfe6175980b0161759d1d700007",
			"rmType": "cartoon",
			"bagQuantity": "10Piece",
			"quantityInWeight": ""
		},
		{
			"rmCode": "7e0080806175ae05016175fa423a002d",
			"rmType": "gum tape",
			"bagQuantity": "1RL",
			"quantityInWeight": ""
		},
		{
			"rmCode": "4028abfe6175980b0161759f82780008",
			"rmType": "soft coal",
			"bagQuantity": "",
			"quantityInWeight": "30KG"
		},
		{
			"rmCode": "4028abfe6175980b0161759f9d8c0009",
			"rmType": "char coal",
			"bagQuantity": "",
			"quantityInWeight": "60KG"
		},
		{
			"rmCode": "4028abfe6175980b0161759fdac1000a",
			"rmType": "chemical starch",
			"bagQuantity": "",
			"quantityInWeight": "2KG"
		},
		{
			"rmCode": "4028abfe6175980b016175a273090011",
			"rmType": "No 25 Tissue",
			"bagQuantity": "10800Piece",
			"quantityInWeight": ""
		},
		{
			"rmCode": "4028abfe6175980b016175a2912a0012",
			"rmType": "No 25 craft",
			"bagQuantity": "540Piece",
			"quantityInWeight": ""
		}
	]
}






--> http://localhost:8082/contractorSlipDataEntry
{
	"dateOfEntry": "06-02-2018",
	"transactionNo": "test/txn/1234",
	"contractorCode": "M01",
	"productGodownCode": "7e008080616a579a01616a5bd52a0012",
	"checkerCode": "7e008080616a579a01616a5bd52a0011",
	"passedByCheckerCode": "7e008080616a579a01616a5bd52a0014",
	"noOfCheckers": "2",
	"consumptionRate": "0.580",
	"givenTobaccoQuantity": "50KG",
	"givenLeavesQuantity": "10KG",
	"givenLeavesBagQuantity": "2KG",
	"givenYarnQuantity": "5KG",
	"givenLeavesQuantity": "10KG",
	"challanNo": "abc/de/123",
	"givenConsumptionRate": "0.580",
	"contractorSlipEntryDataEntries": [
		{
			"checkerCode": "7e008080616a579a01616a5bd52a0015",
			"checkerName": "Aditya Checker",
			"timeFromTo": "1000-1800",
			"neatProductCount": "50000",
			"chhatProductCount": "2000"
		},
		{
			"checkerCode": "7e008080616a579a01616a5bd52a0015",
			"checkerName": "Vikash Checker",
			"timeFromTo": "1000-1800",
			"neatProductCount": "50000",
			"chhatProductCount": "2000"
		}
	]
}