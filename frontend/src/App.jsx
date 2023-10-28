import { useEffect, useState } from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import { CssBaseline } from "@mui/material";
import CustomMain from "./Components/CustomMain";
import Admin from "./Components/Admin";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import BackendTrigger from "./Components/BackendTrigger";

function App() {
	const [darkMode, setDarkMode] = useState(localStorage.getItem("darkMode") === "true");
	useEffect(() => {
		// Persist darkMode's value
		localStorage.setItem("darkMode", darkMode);
	}, [darkMode]);

	const theme = createTheme({
		palette: {
			mode: darkMode ? "dark" : "light",
		},
	});

	const router = createBrowserRouter([
		{
			path: "/",
			element: <CustomMain darkMode={darkMode} setDarkMode={setDarkMode} />,
		},
		{
			path: "/Admin",
			element: <Admin />,
		},
	]);

	return (
		<>
			<ThemeProvider theme={theme}>
				<CssBaseline />
				<RouterProvider router={router} />
				<BackendTrigger />
				<ToastContainer
					position="bottom-right"
					autoClose={5000}
					hideProgressBar={false}
					newestOnTop={false}
					closeOnClick
					rtl={false}
					pauseOnFocusLoss
					draggable
					pauseOnHover
				/>
			</ThemeProvider>
		</>
	);
}

export default App;
