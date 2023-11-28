import React, { useEffect, useState } from 'react';

const TeachersList = () => {
    const [teachers, setTeachers] = useState([]);

    useEffect(() => {
        const getTeachers = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/v1/cas/admin/get-all-users-by-role/TEACHER');
                if (response.ok) {
                    const data = await response.json();
                    setTeachers(data);
                } else {
                    console.error(`Error ${response.status}: ${response.statusText}`);
                }
            } catch (error) {
                console.error('Error during fetch:', error);
            }
        };

        getTeachers();
    }, []);

    const renderTable = () => {
        if (teachers.length === 0) {
            return <p>No teachers found.</p>;
        }

        return (
            <table>
                <thead>
                    <tr>
                        {Object.keys(teachers[0]).map((key) => (
                            <th key={key}>{key}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {teachers.map((teacher, index) => (
                        <tr key={index}>
                            {Object.values(teacher).map((value, index) => (
                                <td key={index}>{value}</td>
                            ))}
                        </tr>
                    ))}
                </tbody>
            </table>
        );
    };

    return (
        <div>
            <h2>Teachers List</h2>
            {renderTable()}
        </div>
    );
};

export default TeachersList;


