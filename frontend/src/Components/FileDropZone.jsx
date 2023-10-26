import { useState } from "react";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import CloudUploadIcon from "@mui/icons-material/CloudUpload";
import KeyIcon from "@mui/icons-material/Key";
import OpenInNewIcon from "@mui/icons-material/OpenInNew";
import ClearIcon from "@mui/icons-material/Clear";
import NoteAddIcon from "@mui/icons-material/NoteAdd";
import axios from "axios";

const FileDropZone = () => {
	const [file, setFile] = useState(null);
	const [redactButtonEnabled, setRedactButtonEnabled] = useState(false);
	const [redactedDocUrl, setRedactedDocUrl] = useState(undefined);

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
		setRedactedDocUrl(undefined);
		const formData = new FormData();
		formData.append("file", file);

		const response = await axios.post(
			"https://riskguardredactor-backend-springboot-adxywvifka-el.a.run.app/riskguardredactor/redact",
			formData
		);
		const responseBody = response.data;
		console.log(responseBody);
		const aRedactedDocUrl = responseBody.redactedDocUrl;
		if (aRedactedDocUrl) {
			setRedactedDocUrl(aRedactedDocUrl);
		}
	};

	const handleClearSelectionButtonClick = async () => {
		setRedactedDocUrl(undefined);
		setFile(null);
	};

	return (
		<div style={{ textAlign: "center" }}>
			{
				// Show the file picker only if no files are picked
				!file && (
					<>
						<Box
							border={2}
							borderRadius="borderRadius"
							borderColor="primary.main"
							padding={2}
							onDrop={handleDrop}
							onDragOver={handleDragOver}
							style={{
								cursor: "pointer",
								width: "auto",
								height: "200px",
								border: "1px dashed",
							}}
						>
							<div style={{ padding: "40px" }}>
								<Typography variant="h6" color="primary" gutterBottom>
									Drag and Drop a PDF File Here
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
										endIcon={<CloudUploadIcon />}
										color="primary"
									>
										Browse
									</Button>
								</label>
							</div>
						</Box>
					</>
				)
			}
			{
				// Show the picked file's name, redact and clear button only if a file is picked
				file && !redactedDocUrl && (
					<>
						<Typography variant="body1" color="textPrimary">
							Selected File: {file.name}
						</Typography>
						<Button
							variant="contained"
							disabled={!redactButtonEnabled}
							color="primary"
							onClick={handleRedactButtonClick}
							sx={{ mt: 4, mx: 4 }}
							endIcon={<KeyIcon />}
						>
							Redact
						</Button>
						<Button
							variant="contained"
							disabled={!redactButtonEnabled}
							color="secondary"
							onClick={handleClearSelectionButtonClick}
							endIcon={<ClearIcon />}
							sx={{ mt: 4, mx: 4 }}
						>
							Clear
						</Button>
					</>
				)
			}
			{
				// Show download button only if we have the redacted doc's URL
				redactedDocUrl && (
					<>
						<Typography variant="body1" color="textPrimary">
							Redaction complete!
						</Typography>
						<a
							href={`https://riskguardredactor-backend-springboot-adxywvifka-el.a.run.app/fileurlhelper/fileyify?url=${redactedDocUrl}`}
							download={file?.name}
							target="_blank"
						>
							<Button
								variant="contained"
								disabled={redactedDocUrl == undefined}
								color="success"
								sx={{ mt: 4, mx: 4 }}
								endIcon={<OpenInNewIcon />}
							>
								Download
							</Button>
						</a>
						<Button
							variant="contained"
							disabled={!redactButtonEnabled}
							color="secondary"
							onClick={handleClearSelectionButtonClick}
							endIcon={<NoteAddIcon />}
							sx={{ mt: 4, mx: 4 }}
						>
							Pick a new document
						</Button>
					</>
				)
			}
		</div>
	);
};

export default FileDropZone;
