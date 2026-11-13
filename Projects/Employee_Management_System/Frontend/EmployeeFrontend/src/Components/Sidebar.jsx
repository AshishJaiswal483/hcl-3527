import './Sidebar.css';

function Sidebar({ activePage, setActivePage }) {
  const menuItems = [
    "Dashboard",
    "All Employees",
    "Add Employee",
    "Search Employee",
    "Department-wise",
    "Delete Employee"
  ];

  return (
    <aside className="sidebar">
      <h2 className="logo">EMS</h2>

      <nav className="sidebar-menu">
        {menuItems.map((item) => (
          <a
            key={item}
            href="#"
            className={activePage === item ? "active" : ""}
            onClick={(e) => {
              e.preventDefault();
              setActivePage(item);
            }}
          >
            {item}
          </a>
        ))}
      </nav>
    </aside>
  );
}

export default Sidebar;
