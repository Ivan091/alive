import React from 'react'
import Cell from "./Cell";

const FieldMatrix = ({field, height, width}) => (
    <svg viewBox={`0 0 ${width} ${height}`}>
        {
            field.map((xAxis, i) =>
                xAxis.map((entity, j) =>
                    <Cell key={`x${i}y${j}`} size={1} fill={entity.fill} x={i} y={j}/>
                )
            )
        }
    </svg>
)

export default FieldMatrix