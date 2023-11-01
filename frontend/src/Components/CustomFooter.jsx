import { useState } from "react";
import {
	Typography,
	Modal,
	Button,
	List,
	ListItem,
	ListItemIcon,
	ListItemText,
	Paper,
} from "@mui/material";
import group from "../assets/group.png";
import frontend from "../assets/ui.png";
import backend from "../assets/browser.png";
import python from "../assets/python.png";

function CustomFooter(props) {
	const [openModal, setOpenModal] = useState(false);
	const { darkMode, setDarkMode } = props;

	const styles = {
		modal: {
			display: "flex",
			alignItems: "center",
			justifyContent: "center",
		},
		paper: {
			backgroundColor: darkMode ? "black" : "white",
			border: "2px solid #000",
			boxShadow: 24,
			padding: "50px",
			borderRadius: "8px",
			width: "50%",
		},
	};

	const handleOpenModal = () => {
		setOpenModal(true);
	};

	const handleCloseModal = () => {
		setOpenModal(false);
	};

	return (
		<>
			<footer
				style={{
					position: "fixed",
					bottom: 0,
					width: "100%",
					backgroundColor: darkMode ? "black" : "#f5f5f5",
					padding: "10px",
					textAlign: "right",
				}}
			>
				<Typography variant="body2" color="textSecondary">
					Powered by OpenText Cloud
				</Typography>
			
			</footer>
			<div>
				<Modal
					open={openModal}
					onClose={handleCloseModal}
					aria-labelledby="modal-modal-title"
					aria-describedby="modal-modal-description"
					style={styles.modal}
				>
					<Paper style={styles.paper}>
						<h2>
							<img src={group} alt="About Us" /> About Us
						</h2>
						<List>
							<ListItem>
								<ListItemIcon>
									<img src={frontend} alt="FrontEnd" />
								</ListItemIcon>
								<ListItemText primary="Sriram" />
							</ListItem>
							<ListItem>
								<ListItemIcon>
									<img src={backend} alt="BackEnd" />
								</ListItemIcon>
								<ListItemText primary="Shibin" />
							</ListItem>
							<ListItem>
								<ListItemIcon>
									<img src={python} alt="Python BackEnd" />
								</ListItemIcon>
								<ListItemText primary="Satya" />
							</ListItem>
						</List>
					</Paper>
				</Modal>
			</div>
		</>
	);
}

export default CustomFooter;
