import { useState ,useEffect} from "react";
import {useSelector} from "react-redux";
import axios from "axios";
import { Timeline, TimelineEvent } from 'react-event-timeline'
import Swal from 'sweetalert2';
import NavBar from "./NavBar";
import Header2 from "./Header2";
import Footer from "./Footer";
function MyPosts() {
    const[data,setData]=useState();
    // const [loading, setLoading] = useState(false);

    const state = useSelector((state) => {
        return {
            user:state.userReducer.user
        };
      });
   
      useEffect(() => {
          axios
              .get(`http://localhost:8080/users/ById/${state.user.id}`)
              .then((res) => {
                  setData(res.data.posts)
                  console.log("success");
                  console.log(res.data.posts);
                })
                .catch((err) => {
                    console.log(err);
                });
                //   setLoading(true)
            }, []);
         console.log(data);
   const deletePost=()=>{
       axios
       .delete(`http://localhost:8080/posts/${data[0].id}`)
       .then((res)=>{
           console.log("Success");
           console.log(res.data);
           Swal.fire({
            icon:'success',
          text:'Your post has been successfully deleted!',
          timer: 3000
          }
          )
         window.location.reload(false);
       })
       .catch((err)=>{
           console.log(err);
       })
   }    
    return(
        <>
                {/* {loading?  */}
                <NavBar/>
                <Header2 />
        <div>
             {data !== undefined
                ? data.map((e) => {
                    return (
                       
                        <div className="TimeLine">
                            <Timeline>
                                <TimelineEvent 
                                // title={e.user.fname + " " + e.user.lname}
                                    subtitle={e.time}
                                    iconColor="#2e4057"
                                    style={{
                                        backgroundColor: '#fff',
                                    }}
                                    bubbleStyle={{ backgroundColor: '#2e4057' }}
                                >
                                    <div className="Posts">
                                        <h2>{e.title}</h2>
                                        <div className="image">
                                            <img src={e.image}/>
                                        </div>
                                        <div className="descriptionDIV">
                                        <p>{e.description}</p>
                                        </div>
                                        <p>Type: {e.type.type}</p>
                                        <div className="deletePost">
                                        <button onClick={deletePost}>delete post</button>
                                        </div>
                                    </div>
                                </TimelineEvent>
                            </Timeline>
                        </div>
                       
                    );
                })
                : <p className="undifendMsg">you don't have any posts yet</p>}
        </div>
                {/* :<h1>loading</h1>} */}
                <Footer/>
                </>
    )
}
export default MyPosts;