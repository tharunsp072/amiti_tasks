import { Component, h, State } from '@stencil/core';
import { cartState, clearCart, onChange, Product } from './store';

@Component({
  tag: 'stencil-cart-modal',
  styleUrl: 'stencil-cart-modal.css',
  shadow: true,
})
export class StencilCartModal {
  @State() show: boolean = false;
  @State() items: Product[] = [];

  componentWillLoad() {
    onChange('items', value => {
      this.items = value;
    });
  }

  private handleShow = () => {
    this.show = !this.show;
  };

  private handleClearCart = () => {
    clearCart();
  };

  render() {
    return (
      <div>
        <button onClick={this.handleShow}>View Cart</button>

        {this.show && (
          <div class="modal">
            <h1>Cart Items</h1>
            {this.items.length === 0 ? (
              <p>Your Cart is Empty</p>
            ) : (
              <ul class="ul-list">
                {this.items.map(item => (
                  <li>
                    {item.name} - ${item.price}
                  </li>
                ))}
              </ul>
            )}

            <button onClick={this.handleClearCart}>Clear Cart</button>
          </div>
        )}
      </div>
    );
  }
}
