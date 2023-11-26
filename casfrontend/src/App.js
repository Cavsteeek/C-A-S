import './App.css';
import Appbar from './components/Appbar';
import StudentLogin from './components/StudentLogin';
import { BrowserRouter as Router, Link, Route, Routes } from 'react-router-dom';
import StudentSignUp from './components/StudentSignUp';

function App() {
  return (
    <div className="App">
    <Appbar/>
    <Routes>
          <Route path="/signup" element={<StudentSignUp />} />
          <Route path="/login" element={<StudentLogin />} />
        </Routes>
    </div>
  );
}

export default App;
