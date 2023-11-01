import { useEffect, useState } from "react";
import Constants from "../util/Constants";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import CloudUploadIcon from "@mui/icons-material/CloudUpload";
import KeyIcon from "@mui/icons-material/Key";
import OpenInNewIcon from "@mui/icons-material/OpenInNew";
import ClearIcon from "@mui/icons-material/Clear";
import NoteAddIcon from "@mui/icons-material/NoteAdd";
import axios from "axios";
import { LinearProgress } from "@mui/material";
import { toast } from "react-toastify";

const FileDropZone = () => {
	const [file, setFile] = useState(null);
	const [redactButtonEnabled, setRedactButtonEnabled] = useState(false);
	const [redactedDocUrl, setRedactedDocUrl] = useState(undefined);
	const [axiosInProgress, setAxiosInProgress] = useState(false);
	const [dragging, setDragging] = useState(false);
	const [currentStatementIndex, setCurrentStatementIndex] = useState(0);

	useEffect(() => {
		if (axiosInProgress) {
			makeRedactionCallToBackend();
		}
	}, [axiosInProgress]);

	const handleFileChange = (e) => {
		const selectedFile = e.target.files[0];

		if (selectedFile && selectedFile.type === "application/pdf") {
			setFile(selectedFile);
			setRedactButtonEnabled(true);
		} else {
			toast.error("Please select a valid PDF file.");
		}
	};

	const handleDragEnter = (e) => {
		e.preventDefault();
		e.stopPropagation();
		setDragging(true);
	};

	const handleDragLeave = (e) => {
		e.preventDefault();
		e.stopPropagation();
		setDragging(false);
	};

	const handleDrop = (e) => {
		e.preventDefault();
		e.stopPropagation();
		setDragging(false);
		const droppedFile = e.dataTransfer.files[0];

		if (droppedFile && droppedFile.type === "application/pdf") {
			setFile(droppedFile);
			setRedactButtonEnabled(true);
		} else {
			toast.error("Please drop a valid PDF file.");
		}
	};

	const handleDragOver = (e) => {
		e.preventDefault();
	};

	const handleDropZoneClick = () => {
		document.getElementById("fileInput").click();
	};

	const handleRedactButtonClick = () => {
		setRedactedDocUrl(undefined);
		setAxiosInProgress(true);
	};

	const statements = [
		"Your file is checked for sensitive information",
		"Your file is being redacted",
		"Your file is being pushed to Content Server",
	];
	useEffect(() => {
		const interval = setInterval(() => {
			setCurrentStatementIndex((prevIndex) => (prevIndex + 1) % statements.length);
		}, 3000);
		return () => clearInterval(interval);
	}, []);

	const makeRedactionCallToBackend = () => {
		const formData = new FormData();
		formData.append("file", file);
		axios
			.post(
				`${Constants.VITE_BACKEND_SPRING_BOOT_BASE_URL}/riskguardredactor/redact`,
				formData
			)
			.then((response) => {
				const responseBody = response.data;
				console.log(responseBody);
				const aRedactedDocUrl = responseBody.redactedDocUrl;
				if (aRedactedDocUrl) {
					setRedactedDocUrl(aRedactedDocUrl);
				}
				setAxiosInProgress(false);
			})
			.catch((err) => {
				const errorFromServer = err?.response?.data?.errorMessage;
				if (errorFromServer) {
					toast.error(`${errorFromServer}`);
				} else {
					toast.error(`An error occured: ${err}`);
				}
				setAxiosInProgress(false);
			});
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
							borderColor={dragging ? "success.main" : "primary.main"}
							padding={2}
							onDrop={handleDrop}
							onDragOver={handleDragOver}
							onDragEnter={handleDragEnter}
							onDragLeave={handleDragLeave}
							onClick={handleDropZoneClick}
							style={{
								cursor: "pointer",
								width: "auto",
								height: dragging ? "400px" : "250px",
								border: dragging ? "2px solid green" : "1px dashed",
								transition: "all 0.3s",
							}}
						>
							<div style={{ padding: "40px" }}>
										<Typography variant="h6" color={dragging ?  "green" : "primary"} gutterBottom>
											Drag and Drop a PDF File Below
										</Typography>
										<Typography variant="body2" color="textSecondary" style={{ display: dragging ? "none" : "" }}>
											or
										</Typography>
								<input
									type="file"
									accept=".pdf"
									onChange={handleFileChange}
									style={{ display: "none" }}
									id="fileInput"
								/>
								<label >
									<Button
										variant="contained"
										component="span"
										endIcon={<CloudUploadIcon />}
										color="primary"
										style={{ display: dragging ? "none" : "" }}
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
				// Show the picked file's name, redact and clear button
				// only if a file is picked
				file && !redactedDocUrl && !axiosInProgress && (
					<>
						<Typography variant="body1" color="textPrimary">
							Selected File: {file.name}
						</Typography>
						<div style={{ marginTop: "20px" }}>
							<Button
								variant="contained"
								disabled={!redactButtonEnabled}
								color="primary"
								onClick={handleRedactButtonClick}
								endIcon={<KeyIcon />}
								style={{ marginBottom: "10px", width: "150px" }}
							>
								Redact
							</Button>
						</div>
						<Button
							variant="outlined"
							disabled={!redactButtonEnabled}
							color="secondary"
							onClick={handleClearSelectionButtonClick}
							endIcon={<ClearIcon />}
							style={{ width: "150px" }}
						>
							Clear
						</Button>
					</>
				)
			}
			{
				// Show the progress bar only
				// if the axios request is in progress
				axiosInProgress && (
					<>
						<Typography variant="body1" color="textPrimary">
							{statements[currentStatementIndex]}
						</Typography>
						<LinearProgress sx={{ mt: 2 }} />
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
							href={`${Constants.VITE_BACKEND_SPRING_BOOT_BASE_URL}/fileurlhelper/riskguard-redactor-output?fileName=redacted-${file?.name}&url=${redactedDocUrl}`}
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
							variant="outlined"
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
