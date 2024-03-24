import { TransformadorEnumPipe } from './transformador-enum.pipe';

describe('TransformadorEnumPipe', () => {
  it('create an instance', () => {
    const pipe = new TransformadorEnumPipe();
    expect(pipe).toBeTruthy();
  });
});
