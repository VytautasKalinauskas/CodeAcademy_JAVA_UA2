import Card from 'react-bootstrap/Card';

interface PCardProps {
	title: string,
	subtitle: string,
	tags: { name: string }[]
}

const PCard = ({ title, subtitle, tags }: PCardProps) => {
	return (
		<Card style={{ width: '18rem' }}>
			<Card.Body>
				<Card.Title>{title}</Card.Title>
				<Card.Subtitle className="mb-2 text-muted">{subtitle}</Card.Subtitle>
				<Card.Text>
					No description for pet name <strong>{title}</strong>
				</Card.Text>
				{tags.map((tag) => (
					<Card.Link href="#">{tag.name}</Card.Link>
				))}
			</Card.Body>
		</Card>
	);
}

export default PCard;
