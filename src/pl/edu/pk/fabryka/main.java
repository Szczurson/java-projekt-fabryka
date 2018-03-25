
package pl.edu.pk.fabryka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marcin Szczurek
 */
public class main
{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String menu;
        Scanner input = new Scanner(System.in);
        
        List<autoKaroseria> Karoserie = new ArrayList<autoKaroseria>();
        List<autoMaska> Maski = new ArrayList<autoMaska>();
        List<autoBlotniki> Blotniki = new ArrayList<autoBlotniki>();
        List<autoDrzwi> Drzwi = new ArrayList<autoDrzwi>();
        
        do{
            System.out.println("Witaj w fabryce czesci metalowych!\n");
            System.out.println("Wybierz opcje:\n"
                    + "1. Linia produkcyjna\n"
                    + "2. Lakiernia\n"
                    + "3. Magazyn\n"
                    + "0. Wyjscie z programu");
            System.out.println("\nWYBOR: ");
            menu = input.next();
            
            switch(menu)
            {
                case "0":
                    System.out.println("Konczenie pracy programu...");
                    kontynuuj();
                    System.exit(0);
                    break;
                
                case "1":
                    intfLinia(Karoserie, Maski, Blotniki, Drzwi);
                    break;
                    
                case "2":
                    intfLakiernia(Karoserie, Maski, Blotniki, Drzwi);
                    break;
                    
                case "3":
                    intfMagazyn(Karoserie, Maski, Blotniki, Drzwi);
                    break;
                    
                default:
                    System.out.println("Nieprawidlowa opcja."
                            + " Prosze sprawdzic poprawnosc wyboru.");
                    kontynuuj();
                    break;
            }
            
        }while(true);
    }
 
    public static void intfLinia(List<autoKaroseria> kar, List<autoMaska> mas,
            List<autoBlotniki> blo, List<autoDrzwi> drz)
    {
        String menu;
        Scanner input = new Scanner(System.in);
        boolean bad_input = false;
        int elementow;
        
        do{
            System.out.println("Wybierz element do wyprodukowania:");
            System.out.println("1. Szkielet karoserii\n"
                    + "2. Maska\n"
                    + "3. Blotniki\n"
                    + "4. Drzwi\n"
                    + "0. WSTECZ");
            System.out.println("\nWYBOR: ");
            menu = input.next();

            switch(menu)
            {
                case "0":
                    return;

                case "1":
                    elementow = kar.size();
                    kar.add(new autoKaroseriaMetal());
                    System.out.println("Udalo sie wytworzyc jeden szkielet karoserii.");
                    kar.get(elementow).info();
                    kontynuuj();
                    break;

                case "2":
                    elementow = mas.size();
                    mas.add(new autoMaskaMetal());
                    System.out.println("Udalo sie wytworzyc jedna maske.");
                    mas.get(elementow).info();
                    kontynuuj();
                    break;

                case "3":
                    elementow = blo.size();
                    blo.add(new autoBlotnikiMetal());
                    System.out.println("Udalo sie wytworzyc jeden komplet blotnikow.");
                    blo.get(elementow).info();
                    kontynuuj();
                    break;

                case "4":
                    elementow = drz.size();
                    drz.add(new autoDrzwiMetal());
                    System.out.println("Udalo sie wytworzyc jeden komplet drzwi.");
                    drz.get(elementow).info();
                    kontynuuj();
                    break;

                default:
                    System.out.println("Nieprawidlowa opcja."
                            + " Prosze sprawdzic poprawnosc wyboru.");
                    bad_input = true;
                    kontynuuj();
                    break;
            }
        }while(bad_input);
    }

    
    public static void intfLakiernia(List<autoKaroseria> kar, List<autoMaska> mas,
            List<autoBlotniki> blo, List<autoDrzwi> drz)
    {
        String menu, malowanie;
        Scanner input = new Scanner(System.in);
        boolean bad_input = false;
        int elementow, numer_ele;
        
        do{
            System.out.println("Wybierz element do lakierowaia:");
            System.out.println("1. Szkielet karoserii\n"
                    + "2. Maska\n"
                    + "3. Blotniki\n"
                    + "4. Drzwi\n"
                    + "0. WSTECZ");
            System.out.println("\nWYBOR: ");
            menu = input.next();
            
            switch(menu)
            {
                case "0":
                    return;

                case "1":
                    if(kar.isEmpty())
                    {
                        System.out.println("Nie ma elementow do lakierowania."
                                + " Prosze wczesniej udac sie na linie produkcyjna"
                                + " i stworzyc element.");
                        kontynuuj();
                        return;
                    }
                    elementow = kar.size();
                    
                    if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jeden element do lakierowania.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do lakierowania (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    System.out.println("Podaj kolor malowania: ");
                    malowanie = input.next();
                    
                    kar.set(numer_ele, new autoKaroseriaKolor(kar.get(numer_ele), malowanie));
                    kar.get(numer_ele).info();
                    kontynuuj();
                    break;
                    
                case "2":
                    if(mas.isEmpty())
                    {
                        System.out.println("Nie ma elementow do lakierowania."
                                + " Prosze wczesniej udac sie na linie produkcyjna"
                                + " i stworzyc element.");
                        kontynuuj();
                        return;
                    }
                    elementow = mas.size();
                    
                    if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jeden element do lakierowania.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do lakierowania (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    System.out.println("Podaj kolor malowania: ");
                    malowanie = input.next();
                    
                    mas.set(numer_ele, new autoMaskaKolor(mas.get(numer_ele), malowanie));
                    mas.get(numer_ele).info();
                    kontynuuj();
                    break;

                case "3":
                    if(blo.isEmpty())
                    {
                        System.out.println("Nie ma elementow do lakierowania."
                                + " Prosze wczesniej udac sie na linie produkcyjna"
                                + " i stworzyc element.");
                        kontynuuj();
                        return;
                    }
                    elementow = blo.size();
                    
                    if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jeden element do lakierowania.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do lakierowania (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    System.out.println("Podaj kolor malowania: ");
                    malowanie = input.next();
                    
                    blo.set(numer_ele, new autoBlotnikiKolor(blo.get(numer_ele), malowanie));
                    blo.get(numer_ele).info();
                    kontynuuj();
                    break;

                case "4":
                    if(drz.isEmpty())
                    {
                        System.out.println("Nie ma elementow do lakierowania."
                                + " Prosze wczesniej udac sie na linie produkcyjna"
                                + " i stworzyc element.");
                        kontynuuj();
                        return;
                    }
                    elementow = drz.size();
                    
                    if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jeden element do lakierowania.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do lakierowania (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    System.out.println("Podaj kolor malowania: ");
                    malowanie = input.next();
                    
                    drz.set(numer_ele, new autoDrzwiKolor(drz.get(numer_ele), malowanie));
                    drz.get(numer_ele).info();
                    kontynuuj();
                    break;

                default:
                    System.out.println("Nieprawidlowa opcja."
                            + " Prosze sprawdzic poprawnosc wyboru.");
                    bad_input = true;
                    kontynuuj();
                    break;
            }
            
        }while(bad_input);
    }
    
    public static void intfMagazyn(List<autoKaroseria> kar, List<autoMaska> mas,
            List<autoBlotniki> blo, List<autoDrzwi> drz)
    {
        String menu;
        Scanner input = new Scanner(System.in);
        boolean bad_input = false;
        int elementow, numer_ele;
        
        do{
            System.out.println("Wybierz element do podlgadu:");
            System.out.println("1. Szkielet karoserii\n"
                    + "2. Maska\n"
                    + "3. Blotniki\n"
                    + "4. Drzwi\n"
                    + "0. WSTECZ");
            System.out.println("\nWYBOR: ");
            menu = input.next();
            
            switch(menu)
            {
                case "0":
                    return;

                case "1":
                    elementow = kar.size();
                    
                    if(elementow == 0)
                    {
                        System.out.println("Brak szkieletow karoserii na magazynie.");
                        kontynuuj();
                        return;
                    }
                    else if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jeden szkielet karoserii na magazynie.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do zobaczenia (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    kar.get(numer_ele).info();
                    kontynuuj();
                    break;

                case "2":
                    elementow = mas.size();
                    
                    if(elementow == 0)
                    {
                        System.out.println("Brak masek na magazynie.");
                        kontynuuj();
                        return;
                    }
                    else if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jedna maska na magazynie.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do zobaczenia (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    mas.get(numer_ele).info();
                    
                    kontynuuj();
                    break;

                case "3":
                    elementow = blo.size();
                    
                    if(elementow == 0)
                    {
                        System.out.println("Brak blotnikow na magazynie.");
                        kontynuuj();
                        return;
                    }
                    else if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jeden komplet blotnikow na magazynie.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do zobaczenia (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    blo.get(numer_ele).info();
                    
                    kontynuuj();
                    break;

                case "4":
                    elementow = drz.size();
                    
                    if(elementow == 0)
                    {
                        System.out.println("Brak drzwi na magazynie.");
                        kontynuuj();
                        return;
                    }
                    if(elementow == 1)
                    {
                        System.out.println("Istnieje tylko jeden komplet drzwi na magazynie.");
                        numer_ele = 0;
                    }
                    else
                    {
                        System.out.println("Wybierz id elementu do zobaczenia (0 - " + (elementow-1) + "): ");
                        numer_ele = input.nextInt();
                    }
                    
                    if(numer_ele < 0 || numer_ele > (elementow-1))
                    {
                        System.out.println("Podano wartosc z poza zakresu.");
                        kontynuuj();
                        return;
                    }
                    
                    drz.get(numer_ele).info();
                    
                    kontynuuj();
                    break;

                default:
                    System.out.println("Nieprawidlowa opcja."
                            + " Prosze sprawdzic poprawnosc wyboru.");
                    bad_input = true;
                    kontynuuj();
                    break;
            }
            
        }while(bad_input);
    }
    
    public static void kontynuuj()
    {
        try
        {
            System.out.println("Nacisnij ENTER aby kontunuowac...");
            System.in.read();
        } catch (IOException ex)
        {
            System.out.println("Blad IOException - " + ex);
        }
    }
 }   