
public class AccountList {
	
	Account[] data;
	int size;
	static final int INITIAL_CAPACITY = 100;
	
	//Default Constructor
	public AccountList() {
		data = new Account[INITIAL_CAPACITY];
		size = 0;
	}
	
	//Returns size
	public int size() {
		return size;
	}
	
	//Returns whether the array is empty or not
	public boolean isEmpty() {
		return size == 0;
	}
 	
	//Method to add a bank account to the array list
	public void add(Account a) {
		if(size < data.length) {
			data[size] = a;
			size++;
		}
		
		else {
			Account[] temp = new Account[size*2];
			for(int i = 0; i < size; i++) {
				temp[i] = data[i];
			}
			temp[size++] = a;
			data = temp;
		}
	}
	
	//Method to get specific index of array list
	public Account get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			return data[index];
		}
	}
	
	//Method to set specific index to a bank account
	public void set(int index, Account a) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		data[index] = a;
	}

	//Method to remove bankAccount at a specific index of the array list
	public void remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		for(int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
	}
	
	
}
