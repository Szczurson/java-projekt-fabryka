package pl.edu.pk.fabryka;

public class autoDrzwiKolor implements autoDrzwi
{
    private autoDrzwi drzw;
    String kolor;
    
    public autoDrzwiKolor(autoDrzwi drzw, String kolor)
    {
        this.drzw = drzw;
        this.kolor = kolor;
    }
    
    @Override
    public void info()
    {
        System.out.println("Drzwi zostaly pomalowane na piekny " + kolor + " kolor.");
    } 
}
