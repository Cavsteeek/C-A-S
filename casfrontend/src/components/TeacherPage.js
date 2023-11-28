import React, { useState } from 'react';


const TeacherPage = () => {
    const [displayContent, setDisplayContent] = useState(null);

    const fetchData = async (role) => {
        try {
            const response = await fetch(`http://localhost:8080/api/v1/cas/find-all-students`);
            if (response.ok) {
                const data = await response.json();
            } else {
                console.error(`Error ${response.status}: ${response.statusText}`);
            }
        } catch (error) {
            console.error('Error during fetch:', error);
        }
    };

    return (
        <div>
            <h1>Welcome</h1>
            <button onClick={() => fetchData('STUDENT')}>Students</button>
            <button onClick={() => fetchData('COURSE')}>Courses</button>
            {displayContent}
        </div>
    );
};

export default TeacherPage;
