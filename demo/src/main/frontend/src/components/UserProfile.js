import { useEffect, useState } from "react";
import axios from "axios";
import { useSelector, useDispatch } from "react-redux";
import { addUser,UpdateUser } from "../reducers/user/actions"
import Swal from 'sweetalert2';
import NavBar from './NavBar'
import Header2 from './Header2'
import Footer from './Footer'
import '../StyleSheets/Comment.css'
function UserProfile() {
    const dispatch = useDispatch()
    const [fname, setFname] = useState();
    const [lname, setLname] = useState();
    const [phone_number, setPhone_number] = useState();

    const FnameUpdate = (e) => {
        setFname(e.target.value);
    }
    const LnameUpdate = (e) => {
        setLname(e.target.value);
    }
    const PhoneUpdate = (e) => {
        setPhone_number(e.target.value);
    }
    const state = useSelector((state) => {
        return {
            user: state.userReducer.user,
        };
    });
    //get users 
    // useEffect(() => {
    //     axios
    //         .get(`http://localhost:8080/users/${state.user.username}`)
    //         .then((res) => {
    //             console.log(res.data);
    //             dispatch(addUser(res.data))
    //             console.log("i'm here");
    //         })
    //         .catch((err) => {
    //             console.log(err);
    //         });
    // }, []);
    //edit profile and put user info
    const Edit = () => {
        const info = {
            fname: fname,
            lname: lname,
            phone_number: phone_number,
        }
       
        axios.put(`http://localhost:8080/users/${state.user.id}`, info)
        .then((res) => {
                console.log(res.data);
                console.log("done");
                dispatch(UpdateUser(res.data))
                Swal.fire(
                    'your informations has been successfuly updated !',
                    'You clicked the button!',
                    'success'
                    )
                })
                .catch((error) => console.log(error));
                // window.location.reload(false); //refresh the page after editing

    }
   
    //delete user account 
    //edit user info
    return (
        <div>
            <NavBar />
            <Header2 />
            <div className="cdiv">
            <h2>My Personal Information</h2>
            <p>Username: <span>{state.user.username}</span></p>
            <p>First Name: <span>{state.user.fname}</span>  <br></br> 
               Last Name: <span>{state.user.lname}</span></p>
            <p>Phone Number: <span>{state.user.phone_number}</span></p>
            <hr></hr>
            <h2>Edit my Information</h2>
            <p>First Name:</p>
            <input type="text" placeholder="write your first name" className="inputt" onChange={FnameUpdate} />
            <br></br>
            <p>Last Name:</p>
            <input type="text" placeholder="write your last name" className="inputt" onChange={LnameUpdate} />
            <br></br>
            <p>Phone Number:</p>
            <input type="tel" placeholder="write your phone number"  className="inputt" onChange={PhoneUpdate} />
            <br></br>
            <button onClick={Edit}>Edit my Profile</button>
            </div>
            <br></br>
<Footer />
        </div>
    )
}
export default UserProfile;