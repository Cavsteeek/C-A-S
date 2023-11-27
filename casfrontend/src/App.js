import './App.css';
import Appbar from './components/Appbar';
import StudentLogin from './components/StudentLogin';
import { BrowserRouter as Router, Link, Route, Routes } from 'react-router-dom';
import StudentSignUp from './components/StudentSignUp';
import TeacherSignUp from './components/TeacherSignUp ';
import TeacherLogin from './components/TeacherLogin';
import AdminLogin from './components/AdminLogin';

function App() {
  return (
    <div className="App">
    <Appbar/>
    <Routes>
          <Route path="/signup" element={<StudentSignUp />} />
          <Route path="/login" element={<StudentLogin />} />
          <Route path="/tsignup" element={<TeacherSignUp />} />
          <Route path="/tlogin" element={<TeacherLogin />} />
          <Route path="/alogin" element={<AdminLogin />} />
        </Routes>
    </div>
  );
}

export default App;
