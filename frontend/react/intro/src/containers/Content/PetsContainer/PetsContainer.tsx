import PCard from "../../../components/PCard";
import {useEffect, useState} from "react";
import {getAvailablePets} from "../../../api/pets/petsEndpoints";
import {Spinner} from "react-bootstrap";

const PetsContainer = () => {

	const [loading, setLoading] = useState(true);

	const [pets, setPets] = useState(
		[
			{
				category: {
					name: ""
				},
				name: "",
				tags: [
					{
						name: ""
					}
				]
			}
		]
	)

	useEffect(() => {
		getAvailablePets()
			.then(res => setPets(res.data))
			.finally(() => setLoading(false))
	}, [])

	let count = 1;

	return <div className={'d-flex align-items-center flex-column'}>
		<h1>Available Pets</h1>
		<div className={'d-flex flex-wrap justify-content-around gap-2'}>
			{loading ? <Spinner animation="border" />
				: pets
					.filter(pet => pet.name !== undefined)
					.filter(pet => pet.category !== undefined)
					.map(pet => {
							if (count <= 3) {
								count++;
								return <PCard title={pet.name} subtitle={pet.category.name} tags={pet.tags}/>
							}
						}
					)
			}
		</div>
	</div>
}

export default PetsContainer;
