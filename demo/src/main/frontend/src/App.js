import './App.css';
import Post from './components/Post';
import {BrowserRouter,Routes,Route} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Home from './components/Home';
import Register from './components/Register';
import UserProfile from './components/UserProfile';
import MyPosts from './components/MyPosts';
import Comment from './components/Comment'
function App() {
  return (

    <div className="App">
     
     <BrowserRouter>
    <div>
     <Routes>
       <Route path="/" element={<Home />}/>
       <Route path="/Post" element={<Post />}/>
       <Route path="/UserProfile" element={<UserProfile/>}/>
       <Route path="/Register" element={<Register/>}/>
       <Route path="/MyPosts" element={<MyPosts/>}/>
       <Route path="/Comment/:id" element={<Comment/>}/>
       {/* <Route path="/InsidePost or comment" element={<InsidePost or comment/>}/> */}
     </Routes>
    </div>
     </BrowserRouter>
    </div>
  );
}

export default App;
