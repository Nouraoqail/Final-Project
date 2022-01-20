 import axios from "axios";
import { useEffect, useState } from "react";
import "../StyleSheets/HomeMenu.css"
 function HomeMenu({setPosts}) {

  const [type, setType] = useState()
  
  useEffect(()=>{
    changeToolsHardware()
  },[type])

   const changeToolsHardware=()=>{
    axios.get(`http://localhost:8080/posts/getByType/${type}`)
    .then((res)=>{
      setPosts(res.data)
      console.log(res.data);
    })
    .catch((err)=>{
      console.log(err);
    })
   }
  //  const changeHomeApp=()=>{
  //   axios.get("http://localhost:8080/posts/getByType/Home Appliances")
  //   .then((res)=>{
  //     setPosts(res.data)
  //     console.log(res.data);
  //   })
  //   .catch((err)=>{
  //     console.log(err);
  //   })
  //  }
  //  const changeElectrical=()=>{
  //    axios.get("http://localhost:8080/posts/getByType/Electrical")
  //    .then((res)=>{
  //      setPosts(res.data)
  //      console.log(res.data);
  //    })
  //    .catch((err)=>{
  //      console.log(err);
  //    })
  //  }
  //  const changePaint=()=>{
  //   axios.get("http://localhost:8080/posts/getByType/Paint & Sundries")
  //   .then((res)=>{
  //     setPosts(res.data)
  //     console.log(res.data);
  //   })
  //   .catch((err)=>{
  //     console.log(err);
  //   })
  //  }
      return (
        <nav className="slidemenu">
           <input type="radio" name="slideItem" id="slide-item-1" className="slide-toggle" onChange={()=>setPosts(undefined)}/>
          <label htmlFor="slide-item-1"><img className="icon" src="https://www.svgrepo.com/show/309942/select-all.svg"/><span>All</span></label>
          {/* Item 1 */}
          <input type="radio" name="slideItem" id="slide-item-2" className="slide-toggle" onChange={()=>setType("Tools & Hardware")} />
          <label htmlFor="slide-item-2"><img className="icon" src="https://cdn-icons-png.flaticon.com/128/289/289741.png"/><span>Tools & Hardware</span></label>
          {/* Item 2 */}
          <input type="radio" name="slideItem" id="slide-item-3" className="slide-toggle" onChange={()=>setType("Home Appliances")}/>
          <label htmlFor="slide-item-3"><img className="icon" src="https://www.svgrepo.com/show/78653/vacuum-cleaner.svg"/><span>home appliances</span></label>
          {/* Item 3 */}
          <input type="radio" name="slideItem" id="slide-item-4" className="slide-toggle" onChange={()=>setType("Electrical")} />
          <label htmlFor="slide-item-4"><img className="icon" src="https://www.svgrepo.com/show/357108/electrical.svg"/><span>Electrical</span></label>
          {/* Item 4 */}
          <input type="radio" name="slideItem" id="slide-item-5" className="slide-toggle" onChange={()=>setType("Paint & Sundries")}/>
          <label htmlFor="slide-item-5"><img className="icon" src="https://www.svgrepo.com/show/233502/paint-roller.svg"/><span>Paint & Sundries</span></label>

          
         
          <div className="clear" />
          {/* Bar */}
          <div className="slider">
            <div className="bar" />
          </div>
        </nav>
      );
    }
export default HomeMenu;