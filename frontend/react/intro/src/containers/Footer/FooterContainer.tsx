import {Container} from "react-bootstrap";

const FooterContainer = () => {
	return (
		<footer className={'fixed-bottom'}>
			<Container fluid={'sm'}>
				<span className={'text-muted'}>CodeAcademy, Ract Intro. All Right reserved :)</span>
			</Container>
		</footer>
	)
}

export default FooterContainer;
