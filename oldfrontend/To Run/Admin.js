function authenticateAdmin() {
    // Implement your authentication logic here
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // Example: Check if the username and password are correct
    if (username === 'admin' && password === 'admin123') {
        // Redirect to the admin dashboard
        window.location.href = 'admin-dashboard.html';
    } else {
        alert('Invalid credentials. Please try again.');
    }
}
