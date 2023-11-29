document.addEventListener("DOMContentLoaded", async function () {
    const btn = document.querySelector('.submitbtn');

    btn.addEventListener("click", async function () {
        const signinEmail = document.querySelector(".email").value;
        const signinPassword = document.querySelector(".password").value;

        const signInRequest = {
            email: signinEmail,
            password: signinPassword
        };

        try {
            const response = await fetch('http://localhost:8080/api/v1/cas/auth/Ssignin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(signInRequest),
            });

            if (response.ok) {
                const data = await response.json();
                alert(data.token); // Display the token received from the server
            } else {
                console.error('Sign-in failed:', response.status, response.statusText);
            }
        } catch (error) {
            console.error('Error during signin:', error);
        }
    });
});
