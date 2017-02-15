package interfaces;

import java.util.ArrayList;

public interface IObservable {
	
		public void addObserver(IObservador observador);
		public void removeObserver(IObservador observador);
		public void notifyObservers(ArrayList<IObservador> observador);

}
