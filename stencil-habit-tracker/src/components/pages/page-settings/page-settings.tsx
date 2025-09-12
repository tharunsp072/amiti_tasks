import { Component, h, Prop, State, Event, EventEmitter, Method } from '@stencil/core';

@Component({
  tag: 'page-settings',
  styleUrl: 'page-settings.css',
  shadow: true
})
export class PageSettings {
  
  render() {
    return (
      <div>
        <h3>page-settings</h3>
      </div>
    );
  }
}