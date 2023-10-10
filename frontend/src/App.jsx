import { createBrowserRouter, RouterProvider } from "react-router-dom";
import CustomMain from "./Components/CustomMain";
import Admin from "./Components/Admin";

const router = createBrowserRouter([
	{
		path: "/",
		element: <CustomMain />,
	},
	{
		path: "/Admin",
		element: <Admin />,
	},
]);
function App() {
	return (
		<>
			<RouterProvider router={router} />
		</>
	);
}

export default App;
