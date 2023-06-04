import {Button, Form} from 'react-bootstrap';
import {useState} from "react";
import './ContentContainer.css';

const ContentContainer = () => {
	const [visible, setVisible] = useState(false);

	const [btnActive, setBtnActive] = useState(false);
	const [product, setProduct] = useState({
		name: '',
		quantity: 0,
		price: 0,
		description: ''
	})

	const [btnMoveValue, setBtnMoveValue] = useState(0);

	const onSubmitEvent = (event: any) => {
		event.preventDefault();
		console.log(event);
	}

	const onChangeEvent = (event: any) => {
		setProduct({
			...product,
			[event.target.name]: event.target.value,
		});

		makeBtnActive(event.target);
		setVisible(true);
	}

	const makeBtnActive = ({name, value}: any) => {
		if (name === 'name' && value.length > 1) {
			setBtnActive(true);
		} else {
			setBtnActive(false);
		}
	}

	const onMuseEvent = (event: any) => {
		console.log('mouse down')
		if (event.taget.name === 'name'
			&& event.target.value.length <= 10) {
			setBtnMoveValue(200);
		}
	};

	return (
		<>
			<Form onChange={onChangeEvent} onSubmit={onSubmitEvent}>
				<Form.Group className='mb-3'>
					<Form.Label>Product name</Form.Label>
					<Form.Control name="name" placeholder='Write name'/>
				</Form.Group>

				<Form.Group className='mb-3' controlId='quantity'>
					<Form.Label>Product quantity</Form.Label>
					<Form.Control name="quantity" placeholder='Write quantity'/>
				</Form.Group>

				<Form.Group className='mb-3'>
					<Form.Label>Product price</Form.Label>
					<Form.Control name="price" placeholder='Write price'/>
				</Form.Group>

				<Form.Group className='mb-3'>
					<Form.Label>Product description</Form.Label>
					<Form.Control name="description" placeholder='Write description'/>
				</Form.Group>

				{btnActive
					? <Button style={{marginLeft: `${btnMoveValue}px`}} variant='primary' type='submit' onMouseEnter={onMuseEvent}>
						Submit
					</Button>
					: <Button style={{marginLeft: `${btnMoveValue}px`}} variant='primary' type='submit' disabled onMouseEnter={onMuseEvent}>
					Submit
					</Button>
				}
			</Form>

			{
				visible &&
					<div>
						<hr/>
						<div>
							Created product:
							<div>Name: <strong>{product.name}</strong>
							</div>
							<div>Quantity: <strong>{product.quantity}</strong></div>
							<div>Price: <strong>{product.price}</strong></div>
							<div>Description: <strong>{product.description}</strong></div>
						</div>
					</div>
			}
		</>
	);
}

export default ContentContainer;
