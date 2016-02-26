package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    ArrayList<BorrowableItem> bookList = new ArrayList<BorrowableItem>();
    ArrayList<BorrowableItem> movieList = new ArrayList<BorrowableItem>();
    UserInterface ui;

    public Library(){
        bookList = generateNewBookList();
        movieList = generateNewMovielist();
    }

    private ArrayList<BorrowableItem> generateNewMovielist(){
        Movie mNos = new Movie("Nosferatu","F.W. Murnau",1922, 8);
        Movie mSam = new Movie("Samurai Cop","Amir Shervan",1991, -1);
        Movie mPi = new Movie("Pi","Darren Aronofsky",1998, 7);


        ArrayList<BorrowableItem> ml = new ArrayList<BorrowableItem>();

        ml.add(mNos);
        ml.add(mSam);
        ml.add(mPi);

        return ml;
    }
    private ArrayList<BorrowableItem> generateNewBookList(){
        Book b1984 = new Book("1984","George Orwell",1949);
        Book bLolita = new Book("Lolita","Vladmir Nabokov",1955);
        Book bOldPat = new Book("The Old Patagonian Express","Paul Theroux",1979);

        ArrayList<BorrowableItem> bl = new ArrayList<BorrowableItem>();

        bl.add(b1984);
        bl.add(bLolita);
        bl.add(bOldPat);

        return bl;
    }

    private ArrayList<User> generateNewUserList(){
        User uAlec = new User("123-4567");
        User uJoe = new User("111-1111");
        User uJim = new User("222-2222");

        ArrayList<User> ul = new ArrayList<User>();

        ul.add(uAlec);
        ul.add(uJoe);
        ul.add(uJim);

        return ul;
    }

    public ArrayList<BorrowableItem> getBookList() {
        return bookList;
    }

    public ArrayList<BorrowableItem> getMovieList() {
        return movieList;
    }

    public void runUI(){
        ui = new UserInterface(bookList, movieList);
        System.out.println(ui.getWelcomeMessage());

        int menuSelection = -1;

        while(menuSelection != ui.getExitCode()){
            System.out.println(ui.getMenuString());
            menuSelection = ui.getUserMenuSelection();
            System.out.println(ui.getMenuOption(menuSelection));

            switch (menuSelection){
                case 2:
                    System.out.println(ui.checkOutBookMenuSelection(ui.getUserMenuSelection()));
                    break;
                case 3:
                    System.out.println(ui.returnBookMenuSelection(ui.getUserMenuSelection()));
                    break;
                case 5:
                    System.out.println(ui.checkOutMovieMenuSelection(ui.getUserMenuSelection()));
                    break;
                case 6:
                    System.out.println(ui.returnMovieMenuSelection(ui.getUserMenuSelection()));
                    break;
                default:
                    break;
            }
        }
    }
}
