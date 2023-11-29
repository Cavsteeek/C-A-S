document.addEventListener('DOMContentLoaded', function () {
    // Sample courses data (replace with your actual data)
    const courses = ['COSC 323', 'SENG 333', 'COSC 303', 'COSC 337', 'SENG 314', 'GEDS 317', 'GEDS 303', 'ACC 001'];

    // Buttons
    const btnSignAttendance = document.getElementById('btnSignAttendance');
    const btnViewCourses = document.getElementById('btnViewCourses');
    const btnLogout = document.getElementById('btnLogout');

    // Content container
    const mainContent = document.getElementById('mainContent');

    // Event listeners
    btnSignAttendance.addEventListener('click', signAttendance);
    btnViewCourses.addEventListener('click', viewCourses);
    btnLogout.addEventListener('click', logout);

    // Functions
    function signAttendance() {
        // Implement sign attendance logic
        displayMessage("Attendance signed successfully!");
    }

    function viewCourses() {
        // Display courses
        const coursesList = document.createElement('ul');
        courses.forEach(course => {
            const courseItem = document.createElement('li');
            courseItem.textContent = course;
            coursesList.appendChild(courseItem);
        });

        // Replace the main content with the courses list
        displayContent(coursesList);
    }

    function logout() {
        // Redirect to the login page (replace 'login.html' with your actual login page)
        window.location.href = 'studentlogin.htm';
    }

    function displayContent(content) {
        // Clear existing content and display new content
        mainContent.innerHTML = '';
        mainContent.appendChild(content);
    }

    function displayMessage(message) {
        // Display a message to the user
        const messageElement = document.createElement('p');
        messageElement.textContent = message;

        // Replace the main content with the message
        displayContent(messageElement);
    }
});
