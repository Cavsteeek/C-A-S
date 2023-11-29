// Sample data (replace this with actual data retrieval logic)
const studentsData = [
    { id: 1, name: 'Student 1', details: 'Details 1' },
    { id: 2, name: 'Student 2', details: 'Details 2' },
    // Add more student data as needed
];

const attendanceData = [
    { studentId: 1, date: '2023-01-01', status: 'Present' },
    { studentId: 2, date: '2023-01-01', status: 'Absent' },
    // Add more attendance data as needed
];

// Function to populate the students table
function populateStudentsTable() {
    const studentsTable = document.getElementById('studentsTable');
    studentsTable.innerHTML = `
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Details</th>
            <th>Delete</th>
        </tr>
    `;
    
    studentsData.forEach(student => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${student.id}</td>
            <td>${student.name}</td>
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
            <th>Student ID</th>
            <th>Date</th>
            <th>Status</th>
        </tr>
    `;

    attendanceData.forEach(attendance => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${attendance.studentId}</td>
            <td>${attendance.date}</td>
            <td>${attendance.status}</td>
        `;
        attendanceTable.appendChild(row);
    });
}

// Function to simulate deleting a student (replace with actual deletion logic)
function deleteStudent(studentId) {
    alert(`Delete student with ID ${studentId}`);
}

// Call functions to populate tables on page load
populateStudentsTable();
populateAttendanceTable();

// Logout button event listener
document.getElementById('logoutBtn').addEventListener('click', () => {
    // Add logic to navigate to the login page or perform logout
    alert('Logout button clicked');
});
