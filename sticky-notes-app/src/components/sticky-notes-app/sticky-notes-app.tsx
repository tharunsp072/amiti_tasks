import { Component, h, State } from '@stencil/core';
import { Note, NoteDraft } from '../../interfaces/models';

@Component({
  tag: 'sticky-notes-app',
  styleUrl: './sticky-notes-app.css',
  shadow: true
})
export class StickyNotesApp {
  @State() notes: Note[] = [];
  @State() showForm: boolean = false;

  private storageKey = 'stencil-sticky-notes';

  componentWillLoad() {
    const saved = localStorage.getItem(this.storageKey);
    if (saved) {
      this.notes = JSON.parse(saved);
    }
  }

  private saveNotes(notes: Note[]) {
    this.notes = notes;
    localStorage.setItem(this.storageKey, JSON.stringify(notes));
  }

  private handleNoteCreated = (event: CustomEvent<NoteDraft>) => {
    const draft = event.detail;
    const newNote: Note = {
      ...draft,
      id: `note-${Date.now()}`,
      position: { x: 50, y: 50 },
      createdAt: new Date().toISOString(),
    };
    this.saveNotes([...this.notes, newNote]);
    this.showForm = false; // close modal after creating note
  };

  private handleNoteMoved = (event: CustomEvent<{ noteId: string; x: number; y: number }>) => {
    const { noteId, x, y } = event.detail;
    const updated = this.notes.map((n) =>
      n.id == noteId ? { ...n, position: { x, y }, updatedAt: new Date().toISOString() } : n
    );
    this.saveNotes(updated);
  };

  private handleNoteRemoved = (event: CustomEvent<{ noteId: string }>) => {
    const { noteId } = event.detail;
    const updated = this.notes.filter((note) => note.id !== noteId);
    this.saveNotes(updated);
    console.log("After delete",updated);
  };

  private toggleForm = () => {
    this.showForm = !this.showForm;
  };

  render() {
    return (
      <div class="app">
        <header>
          <h1>📝 Sticky Notes</h1>
          <button class="new-note-btn" onClick={this.toggleForm}>+ New Note</button>
        </header>

        <notes-board
          notes={this.notes}
          onNoteMoved={this.handleNoteMoved}
          onNoteRemoved={this.handleNoteRemoved}
        ></notes-board>

        {this.showForm && (
          <div class="modal-overlay" onClick={this.toggleForm}>
            <div class="modal" onClick={(e) => e.stopPropagation()}>
              <note-form onNoteCreated={this.handleNoteCreated}></note-form>
              <button class="close-btn" onClick={this.toggleForm}>Cancel</button>
            </div>
          </div>
        )}
      </div>
    );
  }
}
