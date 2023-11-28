//import * as React from 'react';
import Box from '@mui/material/Box';
import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';
import { Navigate } from 'react-router-dom';

export default function TeacherLogin() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [email, setEmail]=useState('')
    const [password, setPassword]=useState('')
    const [loginSuccess, setLoginSuccess] = useState(false);

    const handleClick1=(e)=>{
        e.preventDefault()
        const teacher={ email, password }
        if (!teacher.email || !teacher.password) {
            alert("Please fill in all required fields.");
            return;
        }
        
        fetch("http://localhost:8080/api/v1/cas/auth/Tsignin",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(teacher)
        }).then(response => {
            if (response.ok) {
                console.log("Login Successful");
                alert("Login Successful");
                setLoginSuccess(true);
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
                    autoComplete="on"
                >
                    <TextField id="outlined-basic" label="Teacher Email" variant="outlined" fullWidth 
                    value={email}
                    onChange={(e)=>setEmail(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Teacher Password" variant="outlined" fullWidth 
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    />
                    {loginSuccess && <Navigate to="/teacher" />}
                    <Button variant="contained"  sx={{ backgroundColor: 'black', color: 'white' }} onClick={handleClick1}>Login</Button>
                </Box>
            </Paper>
        </Container>
    );
}
