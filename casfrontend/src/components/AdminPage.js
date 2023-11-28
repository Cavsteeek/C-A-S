import React, { useState } from 'react';
import TeachersList from './TeachersList';

const AdminPage = () => {
    const [displayContent, setDisplayContent] = useState(null);

    const fetchData = async (role) => {
        try {
            const response = await fetch(`http://localhost:8080/api/v1/cas/admin/get-all-users-by-role/${role}`);
            if (response.ok) {
                const data = await response.json();
                setDisplayContent(<TeachersList data={data} />);
            } else {
                console.error(`Error ${response.status}: ${response.statusText}`);
            }
        } catch (error) {
            console.error('Error during fetch:', error);
        }
    };

    return (
        <div>
            <h1>Welcome Admin</h1>
            <button onClick={() => fetchData('TEACHER')}>Teachers</button>
            <button onClick={() => fetchData('STUDENT')}>Students</button>
            <button onClick={() => fetchData('COURSE')}>Courses</button>
            {displayContent}
        </div>
    );
};

export default AdminPage;
