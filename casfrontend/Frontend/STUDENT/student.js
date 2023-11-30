async function authenticateStudentSignUp() {
    // Implement your authentication logic here
    var Firstname = document.getElementById('firstName').value;
    var Lastname = document.getElementById('lastName').value;
    var Email = document.getElementById('email').value;
    var Password = document.getElementById('password').value;

    // Example: Check if the username and password are correct
    if (!Email || !Password || !Firstname || !Lastname) {
        alert('Please fill in all required fields.');
        return;
    }
    var data = { firstName : Firstname, lastName : Lastname, email: Email, password: Password };
    try {
        const response = await fetch('http://localhost:8080/api/v1/cas/auth/Ssignup', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data),
        });

        const responseData = await response.json();

        if (response.ok) {
            // Redirect to admin dashboard if the response is successful
            alert("Sign Up successful");
        } else {
            // Display an alert for unsuccessful login
            alert(responseData.message || 'Error during login. Please try again.');
        }
    } catch (error) {
        console.error('Error during login:', error);
        alert('Error during login. Please try again.');
    }
}