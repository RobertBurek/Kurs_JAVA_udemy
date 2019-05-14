import java.util.ArrayList;

/**
 * Created by Robert Burek
 */
/* ARRAYLIST
 * PLUS: SZYBKI DOSTĘP DO ZAWARTOSCI!
 * MINUS: BARDZO WOLNA PRZY DODAWANIU NOWYCH ELMENTOW ORAZ USUWANIU ICH
 * -----
 * | 1 |
 * |   |
 * -----
 * -----
 * |   |
 * |  2|
 * -----
 * -----
 * |   |
 * | 3 |
 * -----
 * -----
 * |   |
 * |  4|
 * -----
 * -----
 * |  5|
 * |   |
 * -----
 * -----
 * |   |
 * |  6|
 * -----
 * Zadeklarowane 6 elementów i nie można dodać 7
 * trzeba koniecznie zadeklorować nową arraylistę na 7 elementów
 * może być jakiś INNY OBIEKT
 * -----
 * |   |
 * |  7|
 * -----
 * */
/*
 * LINKEDLIST
 * MINUS: WOLNE pobieranie WARTOSCI, wolne przeszukiwanie
 * PLUS: BARDZO SZYBKA MOZLIWOSC DODAWANIA ORAZ USUWANIA ELEMENTOW
 *
 * -----
 * | 1 |
 * |   |
 * -----
 * INNY OBIEKT
 * INNY OBIEKT
 * -----
 * | 1 |
 * |   |
 * -----
 *
 * INNY OBIEKT
 *
 * -----
 * | 1 |
 * |   |
 * -----
 *
 *
 *
 * -----
 * | 1 |
 * |   |
 * -----
 *
 *
 * -----
 * | 1 |
 * |   |
 * -----
 *
 * INNY OBIEKT
 * INNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKTINNY OBIEKT
 * -----
 * | 20|
 * |   |
 * -----
 *
 * INNE OBIEKTY jest ich 400
 *
 * -----
 * |420|
 * |   |
 * -----
 * */


public class Main {

    public static void main(String[] args) {

        ArrayList listaTablicowa = new ArrayList(6);

        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());

        ListaPolaczona listaPolaczona = new ListaPolaczona();

        listaPolaczona.wartosc = 10;

        listaPolaczona.nastepna = new ListaPolaczona();
        listaPolaczona.nastepna.wartosc = 20;

        listaPolaczona.nastepna.nastepna = new ListaPolaczona();
        listaPolaczona.nastepna.nastepna.wartosc = 30;

        System.out.println(listaPolaczona.wartosc);
        System.out.println(listaPolaczona.nastepna.wartosc);
        System.out.println(listaPolaczona.nastepna.nastepna.wartosc);
    }
}


class ListaPolaczona {
    int wartosc;
    ListaPolaczona nastepna; //rekurencyjna klasa - klasa we własnej klasie
    ListaPolaczona poprzedni; // dwukierunkowa rekurencja
}