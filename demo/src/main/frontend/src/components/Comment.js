import { useState, useEffect } from "react";
import { useParams } from "react-router";
import { useSelector } from "react-redux"
import axios from "axios";
import NavBar from './NavBar'
import Header2 from './Header2'
import Swal from 'sweetalert2';
import '../StyleSheets/Comment.css'

function Comment() {
    const [data, setData] = useState();
    const { id } = useParams();
    const [loading, setLoading] = useState(false);
    const [comment, setComment] = useState();
    const [newComment, setNewComment] = useState();
    const time = new Date()

    useEffect(() => {
        axios
            .get(`http://localhost:8080/posts/${id}`)
            .then((response) => {
                setData(response.data)
                setLoading(true)
            })
            .catch((error) => console.log(error));
    }, []);
    console.log(id);
    console.log(data);
    const handleComment = (e) => {
        setComment(e.target.value)
    }
    const state = useSelector((state) => {
        console.log(state.userReducer.user.id);
        return {
            user: state.userReducer.user,
            token: state.userReducer.token
        };
    });
    console.log(state.user.id);
    console.log(id);
    const sendComment = () => {
        //    console.log(data.comment[0].text);
        const config = {
            headers: { Authorization: `Bearer ${state.token}` },
        };
        const CommentPost = {
            text: comment,
            time: time,
            user: {

                id: state.user.id
            },
            post: {
                id: id
            }
        }
        //post comments
        //   console.log(CommentPost);
        axios
            .post("http://localhost:8080/comments", CommentPost, config)
            .then((response) => {
                console.log("sucesss");
                console.log(response.data);

                Swal.fire({
                    icon:'success',
                  text:'Your comment has been sent!',
                  timer: 3000
                  }
                  )
                 window.location.reload(false);
            })
            .catch((error) => console.log("somthing goes wrong" + error));
    }
    const deleteComment=()=>{
        axios
        .delete(`http://localhost:8080/comments/${data.comment[0].id}`)
        .then((res)=>{
            console.log("Success");
            console.log(res.data);
            Swal.fire({
             icon:'success',
           text:'Your comment has been successfully deleted!',
           timer: 3000
           })
          window.location.reload(false);
        })
        .catch((err)=>{
            console.log(err);
        })
    }
    const commentChange=(e)=>{
        setNewComment(e.target.value)
    }
    const update={
    text:newComment
    }
    const commentUpdate=()=>{
        axios
        .put(`http://localhost:8080/comments/${data.comment[0].id}`,update)
        .then((res) => {
            console.log(update);
            console.log(res);
            console.log("done");
            Swal.fire({
                icon:'success',
              text:'Your comment has been successfully updated!',
              timer: 3000
              })
                window.location.reload(false); //refresh the page after editing
        })
        .catch((error) => console.log(error));
    }
    return (
        <>
            <NavBar />
            <Header2 />
            {loading ?
                <div>
                    <div className="cdiv">
                        <h2>Title:{data.title}</h2>
                        <img className="CommentImg" src={data.image} />
                       
                        <p>description: <br></br>{data.description}</p>
                        
                        <p><span>Type: </span>{data.type.type}</p>
                        <p className="timepara">{data.time}</p>
                        <hr></hr>
                        {data.comment !== undefined
                            ? data.comment.map((e) => {
                                return (
                                    <div>
                                        <div className="commentDiv">
                                            <p><img className="userImg" src="https://cdn0.iconfinder.com/data/icons/leto-ui-generic-1/64/leto-04-256.png"/>{e.user.username}</p>      
                                        <input className="updateInput"placeholder={e.text} onChange={commentChange}/>
                                        <img src="https://cdn0.iconfinder.com/data/icons/aami-web-internet/64/simple-98-256.png" className="UpdateImg" onClick={commentUpdate}/> 
                                        <br></br>
                                        <p className="note">*if you want to update your comment rewrite on the comment and press the update button.</p>
                                        <p className="timepara">{e.time.toLocaleString()}
                                        <button onClick={deleteComment} className="delete">
                                            <img src="https://cdn4.iconfinder.com/data/icons/evil-icons-user-interface/64/basket-256.png" className="deleteImg"/>
                                        </button>
                                        </p>
                                        </div>
                                         </div>
                                   
                                );
                            })
                            : <p>no comments yet</p>}
                        <hr></hr>
                        <input type="text" placeholder="write your comment here" className="inputt" onChange={handleComment} />
                        <br></br>
                        <button onClick={sendComment}>Send</button>
                    </div>
                </div>
                : ""}
        </>
    )
}
export default Comment;
