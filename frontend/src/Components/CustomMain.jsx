import { useState } from "react";
import { ThemeProvider } from "@mui/material/styles";
import { AppBar, Button, CssBaseline, Typography, Toolbar, Container } from "@mui/material";
import { createTheme } from "@mui/material/styles";
import FileDropZone from "./FileDropZone";

const CustomMain = () => {
	const [darkMode, setDarkMode] = useState(false);

	const toggleDarkMode = () => {
		setDarkMode(!darkMode);
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
						<Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
							RiskGuard Redactor
						</Typography>
						<Button color="inherit" onClick={toggleDarkMode}>
							{darkMode ? "Light Mode" : "Dark Mode"}
						</Button>
					</Toolbar>
				</AppBar>
				<Container
					style={{
						display: "flex",
						flexDirection: "column",
						alignItems: "center",
						justifyContent: "center",
						minHeight: "80vh",
					}}
				>
					<FileDropZone />
				</Container>
			</div>
		</ThemeProvider>
	);
};

export default CustomMain;
