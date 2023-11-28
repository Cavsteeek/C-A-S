// script.js
document.addEventListener("DOMContentLoaded" , function(){
    // const btn = document.getElementById('#submitBtn')
    const btn = document.querySelector('.submitBtn')
      
    console.log("Request was made")
    btn.addEventListener("click" , function(){
        const firstName = document.getElementById("#firstName").value;
        const lastName = document.getElementById("#lastName").value;
        const email = document.getElementById("#email").value;
        const password = document.getElementById("#password").value;
        const confirmPassword = document.getElementById("#confirmPassword").value;
           
        console.log("request got here")
        const signUpRequest = {
            firstName,
            lastName,
            email,
            password,
            confirmPassword
        };
    
        try {
            const response = fetch('/api/v1/cas/auth/Ssignup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(signUpRequest),
            });
    
            const data = response.json();
            alert(data); // Display response from the server
    
            // You can redirect to another page or handle the response accordingly
        } catch (error) {
            console.error('Error during signup:', error);
        }
    })
})
