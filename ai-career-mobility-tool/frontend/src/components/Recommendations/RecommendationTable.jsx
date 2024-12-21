import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getRecommendations } from '../../redux/slices/recommendationSlice';
import { Table, TableBody, TableCell, TableHead, TableRow, Button } from '@mui/material';

const RecommendationTable = () => {
    const dispatch = useDispatch();
    const recommendations = useSelector((state) => state.recommendations.list);

    useEffect(() => {
        dispatch(getRecommendations());
    }, [dispatch]);

    return (
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Title</TableCell>
                    <TableCell>Details</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {recommendations.map((rec) => (
                    <TableRow key={rec.id}>
                        <TableCell>{rec.title}</TableCell>
                        <TableCell>{rec.details}</TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
    );
};

export default RecommendationTable;
