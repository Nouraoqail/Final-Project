import Posts from "./Posts";
import Header from "./Header"
import Footer from "./Footer"
import NavBar from "./NavBar";
import { Link } from "react-router-dom";
import { Navbar } from "react-bootstrap";
import HomeMenu from "./HomeMenu";
import { useEffect,useState } from "react";
import axios from "axios";
import {useSelector,useDispatch} from "react-redux";
import { addUser} from "../reducers/user/actions";
import Header2 from "./Header2";


function Home() {
    const dispatch = useDispatch();
    const[posts,setPosts]=useState();
    const state = useSelector((state) => {
        return {
            user:state.userReducer.user
        };
      });
    useEffect(() => {
        axios
            .get(`http://localhost:8080/users/${state.user.username}`)
            .then((res) => {
                console.log(res.data);
                dispatch(addUser(res.data))
                console.log("success");
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);
    return (
        <div>
            <NavBar />
            <Header2 />
            {/* <Header /> */}
            {/* <p className="UserWelcome">
                {" "}
                Welcome {state.user.fname} {state.user.lname}
            </p> */}
            <br></br>
            <HomeMenu setPosts={setPosts}/>
            <br></br>
            {/* <hr></hr> */}
            <Posts posts={posts}/>
            <Footer />
        </div>
    )
}
export default Home;