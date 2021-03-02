import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';
import HeaderComponent from './components/layout/HeaderComponent';
import 'bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router, Route} from  'react-router-dom';
import AddProject from './components/projects/AddProject';
function App() {
  return (
    <Router>
    <div>
      <HeaderComponent/>
      <Route path="/dashboard" component={Dashboard}/>
      <Route path="/addProject" component={AddProject}/>
    </div>
  </Router>
   
  );
}

export default App;
