import API from "./petsConfig";

export const getAvailablePets = () => API.get(`/pet/findByStatus?status=available`)
