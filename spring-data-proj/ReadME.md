This project is a sqample wireframe of spring-boot-spring-data using MySQL underlying.



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



