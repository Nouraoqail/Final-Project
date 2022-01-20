import { useState, useEffect, useSelector } from "react";
import axios from "axios";
import ChatIcon from '@material-ui/icons/Chat';
import { useNavigate } from "react-router-dom";
import { Timeline, TimelineEvent } from 'react-event-timeline'

function Posts({ posts }) {
    const [data, setData] = useState();
    const navigate = useNavigate();


    useEffect(() => {
        if (posts == undefined) {
            axios
                .get("http://localhost:8080/posts")
                .then((response) => {
                    setData(response.data)
                    console.log(response.data);
                })
                .catch((error) => console.log(error));
        } else {
            setData(posts)
        }

    }, [posts]);

    return (


        <div>
            {data !== undefined
                ? data.map((e) => {
                    return (

                        <div className="TimeLine">
                            <Timeline>
                                <TimelineEvent title={e.user.fname + " " + e.user.lname}
                                    subtitle={e.time}
                                    iconColor="#2e4057"
                                    style={{
                                        backgroundColor: '#fff',
                                    }}
                                    bubbleStyle={{ backgroundColor: '#2e4057' }}
                                >
                                    <div className="Posts">
                                        {/* <h3>{e.user.fname} {e.user.lname}</h3> */}
                                        <h2>{e.title}</h2>
                                        <div className="image">
                                            <img src={e.image} />
                                        </div>
                                        <hr></hr>
                                        <div className="descriptionDIV">
                                            <p>{e.description}</p>
                                        </div>
                                        <p><span>Type:</span> {e.type.type}</p>
                                        <button className="Comment"
                                            onClick={() => {
                                                navigate(`/Comment/${e.id}`)
                                            }}
                                        >
                                            <ChatIcon className="CommentButton" />
                                        </button>
                                    </div>
                                </TimelineEvent>
                            </Timeline>
                        </div>

                    );
                })
                : <p className="undifendMsg">No posts yet</p>}
        </div>


    );
}
export default Posts;