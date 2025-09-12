import { Component, h, Prop, State, Event, EventEmitter, Method } from '@stencil/core';
import { Habit } from '../../models/model';
import { HabitStorage } from '../../../utils/storage';

@Component({
  tag: 'page-dashboard',
  styleUrl: 'page-dashboard.css',
  shadow: true,
})
export class PageDashboard {
  @State() habits: Habit[] = [];

  componentWillLoad() {
    this.habits = HabitStorage.getHabits();
  }

  private handleRemove=(id :number)=>{
    HabitStorage.removeHabit(id);
    this.habits = HabitStorage.getHabits();
  }
  render() {
    return (
      <div class="main-container">
        <div class="card-container">{this.habits && this.habits.map(habit => <habit-card habit={habit} onRemoveHabit={(e:CustomEvent)=>this.handleRemove(e.detail)}></habit-card>)}</div>
      </div>
    );
  }
}
