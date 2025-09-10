import { Component, Prop, h } from '@stencil/core';
import { addToCart, Product } from './store';

@Component({
  tag: 'stencil-product-card',
  styleUrl: 'stencil-product-card.css',
  shadow: true,
})
export class StencilProductCard {
  @Prop() product: string | Product | Product[];
  private parsedProducts: Product[] = [];

  componentWillLoad() {
    if (typeof this.product === 'string') {
      const parsed = JSON.parse(this.product);
      this.parsedProducts = Array.isArray(parsed) ? parsed : [parsed];
    } else if (Array.isArray(this.product)) {
      this.parsedProducts = this.product;
    } else {
      this.parsedProducts = [this.product];
    }
  }

  private handleAddToCart = (product: Product) => {
    addToCart(product);
  };

  render() {
    return (
      <div class="grid-container">
        {this.parsedProducts.map((prod) => (
          <div class="card">
            <img src={prod.image} alt={prod.name} />
            <h3>{prod.name}</h3>
            <p>${prod.price}</p>
            <button onClick={() => this.handleAddToCart(prod)}>Add to Cart</button>
          </div>
        ))}
      </div>
    );
  }
}
