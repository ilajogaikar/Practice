package com.ebay.dss.PracticeStuff;

import java.util.Random;

public class DeckOfCards {
    /*Collections of cards*/    
    private Card cards[];

    /*Remaining number of cards in the deck*/
    private int currentCount;

    /*Size of the deck which can handle cards*/
    private int size;

    private Suit suits[];

    private Ranks ranks[];

    public DeckOfCards(){
        size=52;
        currentCount=0;
        cards = new Card[size];
        suits=Suit.values();
        ranks=Ranks.values();

        for(int i =0 ; i<suits.length;i++){
            for(int j =0 ; j<ranks.length;j++){
                cards[currentCount++] = new Card(suits[i],ranks[j]);
            }

        }
    }

  /*This is to shuffle the cards in the deck with the remaining cards.
  Variable numberOftime represents the number of time need to shuffle the cards in deck*/

    public void shuffle(int numberOftime){

        Random rand= new Random();


        for(int i=0;i<numberOftime;i++){
            int m=rand.nextInt(currentCount);
            int n=rand.nextInt(currentCount);

            Card temp=cards[m];
            cards[m]=cards[n];
            cards[n]=temp;
        }

    }

/*This function is to deal the cards whatever is on top of the deck.*/
    public void deal(){
        System.out.println(cards[--currentCount]);
    }

/*This is to represents the String representation of the current cards inthe deck.*/ 
    public String toString(){

        StringBuilder sb=new StringBuilder();

        for(int i=0;i < currentCount;i++){
            sb.append(cards[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

/*  Sorting the cards based on the suit and then numbers.
    This sorting is using Bucket Sort to sort the cards runtime= O(n) space=O(n);*/
    public void sort(){

        Card bucketCards[][]= new Card[suits.length][ranks.length];

        for(int i=0;i<currentCount;i++){
            bucketCards[cards[i].getSuit().ordinal()][cards[i].getValue().ordinal()]=cards[i];
        }

        int pointer=0;

        for(int i=0;i<suits.length;i++){
            for(int j=0;j<ranks.length;j++){
                if(bucketCards[i][j]!=null)
                    cards[pointer++]=bucketCards[i][j];
            }
        }


    }

    /*This will reset the deck. i.e it will put back all the cards in the deck if it has been dealt.*/
    public void resetdesk(){
        currentCount=52;
    }

/*Printing the stack of cards in format*/ 
    public void printStack(){
        int cardPointer=0;
        for(int i=0;i<suits.length;i++){

            for(int j=0;j<ranks.length;j++){
                System.out.print(cards[cardPointer++]+" ");
            }

            System.out.println("\n");
        }

    }

    /*Get size of the deck*/
    public int getSize() {
        return size;
    }

/*This represents the suit of the card*/
    private enum Suit{
        CLUB,DIAMOND,SPADE,HEART
    }

/* This represents the number of the card*/
    private enum Ranks{
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }

/* This class represents the card with specific suit and value. 
 * Cannot change the value once instansiated */
    private class Card{

        private final Suit suit;

        private final Ranks ranks;

        public Card(Suit suit, Ranks value){
             this.suit=suit;
             this.ranks=value;
        }


        public Suit getSuit() {
            return suit;
        }

        public Ranks getValue() {
            return ranks;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return suit+"-"+ranks;
        }
    }
}