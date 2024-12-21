import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getEmployees } from '../../redux/slices/employeeSlice';
import { Table, TableBody, TableCell, TableHead, TableRow, Button } from '@mui/material';

const EmployeeTable = () => {
    const dispatch = useDispatch();
    const employees = useSelector((state) => state.employees.list);

    useEffect(() => {
        dispatch(getEmployees());
    }, [dispatch]);

    return (
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Name</TableCell>
                    <TableCell>Email</TableCell>
                    <TableCell>Actions</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {employees.map((employee) => (
                    <TableRow key={employee.id}>
                        <TableCell>{employee.name}</TableCell>
                        <TableCell>{employee.email}</TableCell>
                        <TableCell>
                            <Button>Edit</Button>
                            <Button>Delete</Button>
                        </TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
    );
};

export default EmployeeTable;
