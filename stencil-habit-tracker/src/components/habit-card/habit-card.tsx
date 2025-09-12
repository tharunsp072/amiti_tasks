import { Component, h, Prop, State, Event, EventEmitter, Method } from '@stencil/core';
import { Habit } from '../models/model';

@Component({
  tag: 'habit-card',
  styleUrl: './habit-card.css',
  shadow: true,
})
export class HabitCard {
  @Prop()
  habit!: Habit;
  @State() completed: boolean = false;
  @State() temp: number = 0;

  @Event()
  removeHabit!: EventEmitter<number>;
  @Event() habitToggled!: EventEmitter<Habit>;
  componentWillLoad() {
    this.completed = this.habit.completed;
  }

  private toggleHabit = () => {
    this.completed = !this.completed;
    this.habit.completed = this.completed;
      

    this.habit.done = this.completed ? this.habit.target : 0;

    this.habitToggled.emit(this.habit);
  };

  private getProgress = () => {

    return (this.habit.done / this.habit.target) * 100;
  };
  handleRemove = (id: number) => {
    this.removeHabit.emit(id);
  };
  render() {
    return (
      <div class="card">
        <button onClick={() => this.handleRemove(this.habit.id)} class="remove-btn">
          ❌
        </button>

        <h3 class="title">{this.habit.title}</h3>
        {this.habit.description && <p class="habit-desc">{this.habit.description}</p>}
        <div class="bottom-container">
          <label htmlFor="checkbox">
            Completed:
            <input type="checkbox" checked={this.completed} onChange={() => this.toggleHabit()} />
          </label>
          <div class="progress-bar">
            <div class="progress-fill" style={{ width: `${this.getProgress()}%` }}></div>
            <div class="progress-text">{this.getProgress()}% Completed</div>
          </div>
        </div>
      </div>
    );
  }
}
