package progrLab4;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class ClassArray<T> {

	private Hashtable<Integer, T> places;
    private T defaultValue;
    private int maxCount;

	public ClassArray(int size, T defVal)
	{
		defaultValue = defVal;
		places = new Hashtable<Integer, T>();
		maxCount = size;
	}
	
	public static <T extends Interface1> int add(ClassArray<T> p, T poisonousSnake)
	{
		if (p.places.size() == p.maxCount) return -1;
		for(int i = 0; i < p.places.size(); i++)
		{
			if (p.checkFreePlace(i))
			{
				p.places.put(i, poisonousSnake);
				return i;
			}
		}
		p.places.put(p.places.size(), poisonousSnake);
		return p.places.size() - 1;
	}

	public static <T extends Interface1> T dec(ClassArray<T> p, int index)
	{
		if (p.places.get(index) != null)
		{
			T plane = p.places.get(index);
			p.places.remove(index);
			return plane;
		}
		return p.defaultValue;
	}
	
	public boolean checkFreePlace(int index)
	{
		if(places.get(index)==null) return true;
		return false;
	}	
	
	public T getSnake(int ind) {
		if(places.get(ind)!=null) return places.get(ind);
		return defaultValue;
	}

}
