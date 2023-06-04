import {useEffect, useState} from "react";
import {getWeather} from "../../../api/openWeatherMapEndpoints";

const WeatherContainer = () => {

	const [celsiusValue, setCelsiusValue] = useState(0);

	useEffect(() => {
		getWeather()
			.then(res => {
				console.log(res.data);
				enrichWeatherData(res.data);
			})
			.catch(error => {
				if (error.response) {
					console.log(error.response.data);
				}
			})
	}, [])

	const enrichWeatherData = (data: any) => {
		setCelsiusValue(data.main.temp - 273);
	}

	return <h1>Current weather is: {celsiusValue.toFixed(2)}</h1>
}

export default WeatherContainer;
