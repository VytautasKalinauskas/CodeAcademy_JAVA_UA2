const divElementName = 'currentWeather';
const apiKey = 'fd007d624cdfb5178dbfd4de1d381ed3';
const OPENWEATHERMAP_URL = 'https://api.openweathermap.org/data/2.5';

const getWeather = async () => {
	return await axios
		.get(`${OPENWEATHERMAP_URL}/weather?lat=54.6872&lon=25.2797&appid=${apiKey}`)
		.then(res => {
			console.log(res.data);
			return res.data;
		})
		.catch(error => {
			if (error.response) {
				console.log(error.response.data);
			}
		});
}

const renderWeatherInHtml = (data) => {
	const celsiusValue = data.main.temp - 273;
	let divElem = document.getElementById(divElementName);
	let paragraph = document.createElement('p');
	paragraph.innerText = `${data.name} - ${celsiusValue}°C`;
	divElem.appendChild(paragraph);
}

const main = async () => {
	renderWeatherInHtml(await getWeather());
}

main();
