package main.interfaces;

import java.util.Collection;

public interface Repository<I, T> {
  public T get(I id);

  public void add(T allotment);

  public T remove(I id);

  public Collection<T> all();
}
