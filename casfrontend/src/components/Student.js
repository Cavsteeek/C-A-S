//import * as React from 'react';
import Box from '@mui/material/Box';
import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, colors } from '@mui/material';

export default function Student() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [email, setEmail]=useState('')
    const [password, setPassword]=useState('')
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
                    value={email}
                    onChange={(e)=>setEmail(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student Password" variant="outlined" fullWidth 
                    value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    />

                </Box>
            </Paper>
        </Container>
    );
}
