
This is an incompleteproject.
Its complete version saved in gitlab.

This app creates a bundle with both front end and backend code. Used frontend tach is Angular5 and backend is Spring boot.
Pending: security integration





TODO: main RM consumption rate entry is pending

S E R V E R

This project uses MySql. Its config is stored in application.properties

For Postman call for RawMaterial:
use Content-Type: applicaion/json
and below json
{
	"id": "7ccf6c48-6eac-4cbc-8ba0-c6f2a9f954a4",
	"name": "Yern",
	"unit": "LT",
	"type": "Others"
}


Get RawMaterial call - http://localhost:8082/rawMaterials

For PUT call json:
use Content-Type: applicaion/json
and below json
{
	"id": "7ccf6c48-6eac-4cbc-8ba0-c6f2a9f954a4",
	"name": "Yern",
	"unit": "KG",
	"type": "Others"
}



C L I E N T





