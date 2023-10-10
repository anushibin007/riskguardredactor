import { useState } from "react";
import { ThemeProvider } from "@mui/material/styles";
import { AppBar, Button, CssBaseline, Typography, Toolbar, Container } from "@mui/material";
import { createTheme } from "@mui/material/styles";
import {
	Table,
	TableBody,
	TableCell,
	TableContainer,
	TableHead,
	TableRow,
	Paper,
} from "@mui/material";

const Admin = () => {
	const [darkMode, setDarkMode] = useState(false);

	const toggleDarkMode = () => {
		setDarkMode(!darkMode);
	};

	const theme = createTheme({
		palette: {
			mode: darkMode ? "dark" : "light",
		},
	});
	const rows = [
		{ sno: 1, name: "John", file: "document1.pdf" },
		{ sno: 2, name: "Jane", file: "document2.pdf" },
		{ sno: 3, name: "Alice", file: "document3.pdf" },
		{ sno: 4, name: "Bob", file: "document4.pdf" },
		{ sno: 5, name: "Eve", file: "document5.pdf" },
	];

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
					<TableContainer component={Paper}>
						<Table sx={{ minWidth: 650 }} aria-label="simple table">
							<TableHead>
								<TableRow>
									<TableCell>SNO</TableCell>
									<TableCell>Name</TableCell>
									<TableCell>File</TableCell>
								</TableRow>
							</TableHead>
							<TableBody>
								{rows.map((row) => (
									<TableRow key={row.sno}>
										<TableCell>{row.sno}</TableCell>
										<TableCell>{row.name}</TableCell>
										<TableCell>{row.file}</TableCell>
									</TableRow>
								))}
							</TableBody>
						</Table>
					</TableContainer>
				</Container>
			</div>
		</ThemeProvider>
	);
};

export default Admin;
