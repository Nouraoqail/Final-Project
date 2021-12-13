const initialState = {
    user: [],
  };
  
  const user = (state = initialState, { type, payload }) => {
    switch (type) {
      case "ADD_USER":
        return {
            user: [...state.user, payload],
        };
     
      default:
        return state;
    }
  };
  
  export default user;
  
  export const addUser = (user) => {
      console.log("new user added");
      console.log(user);
    return {
      type: "ADD_USER",
      payload: user,
    };
  };
  


