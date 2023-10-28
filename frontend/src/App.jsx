import { createBrowserRouter, RouterProvider } from "react-router-dom";
import CustomMain from "./Components/CustomMain";
import Admin from "./Components/Admin";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import BackendTrigger from "./Components/BackendTrigger";

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
		</>
	);
}

export default App;
