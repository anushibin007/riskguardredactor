import axios from "axios";
import { useEffect } from "react";
import Constants from "../util/Constants";

/**
 * This component is used simply
 * to trigger the backend when
 * the frontend is loaded. This
 * will help with warming up an
 * inactive backend (that is
 * running on the cloud as a
 * Container-as-a-Service) model.
 */

const BackendTrigger = () => {
	useEffect(() => {
		// Call alive endpoints of the backend
		// when the current component renders
		triggerSpringBootBackend();
	}, []);

	const triggerSpringBootBackend = () => {
		triggerAliveEndpoint(`${Constants.VITE_BACKEND_SPRING_BOOT_BASE_URL}/actuator/alive`);
	};

	const triggerAliveEndpoint = (endpointURL) => {
		axios
			.get(endpointURL)
			.then(() => {
				console.log(`The endpoint [${endpointURL}] is alive`);
			})
			.catch((err) => {
				console.error(`The endpoint [${endpointURL}] is not reachable. Error: ${err}`);
			});
	};
};

export default BackendTrigger;
