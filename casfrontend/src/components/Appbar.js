import * as React from 'react';
import { Link } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import StudentSignUp from './StudentSignUp';

export default function Appbar() {
    return (
            <Box sx={{ flexGrow: 1 }}>
                <AppBar position="static" sx={{ background: 'black' }}>
                    <Toolbar>
                        <Typography variant="h6" component="div" sx={{ flexGrow: 1 , color: 'white'}}>
                            _- C-A-S -_
                        </Typography>
                        <Link to="/signup" style={{ textDecoration: 'none' }}>
                            <Button variant="contained" sx={{ backgroundColor: 'black', color: 'white' }}>
                                Sign Up
                            </Button>
                        </Link>
                        <Link to="/login" style={{ textDecoration: 'none' }}>
                            <Button variant="contained" sx={{ backgroundColor: 'black', color: 'white' }}>
                                Login
                            </Button>
                        </Link>
                    </Toolbar>
                </AppBar>
            </Box>
    );
}
