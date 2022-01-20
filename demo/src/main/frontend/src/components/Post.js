import { storage } from "./firebase/firebase";
import { useEffect, useState } from "react";
import { useSelector } from 'react-redux'
import axios from "axios";
import { ProgressBar } from "react-bootstrap";
import { useNavigate } from "react-router";
import AddIcon from '@material-ui/icons/Add';
import AddPhotoAlternateOutlined from '@material-ui/icons/AddPhotoAlternateOutlined';
// import AddAPhoto from '@material-ui/icons/AddAPhoto'
import Swal from 'sweetalert2';
import NavBar from "./NavBar";
import Header2 from "./Header2";
import Footer from "./Footer";
import '../StyleSheets/PostForm.css'

function Post() {
  const [image, setImage] = useState(null);
  const [url, setUrl] = useState("");
  const [progress, setProgress] = useState(0);
  const [title, setTitle] = useState();
  const [description, setDescription] = useState();
  const [data, setData] = useState();
  const [type, setType] = useState("Electrical");
  const navigate = useNavigate();
  const time = new Date()

  const Title = (e) => {
    setTitle(e.target.value);
  }
  const Description = (e) => {
    setDescription(e.target.value);
  }
  //get types
  useEffect(() => {
    axios
      .get("http://localhost:8080/types")
      .then((response) => setData(response.data))
      .catch((error) => console.log(error));
  }, []);
  //post posts
  const state = useSelector((state) => {
    return {
      user: state.userReducer.user,
      token: state.userReducer.token
    };
  });
 
  const postData = {
    title: title,
    image: url,
    description: description,
    time: time,
    user: {
      id: state.user.id,
    },
    type: { type: "" + type + "" }
  }
  function CreatePost() {
    const config = {
      headers: { Authorization: `Bearer ${state.token}` },
    };
    axios
      .post("http://localhost:8080/posts/createPost", postData, config)
      .then((res) => {
        console.log(res.data);
        Swal.fire({
          icon:'success',
          text:'post successfuly uploaded !'
        })
      })
      .catch((err) => {
        console.log("Something went wrong!", err);
      });
    navigate("/")
    window.location.reload(false); //refresh the page after adding the post
  }
  //upload image
  const handleChange = e => {
    if (e.target.files[0]) {
      setImage(e.target.files[0]);
    }
  };

  const handleSelect = e => {
    setType(e.target.value)
  }

  const handleUpload = () => {
    const uploadTask = storage.ref(`images/${image.name}`).put(image);
    uploadTask.on(
      "state_changed",
      snapshot => {
        const progress = Math.round(
          (snapshot.bytesTransferred / snapshot.totalBytes) * 100
        );
        setProgress(progress);
      },
      error => {
        console.log(error);
      },
      () => {
        storage
          .ref("images")
          .child(image.name)
          .getDownloadURL()
          .then(url => {
            console.log(url);
            setUrl(url);
          });
      }
    );
  };

  return (
    <div>
      <NavBar/>
      <Header2 />
      <div className="PostForm">
        <div className="title">ADD NEW POST</div>
       
        <div class="input-container">
          <input type="text"  required onChange={Title} />
          <label>Post Title</label>
        </div>
        {/* <input type="text" name="postTitle" placeholder="Post Title" onChange={Title} /> */}
        <div className="imgdiv">
        <label htmlFor="up0" className="hovertext" data-hover="Click here to choose an image"><AddIcon className="ImgUpload"/> </label>
        <input type="file" id="up0" onChange={handleChange} />
        <AddPhotoAlternateOutlined className="ImgUpload" onClick={handleUpload}/>
        </div>
        <br />
        <img src={url || "https://cdn4.iconfinder.com/data/icons/evil-icons-user-interface/64/picture-256.png"} alt="firebase-image" className="postImg" />

        <textarea placeholder="Write more about want you want" className="textArea" onChange={Description} />
        <br />
        <p>Choose the type of the item:</p>
        <select className="typeDropdown" onChange={handleSelect}>
          {data !== undefined
            ? data.map((e) => {
              return (
                <option key={e.type}>{e.type}</option>
              );
            })
            : ""}
        </select>
        <p className="timepara"> {time.toLocaleString()}</p>
        <ProgressBar animated now={progress} max="100" variant="success" />
        <button onClick={CreatePost}>Create Post</button>
      </div>
      <Footer/>
    </div>

  );
}
export default Post;