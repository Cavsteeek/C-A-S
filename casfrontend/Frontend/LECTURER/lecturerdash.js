// Sample data (replace this with actual data retrieval logic)
const studentsData = [
    { id: 2,firstname: 'Ebube' ,lastname: 'Usoho', details: 'ikem@gmail.com' },
    { id: 3,firstname: 'Smith' ,lastname: 'Rowe', details: 'john@gmail.com' },
    // Add more student data as needed
];

const attendanceData = [
    { id: 1, date: '2023-11-28 14:27:21.680000', courseId :5,studentId: 2 },
    { id: 2, date: '2023-11-29 21:50:12.744000', courseId : 1, studentId: 2 },
    // Add more attendance data as needed
];

const coursesData = [
    { id: 1, coursecode: 'COSC 323' },
    { id: 2, coursecode: 'SENG 333' },
    { id: 3, coursecode: 'COSC 303' },
    { id: 4, coursecode: 'COSC 337' },
    { id: 5, coursecode: 'SENG 314' },
    // Add more attendance data as needed
];

// Function to populate the students table
function populateStudentsTable() {
    const studentsTable = document.getElementById('studentsTable');
    studentsTable.innerHTML = `
        <tr>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Delete</th>
        </tr>
    `;
    
    studentsData.forEach(student => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${student.id}</td>
            <td>${student.firstname}</td>
            <td>${student.lastname}</td>
            <td>${student.details}</td>
            <td><button onclick="deleteStudent(${student.id})">Delete</button></td>
        `;
        studentsTable.appendChild(row);
    });
}

// Function to populate the attendance table
function populateAttendanceTable() {
    const attendanceTable = document.getElementById('attendanceTable');
    attendanceTable.innerHTML = `
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Course ID</th>
            <th>Student ID</th>
        </tr>
    `;

    attendanceData.forEach(attendance => {
        const row = document.createElement('tr');
        row.innerHTML = `
        <td>${attendance.id}</td>
            <td>${attendance.date}</td>
            <td>${attendance.courseId}</td>
            <td>${attendance.studentId}</td>
        `;
        attendanceTable.appendChild(row);
    });
}

function populateCoursesTable() {
    const coursesTable = document.getElementById('coursesTable');
    coursesTable.innerHTML = `
        <tr>
            <th>Course ID</th>
            <th>Course Code</th>
        </tr>
    `;
    
    coursesData.forEach(courses => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${courses.id}</td>
            <td>${courses.coursecode}</td>
        `;
        coursesTable.appendChild(row);
    });
}

// Function to simulate deleting a student (replace with actual deletion logic)
function deleteStudent(studentId) {
    alert(`Delete student with ID ${studentId}`);
}




// Call functions to populate tables on page load
populateStudentsTable();
populateAttendanceTable();
populateCoursesTable();


// Logout button event listener
document.getElementById('logoutBtn').addEventListener('click', () => {
    // Add logic to navigate to the login page or perform logout
    alert('Logout button clicked');
});
