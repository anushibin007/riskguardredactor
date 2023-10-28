import axios from "axios";
import React, { useEffect, useState } from "react";

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
		triggerAliveEndpoint(
			"https://riskguardredactor-backend-springboot-adxywvifka-el.a.run.app/actuator/alive"
		);
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
