// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import React, { useEffect } from "react";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
	apiKey: "AIzaSyBTCbqOkO6egQz_5mHApK99WzIxfW2kOO4",
	authDomain: "riskguard-redactor.firebaseapp.com",
	projectId: "riskguard-redactor",
	storageBucket: "riskguard-redactor.appspot.com",
	messagingSenderId: "718372988024",
	appId: "1:718372988024:web:715206be277eff33b4b98d",
	measurementId: "G-9P0M3S44W0",
};

const FirebaseAnalytics = () => {
	useEffect(() => {
		initializeFirebase();
	}, []);

	const initializeFirebase = () => {
		const app = initializeApp(firebaseConfig);
		const analytics = getAnalytics(app);
	};

	return <></>;
};

export default FirebaseAnalytics;
