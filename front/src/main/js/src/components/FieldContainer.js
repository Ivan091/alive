import React, {useState} from 'react'
import axios from "axios";
import Field from "./Field";

const axInstance = axios.create(
    {
        baseURL: 'locanhost:8080/api/simulation',
        headers: {
            'Access-Control-Allow-Origin': '*',
        }
    }
)
const height = 9
const width = 20

const FieldContainer = (props) => {
    function create(width, height){
        axInstance.post('', {width: width, height: height})
            .then(r => setField(r.data))
    }

    function update(count){
        axInstance.put('', {count: count})
            .then(r => setField(r.data))
    }


    const [field, setField] = useState([[]])

    return (
        <div>
            <button onClick={() => create(width, height)}>Create</button>
            <button onClick={() => update(10)}>Update</button>
            <Field field={field} height={height} width={width}/>
        </div>
    )
}

export default FieldContainer