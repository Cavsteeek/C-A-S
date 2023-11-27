//import * as React from 'react';
import Box from '@mui/material/Box';
import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function TeacherSignUp() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [firstName, setFirstname]=useState('')
    const [lastName, setLastname]=useState('')
    const [email, setEmail]=useState('')
    const [password, setPassword]=useState('')
    const handleClick1=(e)=>{
        e.preventDefault()
        const teacher={firstName, lastName, email, password}
        
        fetch("http://localhost:8080/api/v1/cas/auth/Tsignup",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(teacher)
        }).then(response => {
            if (response.ok) {
                console.log("Sign Up Successful");
                alert("Sign Up Successful");
            } else {
                console.log("Sign Up Failed");
                alert("Sign Up Failed");
            }
        })
        .catch(error => {
            console.error("Error during signup:", error);
            alert("Error during signup. Please try again.");
        });
}

    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"black"}}>Signup as Teacher</h1>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1 },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <TextField id="outlined-basic" label="Firstname" variant="outlined" fullWidth 
                    value={firstName}
                    onChange={(e)=>setFirstname(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Lastname" variant="outlined" fullWidth 
                    value={lastName}
                    onChange={(e)=>setLastname(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Teacher Email" variant="outlined" fullWidth 
                    value={email}
                    onChange={(e)=>setEmail(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Teacher Password" variant="outlined" fullWidth 
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    />
                    <Button variant="contained"  sx={{ backgroundColor: 'black', color: 'white' }} onClick={handleClick1}>Sign Up</Button>
                </Box>
            </Paper>

        </Container>
    );
}
