import { AppBar, Typography, Toolbar } from "@mui/material";
import DarkModeButton from "./DarkModeButton";

const NavBar = (props) => {
	const { darkMode, setDarkMode } = props;
	return (
		<AppBar position="static" color="primary">
			<Toolbar>
				<Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
					<a
						href="https://riskguard-redactor.web.app/"
						style={{ color: "inherit", textDecoration: "none" }}
					>
						RiskGuard Redactor
					</a>
					<Typography variant="body2" sx={{ flexGrow: 1, fontSize: "10px"}}>
						<a
							href="https://riskguard-redactor.web.app/"
							style={{ color: "inherit", textDecoration: "none" }}
						>
							AI powered document redactor
						</a>
					</Typography>
				</Typography>
				<DarkModeButton darkMode={darkMode} setDarkMode={setDarkMode} />
			</Toolbar>
		</AppBar>
	);
};

export default NavBar;
