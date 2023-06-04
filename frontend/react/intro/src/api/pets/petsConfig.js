import axios from "axios";

const PETS_API = axios.create({
	baseURL: 'https://petstore.swagger.io/v2'
});

export default PETS_API;
