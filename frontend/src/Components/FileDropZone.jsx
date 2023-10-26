import { useState } from "react";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import CloudUploadIcon from "@mui/icons-material/CloudUpload";
import axios from "axios";

const FileDropZone = () => {
	const [file, setFile] = useState(null);
	const [redactButtonEnabled, setRedactButtonEnabled] = useState(false);

	const handleFileChange = (e) => {
		const selectedFile = e.target.files[0];

		if (selectedFile && selectedFile.type === "application/pdf") {
			setFile(selectedFile);
			setRedactButtonEnabled(true);
		} else {
			alert("Please select a valid PDF file.");
		}
	};

	const handleDrop = (e) => {
		e.preventDefault();
		const droppedFile = e.dataTransfer.files[0];

		if (droppedFile && droppedFile.type === "application/pdf") {
			setFile(droppedFile);
			setRedactButtonEnabled(true);
		} else {
			alert("Please drop a valid PDF file.");
		}
	};

	const handleDragOver = (e) => {
		e.preventDefault();
	};

	const handleRedactButtonClick = async () => {
		const formData = new FormData();
		formData.append("file", file);

		const response = await axios.post("https://riskguardredactor-backend-springboot-adxywvifka-el.a.run.app/riskguardredactor/redact", formData);
		const responseBody = response.data;
		console.log(responseBody);
        
	};

	return (
		<div style={{ textAlign: "center" }}>
			<Box
				border={2}
				borderRadius="borderRadius"
				borderColor="primary.main"
				padding={2}
				onDrop={handleDrop}
				onDragOver={handleDragOver}
				style={{ cursor: "pointer", width: "auto", height: "200px", border: "1px dashed" }}
			>
				<div style={{ padding: "40px" }}>
					<Typography variant="h6" color="primary" gutterBottom>
						Drag and Drop PDF File Here
					</Typography>
					<Typography variant="body2" color="textSecondary">
						or
					</Typography>
					<input
						type="file"
						accept=".pdf"
						onChange={handleFileChange}
						style={{ display: "none" }}
						id="fileInput"
					/>
					<label htmlFor="fileInput">
						<Button
							variant="contained"
							component="span"
							startIcon={<CloudUploadIcon />}
							color="primary"
						>
							Browse
						</Button>
					</label>
					{file && (
						<Typography variant="body1" color="textPrimary" marginTop={2}>
							Selected File: {file.name}
						</Typography>
					)}
				</div>
			</Box>
			<Button
				variant="contained"
				disabled={!redactButtonEnabled}
				color="secondary"
				onClick={handleRedactButtonClick}
				sx={{ mt: 4 }}
			>
				Redact
			</Button>
		</div>
	);
};

export default FileDropZone;
