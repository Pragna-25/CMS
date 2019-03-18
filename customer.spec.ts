import { Customer } from './customer';

describe('Customer', () => {
  it('should create an instance', () => {
    expect(new Customer('3', 'JOHN', 'JOHN', 2342345, 'JOHN@gmail.com', '1000', 'JOHN@123')).toBeTruthy();
  });
});
