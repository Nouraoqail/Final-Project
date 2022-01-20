export const addUser = (user) => {
    console.log("new user added");
    console.log(user);
    return {
      type: "ADD_USER",
      payload: user,
    };
  };
  export const addToken = (token) => {
    return {
      type: "ADD_TOKEN",
      payload: token,
    };
  };
export const logout = (user) => {
  console.log("logged out");
    return {
      type: "LOG_OUT",
      payload: user,
    };
  };

  export const UpdateUser = (user) => {
 
      return {
        type: "UpdateUser",
        payload: user,
      };
    };
  
  
//   export const removeUser = () => {
//     return {
//       type: "REMOVE_USER",
//     };
//   };
  