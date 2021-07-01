import React from 'react'

const Cell = ({fill, size, x, y}) => (
    <rect fill={fill} width={size} height={size} x={x} y={y}/>
)


export default Cell