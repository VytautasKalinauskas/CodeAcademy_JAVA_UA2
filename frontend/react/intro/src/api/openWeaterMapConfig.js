import axios from "axios";

const apiKey = 'fd007d624cdfb5178dbfd4de1d381ed3';

const API = axios.create({
	baseURL: 'https://api.openweathermap.org/data/2.5',
	params: {appid: apiKey}
});

export default API;
