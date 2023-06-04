import { Button, Container, Form, Nav, Navbar, NavDropdown } from 'react-bootstrap';
import {NavLink} from "react-router-dom";

const HeaderContainer = () => {
	return (
		<Navbar bg="light" expand="lg">
			<Container fluid>
				<Navbar.Brand to="/" as={ NavLink }>Navbar scroll</Navbar.Brand>
				<Navbar.Toggle aria-controls="navbarScroll" />
				<Navbar.Collapse id="navbarScroll">
					<Nav
						className="me-auto my-2 my-lg-0"
						style={{ maxHeight: '100px' }}
						navbarScroll
					>
						<Nav.Link to="/" as={ NavLink }>Home</Nav.Link>
						<NavDropdown title="Api" id="navbarScrollingDropdown">
							<NavDropdown.Item to="/api/weather" as={ NavLink }>Current Weather</NavDropdown.Item>
							<NavDropdown.Item to="/api/pets" as={ NavLink }>Available Pets</NavDropdown.Item>
						</NavDropdown>
						<NavDropdown title="Examples" id="navbarScrollingDropdown">
							<NavDropdown.Item to="/example" as={ NavLink }>New Product with hooks</NavDropdown.Item>
						</NavDropdown>
					</Nav>
					<Form className="d-flex">
						<Form.Control
							type="search"
							placeholder="Search"
							className="me-2"
							aria-label="Search"
						/>
						<Button variant="outline-success">Search</Button>
					</Form>
				</Navbar.Collapse>
			</Container>
		</Navbar>
	);
}

export default HeaderContainer;
