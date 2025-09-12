import { Habit } from '../components/models/model';

const STORAGE_KEY = 'habits';

export const HabitStorage = {
  getHabits(): Habit[] {
    const stored = localStorage.getItem(STORAGE_KEY);
    return stored ? JSON.parse(stored) : [];
  },
  saveHabit(habit: Habit) {
    const habits = this.getHabits();
    habits.push(habit);
    localStorage.setItem(STORAGE_KEY, JSON.stringify(habits));
  },
  saveAll(habits: Habit[]) {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(habits));
  },
  removeHabit(id: number) {
    const habits = this.getHabits();
    const updated = habits.filter(h => h.id != id);
    this.saveAll(updated);
  }
};
