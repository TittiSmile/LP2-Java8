package com.company;
import java.util.*;
public class Person implements Iterable<Person> {
    private String nome;
    private Set<Person> setFriends;
    private Set<Person> setEnemies;
    private List<Person> listOfContacts; //creo una lista di contatti.
    Person(String n){
        this.nome=n;
        setEnemies=new HashSet<>();
        setFriends=new HashSet<>();
        listOfContacts=new LinkedList<>();
    }

    void addFriend(Person newPerson){
       if((!setEnemies.contains(newPerson))  && (!this.equals(newPerson ))){
           //ATTENZIONE AL SECONDO CONTROLLO!!
           //fare il controllo (!setFriends.contains(newPerson)) non sarebbe servito. perchè controlla che nel set non ci
           //sia la persona passata. noi dobbiamo controllare che la persona corrente (this) non sia uguale a quella passata.
           setFriends.add(newPerson);
        }
    }

    void addEnemy(Person newPerson){
        if( (!setFriends.contains(newPerson)) && (!this.equals(newPerson))){
            setEnemies.add(newPerson);
        }
    }

    List<Person> contacts(){
        //nella lista aggiungo tutti gli amici e poi i nemici
        listOfContacts.addAll(setFriends);
        listOfContacts.addAll(setEnemies);
        return listOfContacts;
    }

    public String getNome() {
        return nome;
    }

    public List<Person> getListOfContacts() {
        return listOfContacts;
    }

    public Set<Person> getSetEnemies() {
        return setEnemies;
    }

    public Set<Person> getSetFriends() {
        return setFriends;
    }

    @Override
    public String toString() {
        return this.nome;
    }


    @Override
    public Iterator<Person> iterator() { //faccio iterare l'iteratore sulla lista dei contatti (che contiene amici e nemici)
        return listOfContacts.iterator();
    }
}
