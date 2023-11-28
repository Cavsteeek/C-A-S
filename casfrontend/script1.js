

async function signin() {
    const signinEmail = document.getElementById("signinEmail").value;
    const signinPassword = document.getElementById("signinPassword").value;

    const signInRequest = {
        email: signinEmail,
        password: signinPassword
    };

    try {
        const response = await fetch('/api/v1/cas/auth/Ssignin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(signInRequest),
        });

        const data = await response.json();
        alert(data.token); // Display the token received from the server

        // You can redirect to another page or handle the response accordingly
    } catch (error) {
        console.error('Error during signin:', error);
    }
}
