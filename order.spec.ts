import { Order } from './order';

describe('Order', () => {
  it('should create an instance', () => {
    expect(new Order(1, 1002, 500, 1, 1, 'DELIVERED', 150, '14:55:29', '14:55:29', 
    'thank you for visiting', '2019-02-19 14:55:29')).toBeTruthy();
    console.log('Orders');
  });
});
