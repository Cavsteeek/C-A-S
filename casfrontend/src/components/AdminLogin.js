//import * as React from 'react';
import Box from '@mui/material/Box';
import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function AdminLogin() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [email, setEmail]=useState('')
    const [password, setPassword]=useState('')
    const handleClick2 = (e) => {
        e.preventDefault();
        const admin = { email, password };
    
        fetch("http://localhost:8080/api/v1/cas/auth/signin", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(admin),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Login failed");
                }
                return response.json();
            })
            .then((data) => {
                console.log("Login Successful");
                alert("Login Successful");
            })
            .catch((error) => {
                console.error("Login failed", error);
                alert("Login failed");
            });
    };
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
                    <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth 
                    value={email}
                    onChange={(e)=>setEmail(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Password" variant="outlined" fullWidth 
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    />
                    <Button variant="contained"  sx={{ backgroundColor: 'black', color: 'white' }} onClick={handleClick2}>Login</Button>
                </Box>
            </Paper>
        </Container>
    );
}
