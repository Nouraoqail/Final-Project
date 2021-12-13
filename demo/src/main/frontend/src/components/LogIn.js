import {useEffect,useState} from "react-dom";
import axios from "axios"
import {Form,Button} from "react-bootstrap"
function LogIn() {
  // const[data,setData]=useState();
  // useEffect(() => {
  //   axios
  //     .get("http://localhost:8080/users")
  //     .then((response) => setData(response.data))
  //     .catch((error) => console.log(error));
  // }, []);
    return(
        <div>
            <Form>
  <Form.Group className="mb-3" controlId="formBasicEmail">
    <Form.Label>National ID</Form.Label>
    <Form.Control type="text" placeholder="Enter your national id" />
    <Form.Text className="text-muted">
      We'll never share your NID with anyone else.
    </Form.Text>
  </Form.Group>

  <Form.Group className="mb-3" controlId="formBasicPassword">
    <Form.Label>Password</Form.Label>
    <Form.Control type="password" placeholder="Password" />
  </Form.Group>
  <Form.Group className="mb-3" controlId="formBasicCheckbox">
    <Form.Check type="checkbox" label="Check me out" />
  </Form.Group>
  <Button variant="primary" type="submit">
    Submit
  </Button>
</Form>
        </div>
    )
}
export default LogIn;