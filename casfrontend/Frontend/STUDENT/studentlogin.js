async function authenticateStudent() {
    // Implement your authentication logic here
    var Email = document.getElementById('email').value;
    var Password = document.getElementById('password').value;

    // Example: Check if the username and password are correct
    if (!Email || !Password) {
        alert('Please fill in all required fields.');
        return;
    }
    var data = { email: Email, password: Password };
    try {
        const response = await fetch('http://localhost:8080/api/v1/cas/auth/Ssignin', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data),
        });

        const responseData = await response.json();

        if (response.ok) {
            // Redirect to admin dashboard if the response is successful
            window.location.href = 'studentdash.htm';
        } else {
            // Display an alert for unsuccessful login
            alert(responseData.message || 'Error during login. Please try again.');
        }
    } catch (error) {
        console.error('Error during login:', error);
        alert('Error during login. Please try again.');
    }
}