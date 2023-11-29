// script.js
document.addEventListener("DOMContentLoaded" , function(){
    // const btn = document.querySelector('#submitBtn')
    const btn = document.querySelector('.submitBtn')
      
    console.log("Request was made")
    btn.addEventListener("click" , function(){
        const firstname = document.querySelector(".firstName").value;
        const lastname = document.querySelector(".lastName").value;
        const Email = document.querySelector(".email").value;
        const Password = document.querySelector(".password").value;
    
           console.log(firstname)
        console.log("request got here")
        const signUpRequest = {
            firstName : firstname,
            lastName : lastname,
            email : Email,
            password : Password,
            
        };
    
        try {
            const response = fetch('http://localhost:8080/api/v1/cas/auth/Ssignup', {
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
            console.log(error)
        }
    })
})
