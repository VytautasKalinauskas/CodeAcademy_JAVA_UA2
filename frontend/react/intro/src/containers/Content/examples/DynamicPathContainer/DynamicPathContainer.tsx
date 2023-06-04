import {useParams} from "react-router-dom";

const DynamicPathContainer = () => {
	const {userName} = useParams(); // name should be same as in dynamic route
	return <h1>User name is: {userName}</h1>
}

export default DynamicPathContainer;
