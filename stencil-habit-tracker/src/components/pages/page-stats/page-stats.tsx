import { Component, h, Prop, State, Event, EventEmitter, Method } from '@stencil/core';

@Component({
  tag: 'page-stats',
  styleUrl: 'page-stats.css',
  shadow: true
})
export class PageStats {
  
  render() {
    return (
      <div>
        <h3>page-stats</h3>
      </div>
    );
  }
}