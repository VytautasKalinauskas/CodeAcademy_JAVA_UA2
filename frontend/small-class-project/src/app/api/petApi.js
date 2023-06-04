const PET_STORE_URL = 'http://petstore.swagger.io/v2';

const getPets = () => {
	return axios
		.get(`${PET_STORE_URL}/pet/findByStatus?status=available`)
		.then(res => {
			console.log(res.data);
			renderPetsInHtml(res.data);
		})
		.catch((error) => {
			if( error.response ){
				console.log(error.response.data); // => the response payload
			}
		});
}

const renderPetsInHtml = (data) => {
	let divElement = document.getElementById('pets');
	let table = document.createElement('table');
	table.className = "table table-dark table-striped";
	generateTableData(table, data);
	divElement.appendChild(table);
}

const generateTableData = (table, data) => {
	let tableBody = table.createTBody();
	data.forEach(obj => {
		let tableRow = tableBody.insertRow();
		Object.getOwnPropertyNames(obj).forEach(propName =>
			tableRow.insertCell().innerText = obj[propName]);
	})
}

const btn = document.getElementById("callPets");
btn.addEventListener("click", () => {
	getPets();
});
