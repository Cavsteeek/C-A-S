//import * as React from 'react';
import Box from '@mui/material/Box';
import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function StudentSignUp() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [firstName, setFirstname]=useState('')
    const [lastName, setLastname]=useState('')
    const [email, setEmail]=useState('')
    const [password, setPassword]=useState('')
    const handleClick=(e)=>{
        e.preventDefault()

        if (!validateName(firstName) || !validateName(lastName) || !validateEmail(email) || !validatePassword(password)) {
            alert("Invalid input. Please check the provided fields.");
            return;
        }
        const student={firstName, lastName, email, password}
        
        fetch("http://localhost:8080/api/v1/cas/auth/Ssignup",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(student)
        }).then((response) => {
            if (response.ok) {
                console.log("Sign Up Successful");
                alert("Sign Up Successful");
            } else if (response.status === 400) {
                console.log("Sign Up Failed: User With Email Already Exists");
                alert("Sign Up Failed: User With Email Already Exists");
            } else {
                console.log("Sign Up Failed");
                alert("Sign Up Failed");
            }
        })
        .catch((error) => {
            console.error("Error during Sign Up:", error);
            alert("Error during Sign Up. Please try again.");
        });
}
const validateName = (name) => {
    return name.length >= 5;
}

const validateEmail = (email) => {
    // Simple email validation using regex
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

const validatePassword = (password) => {
    return password.length >= 8;
}
    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"black"}}>Signup as Student</h1>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1 },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <TextField id="outlined-basic" label="Firstname" variant="outlined" fullWidth 
                    required
                    value={firstName}
                    onChange={(e)=>setFirstname(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Lastname" variant="outlined" fullWidth 
                    required
                    value={lastName}
                    onChange={(e)=>setLastname(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student Email" variant="outlined" fullWidth 
                    required
                    type='email'
                    value={email}
                    onChange={(e)=>setEmail(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student Password" variant="outlined" fullWidth 
                    required
                    type="password"
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    />
                    <Button variant="contained"  sx={{ backgroundColor: 'black', color: 'white' }} onClick={handleClick}>Sign Up</Button>
                </Box>
            </Paper>
        </Container>
    );
}
