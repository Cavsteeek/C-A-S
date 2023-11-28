//import * as React from 'react';
import Box from '@mui/material/Box';
import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function StudentLogin() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [email, setEmail]=useState('')
    const [password, setPassword]=useState('')
    
    const handleClick=(e)=>{
        e.preventDefault()
        
        const student={email,password}
        if (!student.email || !student.password) {
            alert("Please fill in all required fields.");
            return;
        }
    
        fetch("http://localhost:8080/api/v1/cas/auth/Ssignin",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(student)
        }).then(response => {
            if (response.ok) {
                console.log("Login Successful");
                alert("Login Successful");
            } else {
                console.log("Login Failed");
                alert("Login Failed");
            }
        })
        .catch(error => {
            console.error("Error during login:", error);
            alert("Error during login. Please try again.");
        });
}

    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"black"}}>Login</h1>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1 },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <TextField id="outlined-basic" label="Student Email" variant="outlined" fullWidth 
                    required
                    type='email'
                    value={email}
                    onChange={(e)=>setEmail(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student Password" variant="outlined" fullWidth 
                    required
                    type='password'
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    />
                    <Button variant="contained"  sx={{ backgroundColor: 'black', color: 'white' }} onClick={handleClick}>Login</Button>
                </Box>
            </Paper>
        </Container>
    );
}
