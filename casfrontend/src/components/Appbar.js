import * as React from 'react';
import { Link } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';


export default function Appbar() {
    return (
            <Box sx={{ flexGrow: 1 }}>
                <AppBar position="static" sx={{ background: 'black' }}>
                    <Toolbar>
                        <Typography variant="h6" component="div" sx={{ flexGrow: 1 , color: 'white'}}>
                            C-A-S
                        </Typography>
                        <Link to="/signup" style={{ textDecoration: 'none' }}>
                            <Button variant="contained" sx={{ backgroundColor: 'black', color: 'white' }}>
                                Sign Up as Student
                            </Button>
                        </Link>
                        <Link to="/login" style={{ textDecoration: 'none' }}>
                            <Button variant="contained" sx={{ backgroundColor: 'black', color: 'white' }}>
                                Login as Student
                            </Button>
                        </Link>
                        <Link to="/tlogin" style={{ textDecoration: 'none' }}>
                            <Button variant="contained" sx={{ backgroundColor: 'black', color: 'white' }}>
                                Login as Teacher
                            </Button>
                        </Link>
                        <Link to="/alogin" style={{ textDecoration: 'none' }}>
                            <Button variant="contained" sx={{ backgroundColor: 'black', color: 'white' }}>
                                Admin Login
                            </Button>
                        </Link>
                    </Toolbar>
                </AppBar>
            </Box>
    );
}
