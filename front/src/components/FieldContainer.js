import React, {useState} from 'react'
import axios from "axios";
import Field from "./Field";

const axInstance = axios.create(
    {
        baseURL: 'http://localhost:8080/api/simulation',
    }
)
const height = 9
const width = 20

const FieldContainer = () => {
    function create(width, height) {
        axInstance.post('', null, {params: {width, height}})
            .then(_ => update(0))
    }

    function update(count) {
        axInstance.put('', null, {params: {count}})
            .then(r => setField(r.data))
    }


    const [field, setField] = useState([[]])
    const [timerId, setTimerId] = useState(0)
    const [isRunning, setIsRunning] = useState(false)

    return (
        <div>
            <button onClick={() => create(width, height)}>Create</button>
            <button onClick={() => {
                if (!isRunning){
                    setIsRunning(true)
                    setTimerId(setInterval(() => update(50), 200))
                }
            }}>Run
            </button>
            <button onClick={() => {
                if (isRunning){
                    clearInterval(timerId)
                    setIsRunning(false)
                }
            }}>Stop
            </button>
            <Field field={field} height={height} width={width}/>
        </div>
    )
}

export default FieldContainer