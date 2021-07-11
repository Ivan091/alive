import React from 'react'
import Cell from "./Cell";

const Field = ({field, height, width}) => (
    <svg viewBox={`0 0 ${width} ${height}`}>
        {
            field.map((xAxis, i) =>
                xAxis.map((entity, j) =>
                    <Cell key={`x${i}y${j}`} size={1.1} fill={entity.color} x={i} y={j}/>
                )
            )
        }
    </svg>
)

export default Field