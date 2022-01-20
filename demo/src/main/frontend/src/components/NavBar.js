import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import PersonIcon from '@material-ui/icons/Person';
import EditIcon from '@material-ui/icons/Edit';
import DynamicFeedIcon from '@material-ui/icons/DynamicFeed';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import { Link, useNavigate } from 'react-router-dom';
import { logout } from '../reducers/user/actions'
import Swal from 'sweetalert2';
import '../StyleSheets/NavBar.css';

function NavBar() {
  const [navbar, setNavbar] = useState(false);
  const [click, setClick] = useState(false);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const changeBackground = () => {
    if (window.scrollY >= 265) {
      setNavbar(true);
    } else {
      setNavbar(false);
    }
  };
  window.addEventListener("scroll", changeBackground);
  return (
    <>
      <nav className={navbar ? "navbarr activee" : "navbarr"}>
        {/* <Link to="/" className='navbar-logo'>
          Borrow <span className='span'>It</span>
        <i class='fab fa-firstdraft' />
        </Link> */}
        <div className='menu-icon'>
          <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
        </div>
        <ul className={click ? 'nav-menu active' : 'nav-menu'}>
          <li className='nav-item'>
            <Link
              to="/"
              className='nav-links'
            >
              Home
            </Link>
          </li>
          <li className='nav-item'>
            <Link to="/Post" className='nav-links'>Add Post</Link>
          </li>
          <li
            className='nav-item'
          >
            <Link to="/Register" className='nav-links'>
              Register

            </Link>
          </li>
          <li className='nav-item'>
            <Link to="/AboutUs" className='nav-links'>About Us</Link>
          </li>

          <li className='nav-item'>
            <div className="dropdown">
              <PersonIcon className='NavImg' />
              <div className="dropdown-content">
                <Link to="/UserProfile" className='nav-links'><EditIcon className='DropImg' />  Profile</Link>
                <Link to="/MyPosts" className='nav-links'><DynamicFeedIcon className='DropImg' /> My Posts</Link>
                <Link to="/" className='nav-links' onClick={() => {
                  const action = logout();
                  dispatch(action);
                  Swal.fire({
                    icon: 'success',
                    text: 'You have successfully logged out!',
                    timer: 3000
                  }
                  )
                }}><ExitToAppIcon className='DropImg' /> LogOut</Link>
              </div>
            </div>
          </li>
        </ul>
        {/* <Button /> */}
      </nav>
    </>
  );
}

export default NavBar;
