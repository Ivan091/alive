import React, {useState} from 'react'
import axios from "axios";
import Field from "./Field";
import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';

const url = 'http://localhost:8080/'

const axInstance = axios.create(
    {
        baseURL: url + 'api/simulation',
    }
)


const height = 19
const width = 40

const sock = Stomp.over(new SockJS(url + 'ws'))
sock.debug = () => {
}

const FieldContainer = () => {
    function create(width, height) {
        axInstance.post('', null, {params: {width, height}})
            .then(_ => update(0))
    }

    function update(count) {
        sock.send('/app/simulation', {}, count)
    }

    sock.connect({}, () => {
        sock.subscribe('/topic/simulation', (frame) => {
            setField(JSON.parse(frame.body))
        })
    })

    const [field, setField] = useState([[]])
    const [timerId, setTimerId] = useState(0)
    const [isRunning, setIsRunning] = useState(false)

    return (
        <div>
            <button onClick={() => create(width, height)}>Create</button>
            <button onClick={() => {
                if (!isRunning) {
                    setIsRunning(true)
                    setTimerId(setInterval(() => update(50), 20))
                }
            }}>Run
            </button>
            <button onClick={() => {
                if (isRunning) {
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