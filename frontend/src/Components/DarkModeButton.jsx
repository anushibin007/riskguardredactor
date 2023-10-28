import { IconButton } from "@mui/material";
import DarkModeIcon from "@mui/icons-material/DarkMode";
import LightModeIcon from "@mui/icons-material/LightMode";

const DarkModeButton = (props) => {
	const { darkMode, setDarkMode } = props;

	const toggleDarkMode = () => {
		setDarkMode(!darkMode);
	};
	return (
		<IconButton color="inherit" onClick={toggleDarkMode}>
			{darkMode && <LightModeIcon />}
			{!darkMode && <DarkModeIcon />}
		</IconButton>
	);
};

export default DarkModeButton;
