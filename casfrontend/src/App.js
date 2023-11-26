import './App.css';
import Appbar from './components/Appbar';
import StudentLogin from './components/StudentLogin';
import StudentSignUp from './components/StudentSignUp';

function App() {
  return (
    <div className="App">
    <Appbar/>
    <StudentLogin/>
    {/* <StudentSignUp/> */}
    </div>
  );
}

export default App;
