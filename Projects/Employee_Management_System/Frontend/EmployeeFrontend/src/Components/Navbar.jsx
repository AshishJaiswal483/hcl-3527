
import { useState } from 'react';
import './Navbar.css';

function Navbar() {
  const [showDropdown, setShowDropdown] = useState(false);

  const handleLogout = () => {
    localStorage.removeItem('token');
    window.dispatchEvent(new Event('auth-logout'));
  };

  return (
    <header className="navbar">

      <h3>Employee Management System</h3>

      <div className="navbar-profile">

        <div
          className="profile-info"
          onClick={() => setShowDropdown(!showDropdown)}
        >
          <div className="profile-circle">AJ</div>

          <span>Ashish Jaiswal</span>

          <span className="dropdown-icon">
            {showDropdown ? '⌃' : '⌄'}
          </span>
        </div>

        {showDropdown && (
          <div className="profile-dropdown">
            <button onClick={handleLogout}>
              Logout
            </button>
          </div>
        )}

      </div>

    </header>
  );
}

export default Navbar;


