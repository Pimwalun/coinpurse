package coinpurse;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author Pimwalun Witchawanitchanun
 */
public class Purse {
    /** Collection of objects in the purse. */
    private List<Valuable> money;
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	this.money = new ArrayList<>();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double sum = 0;
    	for (Valuable x : money){
    		sum += x.getValue();
    	}
    	return sum; 
    }
    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() { 
    	return this.capacity;
    }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        return money.size() == capacity;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param value is a Coin object to insert into purse
     * @return true if value inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        // if the purse is already full then can't insert anything.
    	if ( isFull() ) return false;
    	if ( value.getValue() <= 0) return false;
    	if ( value == null ) return false;
    	money.add(value);
        return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	List<Valuable> templist = new ArrayList<>();
    	Valuable [] array;
    	Collections.sort( money, new CompareByCurrency());
    	Collections.reverse( money );
        if (amount < 0) return null;
		for (Valuable x : money) {
			if (amount >= x.getValue()){
				amount -= x.getValue();
				templist.add(x);
			}
		}
		if (amount != 0) return null;
		array = new Valuable[templist.size()];
		if (amount == 0) templist.toArray(array);
		for (Valuable x : templist) {
			money.remove(x);
		}
		if (getBalance() < amount) return null;
        return array; 
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return count() + " coin with value " + getBalance();
    }

}