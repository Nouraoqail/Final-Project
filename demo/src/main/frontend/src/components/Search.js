import { useEffect, useState } from "react";
import axios from "axios";

function Search() {
    const [data, setData] = useState();
    const[search,setSearch]=useState();
    const[value,setValue]=useState();
    useEffect(() => {
        axios
            .get(`http://localhost:8080/posts/getByType/${value}`)
            .then((response) => setData(response.data))
            .catch((error) => console.log(error));
    }, [value]);
    
    return (
        
        <div className="search">
       
        <h3>Search</h3>
        <input
        type="text"
        onChange={(e)=>setSearch(e.target.value)}
        placeholder="Enter Search Keyword"/>
        <button variant="outline-danger" onClick={()=>setValue(search)}>Search</button>
        </div>
    )
}
export default Search;