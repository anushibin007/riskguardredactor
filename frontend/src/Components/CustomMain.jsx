import { Container } from "@mui/material";
import FileDropZone from "./FileDropZone";
import NavBar from "./NavBar";
import CustomFooter from "./CustomFooter";

const CustomMain = (props) => {
	const { darkMode, setDarkMode } = props;
	return (
		<div className="App">
			<NavBar darkMode={darkMode} setDarkMode={setDarkMode} />
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
				<CustomFooter darkMode={darkMode} setDarkMode={setDarkMode}/>
			</Container>
		</div>
	);
};

export default CustomMain;
