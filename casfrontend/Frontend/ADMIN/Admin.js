async function authenticateAdmin() {
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
        const response = await fetch('http://localhost:8080/api/v1/cas/auth/Asignin', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data),
        });

        const responseData = await response.json();

        if (response.ok) {
            // Redirect to admin dashboard if the response is successful
            window.location.href = 'AdminDashboard.htm';
        } else {
            // Display an alert for unsuccessful login
            alert(responseData.message || 'Error during login. Please try again.');
        }
    } catch (error) {
        console.error('Error during login:', error);
        alert('Error during login. Please try again.');
    }
}



/*
async function authenticateAdmin() {
    var username = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    const signInRequest = {
        email: username,
        password: password
    };
    
    if (!username || !password) {
        console.log('Please fill in all required fields.');
        return;
    }

    try {
        const response = await fetch('http://localhost:8080/api/v1/cas/auth/Asignin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(signInRequest),
        });

        if (response.status === 200) {
            // Redirect to admin dashboard if the response is successful
            window.location.href = 'admin-dashboard.html';
        } else {
            // Display an alert for unsuccessful login
            console.log('Invalid credentials. Please try again.');
        }
    } catch (error) {
        console.error('Error during login:', error);
    }
}
*/



/*
async function authenticateAdmin() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    // Example: Check if the email and password are provided
    if (!email || !password) {
        alert('Please fill in all required fields.');
        return;
    }

    var data = { email: email, password: password };

    try {
        const response = await fetch('http://localhost:8080/api/v1/cas/auth/Asignin', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data),
        });

        const responseData = await response.json();

        if (response.status === 200) {
            // Redirect to admin dashboard if the response is successful
            window.location.href = 'admin-dashboard.html';
        } else {
            // Display an alert for unsuccessful login
            alert(responseData.message);
        }
    } catch (error) {
        console.error('Error during login:', error);
        alert('Error during login. Please try again.');
    }
}
*/