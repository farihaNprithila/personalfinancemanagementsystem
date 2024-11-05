import React, {useState} from 'react'

export const ToDoForm = () => {
    const [value, setValue] = useState("");
    return (
        <form className='to-do-form'>
            <input type="text" className="todo-input" placeholder={"What is the task?"}/>
            <button type={"submit"} className={"to-do-button"}>Add Task</button>
        </form>
    )
}