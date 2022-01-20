const user = JSON.parse(localStorage.getItem("user"));
const token = JSON.parse(localStorage.getItem("token"));
const initialState = {
  user: user ? user : {},
  token: token ? token : undefined,
  isLoggedIn: false
};
// const initialState = {
//     user: [],
//   };
  
  const userReducer = (state = initialState, { type, payload }) => {
    switch (type) {
      case "ADD_USER":
        localStorage.setItem("user", JSON.stringify(payload));
        return {
          user: payload,
          token: state.token,
          isLoggedIn: true
        };
      case "LOG_OUT":
        return{
          user:{},
          isLoggedIn: false
        };
      case "ADD_TOKEN":
        localStorage.setItem("token", JSON.stringify(payload));
        return {
          user: state.user,
          token: payload,
        };
        case "UpdateUser":
          localStorage.removeItem("user")
          localStorage.setItem("user", JSON.stringify(payload));
          return {
            user: payload,
            token: state.token,
            isLoggedIn: state.isLoggedIn
          };
      // case "REMOVE_USER":
      //   localStorage.removeItem("user");
      //   return {
      //     user: {},
      //     token: undefined
      //   };
  
      default:
        return state;
    }
    // switch (type) {
    //   case "ADD_USER":
    //     return {
    //         user: [...state.user, payload],
    //     };
     
    //   default:
    //     return state;
    // }
  };
  
  export default userReducer;
  
  
  


