# Bee Healthy API


## Register
- rota : /user/register
- método : POST
- Corpo da requisição:

Como patient:
```


{
	"email":"caroline.telles1@gmail.com",
	"password":"1234",
	"fullname":"Caroline Teles",
	"type":"patient"
	"weight":60.5,
	"height":1.60,
	"description":"Carol is a short and chubby girl who wants to be thin",

}

```

Como nutritionist:
```
{
	"specialization":"Sei la",
	"crn":"232623",
	"email":"caroline.telles1@gmail.com",
	"password":"1234",
	"fullname":"Caroline Teles",
	"type":"nutritionist"
}
```

  **Obs:** É muito importante o campo **"type"**, pois ele que define como o usuário será gravado, como nutritionist ou como patient.



## Login
- rota : /user/login
- método : POST
- Corpo da requisição 
```
	{
		"email":"email",
		"password":"password",
		"type":"type" - patient ou nutritionist -
	{
```

O caso os dados apresentados estejam cadastrados, o sistema retornará todos os outros dados com base no tipo que você solicitou, 
caso não cadastrado, retornará 404 User not found.
- Exemplo: Retorno como nutritionist

```
	{
	  "idUser": 2,
	  "email": "caroline.telles1@gmail.com",
	  "password": "1234",
	  "fullname": "Caroline Teles",
	  "birthday": null,
	  "type": "nutritionist",
	  "idNutritionist": 0,
	  "specialization": "Sei la",
	  "crn": "232623"
	}
```
	
- Exemplo: Retorno como patient 


```
	{
	  "idUser": 1,
	  "email": "caroline.telles1@gmail.com",
	  "password": "1234",
	  "fullname": "Caroline Teles",
	  "birthday": null,
	  "type": "patient",
	  "idPatient": 0,
	  "weight": 60.5,
	  "height": 1.6,
	  "description": "Carol is a short and chubby girl who wants to be thin"
	}

```

  **Obs:** É muito importante o campo **"type"**, pois ele que define como em qual tabela será procurado o usuário, como nutritionist ou como patient.