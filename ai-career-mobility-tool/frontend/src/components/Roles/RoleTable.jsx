import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getRoles } from '../../redux/slices/roleSlice';
import { Table, TableBody, TableCell, TableHead, TableRow } from '@mui/material';

const RoleTable = () => {
    const dispatch = useDispatch();
    const roles = useSelector((state) => state.roles.list);

    useEffect(() => {
        dispatch(getRoles());
    }, [dispatch]);

    return (
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Role Name</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {roles.map((role) => (
                    <TableRow key={role.id}>
                        <TableCell>{role.name}</TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
    );
};

export default RoleTable;
