import { Component, h, Prop, State, Event, EventEmitter, Method } from '@stencil/core';
import { HabitStorage } from '../../../utils/storage';
import { Habit } from '../../models/model';

@Component({
  tag: 'page-add-habit',
  styleUrl: './page-add-habit.css',
  shadow: true
})
export class PageAddHabit {
  
    handleHabitAdded = (data : {
        title : string,
        descrption : string,
        target : number,
        done : number,
        completed : boolean,
    })=>{

        const newHabbit : Habit = {
            id : Date.now(),
            title : data.title,
            description : data.descrption,
            target : data.target,
            done : data.done,
            completed : data.completed,
            streak : 0
        };
        HabitStorage.saveHabit(newHabbit);
        alert("habbit added");
    }
  render() {
    return (
      <div>
        <habit-form onHabitAdded={(e : CustomEvent)=>{
            this.handleHabitAdded(e.detail)
        }}></habit-form>
      </div>
    );
  }
}