import { useState } from "react";
import AppBar from "@mui/material/AppBar";
import Typography from "@mui/material/Typography";
import Toolbar from "@mui/material/Toolbar";
import Container from "@mui/material/Container";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import Input from "@mui/material/Input";
import CssBaseline from "@mui/material/CssBaseline";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import DataTable from "./DataTable";

export default function RedactorApp() {
	const [selectedFile, setSelectedFile] = useState(null);
	const [darkMode, setDarkMode] = useState(false);

	const toggleDarkMode = () => {
		setDarkMode(!darkMode);
	};

	const handleFileChange = (event) => {
		setSelectedFile(event.target.files[0]);
	};

	const handleUpload = () => {
		if (selectedFile) {
			// Implement your file upload logic here
			alert(`Uploading ${selectedFile.name}`);
		} else {
			alert("Please select a file to upload.");
		}
	};

	const handleRedact = () => {
		// Implement your redaction logic here
		alert("Redacting...");
	};

	const theme = createTheme({
		palette: {
			mode: darkMode ? "dark" : "light",
		},
	});

	return (
		<ThemeProvider theme={theme}>
			<CssBaseline />
			<div className="App">
				<AppBar position="static" color="primary">
					<Toolbar>
						<Typography
							variant="h6"
							component="div"
							sx={{ flexGrow: 1, textAlign: "center" }}
						>
							RiskGuard Redactor
						</Typography>
						<Button color="inherit" onClick={toggleDarkMode}>
							{darkMode ? "Light Mode" : "Dark Mode"}
						</Button>
					</Toolbar>
				</AppBar>
				<Container maxWidth="sm" sx={{ mt: 4 }}>
					<Box display="flex" flexDirection="column" alignItems="center">
						<Input
							type="file"
							onChange={handleFileChange}
							sx={{ textAlign: "center", mt: 4 }}
						/>
						<Button
							variant="contained"
							color="primary"
							onClick={handleUpload}
							sx={{ mt: 2 }}
						>
							Upload
						</Button>
						<Button
							variant="contained"
							color="secondary"
							onClick={handleRedact}
							sx={{ mt: 2 }}
						>
							Redact
						</Button>
					</Box>
					<DataTable />
				</Container>
			</div>
		</ThemeProvider>
	);
}
