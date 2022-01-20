import "../StyleSheets/Register.css"
import { useState, useEffect } from "react";
import { useNavigate, Navigate } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { addUser, addToken } from "../reducers/user/actions";
import axios from "axios";
import jwt_decode from "jwt-decode";
import Swal from "sweetalert2";


function Register() {
  //Login
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [userNid, setUserNid] = useState();
  const [userPassword, setUPassword] = useState();
  const [Inmsg, setInMsg] = useState();
  //Register
  const [nid, setNid] = useState();
  const [fname, setFname] = useState();
  const [lname, setLname] = useState();
  const [phone_number, setPhone_number] = useState();
  const [password, setPassword] = useState();
  const [justNum, setJustNum] = useState();
  const [Upmsg, setUpMsg] = useState();
  //login functions
  const UNid = (e) => {
    setUserNid(e.target.value);
  }
  const UPassword = (e) => {
    setUPassword(e.target.value);
  } 
  const state = useSelector((state) => {
      return {
        user: state.userReducer.user,
        token: state.userReducer.token,
      };
    });
  const Login = () => {
    // axios
    // .get(`http://localhost:8080/users/${state.user.username}`)
    // .then((res) => {
    //   console.log(res.data);
    //   dispatch(addUser(res.data))
    //   console.log(addUser(res.data));
    //   console.log("i'm here");
    //   console.log(state.user);
    // })
    // .catch((err) => {
    //   console.log(err);
    // });
    const postData = {
      username: userNid,
      password: userPassword,
    }
   
    const config = {
      headers: { Authorization: `Bearer ${state.token}` },
    };
    axios
    .post("http://localhost:8080/login", postData, config)
    .then((res) => {
      console.log(res.data);
      const token = res.data.access_token
      const decoded = jwt_decode(token);
      console.log(decoded);
      const user_action = addUser({
        username: decoded.sub,
      });
      const token_action = addToken(token);
      dispatch(user_action);
      dispatch(token_action);
      navigate("/");
    })
    .catch((err) => {
      setInMsg("username or password wrong:(")
      console.log(err);
    });
  };
  // Register functions
  const NidFunction = (e) => {
    //allow the user to enter just numric input 
    const value = e.target.value.replace(/\D/g, "");
    setJustNum(value);
    setNid(e.target.value);
  }
  const FnameFunction = (e) => {
    setFname(e.target.value);
  }
  const LnameFunction = (e) => {
    setLname(e.target.value);
  }
  const PhoneFunction = (e) => {
    setPhone_number(e.target.value);
  }
  const PasswordFunction = (e) => {
    setPassword(e.target.value);
  }

  const postData = {
    username: nid,
    fname: "" + fname + "",
    lname: "" + lname + "",
    phone_number: phone_number,
    password: password,
    role: "user"
  }
  function SignUpFunction() {
    axios
      .post("http://localhost:8080/users", postData)
      .then((res) => {
        console.log(res.data);

        console.log("i'm here");
        Swal.fire(
          'congratulations your account successfully created :)',
          'You can login now!',
          'success'
        )
      })
      .catch((err) => {
        setUpMsg("Username already exist!")
        console.log(err);
      });
  }

  return (
    <div>
      <div className="Register">
        <title>Slide Navbar</title>
        <link rel="stylesheet" type="text/css" href="slide navbar style.css" />
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet" />
        <div className="main">
          <input type="checkbox" id="chk" aria-hidden="true" />
          <div className="signup">

            <label className="label" htmlFor="chk" aria-hidden="true">Sign up</label>
            <input className="input" type="text" name="txt" placeholder="National ID" required value={justNum} onChange={NidFunction} />
            <input className="input" type="text" name="text" placeholder="First Name" required onChange={FnameFunction} />
            <input className="input" type="text" name="text" placeholder="Last Name" required onChange={LnameFunction} />
            <input className="input" type="tel" name="tel" placeholder="Phone Number" required onChange={PhoneFunction} />
            <input className="input" type="password" name="pswd" placeholder="Password" required required onChange={PasswordFunction} />
            <p className="Msg">{Upmsg}</p>
            <button className="button" onClick={SignUpFunction}>Sign up</button>

          </div>
          <div className="login">

            <label className="label" htmlFor="chk" aria-hidden="true">Login</label>
            <input className="input" type="text" name="text" placeholder="National id" required onChange={UNid} />
            <input className="input" type="password" name="pswd" placeholder="Password" required onChange={UPassword} />
            <p className="Msg">{Inmsg}</p>
            <button className="button" onClick={Login}>Login</button>

          </div>
        </div>
      </div>
    </div>
  )
}
export default Register;