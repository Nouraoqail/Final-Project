import firebase from "firebase/compat/app";
import "firebase/compat/storage";

const firebaseConfig = {
    apiKey: "AIzaSyCMDgudzHokv81x15t6-AeEMh5HV64s-jc",
    authDomain: "fir-react-upload-34307.firebaseapp.com",
    projectId: "fir-react-upload-34307",
    storageBucket: "fir-react-upload-34307.appspot.com",
    messagingSenderId: "1081172283640",
    appId: "1:1081172283640:web:965fcaec62c759bf9c2b0d",
    measurementId: "G-CZ3GRCWB12"
  };
  firebase.initializeApp(firebaseConfig);

  const storage = firebase.storage();

export { storage, firebase as default };