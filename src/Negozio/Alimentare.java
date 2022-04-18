
package Negozio;
import java.util.Calendar;

/**
 * La classe gestisce la tipologia Alimentare di Prodotto
 * @author Meratti
 */
public class Alimentare extends Prodotto{
    /**
     * mese di scadenza riportato sulla confezione del prodotto
     */
    protected int annoScadenza;

    /**
     * anno di scadenza riportato sulla confezione del prodotto
     */
    protected int meseScadenza;

    private Calendar cal = Calendar.getInstance();
    int anno = cal.get(Calendar.YEAR);
    int mese = cal.get(Calendar.MONTH);

    /**
     * Costruttore Parametrico - Costruisce un oggetto di tipo ProdottoAlimentare.
     * @param meseScadenza anno di scadenza da assegnare al nuovo oggetto Prodotto 
     * @param annoScadenza mese di scadenza da assegnare al nuovo oggetto Prodotto
     * @param nome nome da assegnare al nuovo oggetto Prodotto>
     * @param prezzo prezzo da assegnare al nuovo oggetto Prodotto
     * @param provenienza nazione di produzione del nuovo oggetto Prodotto
     */
    public Alimentare(int annoScadenza, int meseScadenza, String nome, double prezzo, String provenienza){
        super(nome, prezzo, provenienza);
        this.annoScadenza = annoScadenza;
        this.meseScadenza = meseScadenza;
    }

    /**
     * Restituisce il mese di scadenza riportato sulla confezione.
     * @return mese di scadenza
     */
    public int getMeseScadenza(){
        return this.meseScadenza;
    }

    /**
     * Restituisce l'anno di scadenza riportato sulla confezione.
     * @return anno di scadenza
     */
    public int getAnnoScadenza(){
        return this.annoScadenza;
    }

    /**
     * Imposta il mese di scadenza dell'oggetto Prodotto Alimentare.
     * @param meseScadenza intero che rappresenta il mese (1-12)
     */
    public void setMeseScadenza(int meseScadenza){
        this.meseScadenza = meseScadenza;
    }

    /**
     * Imposta l'anno di scadenza dell'oggetto Prodotto Alimentare.
     * @param annoScadenza intero che rappresenta l'anno (>1900)
     */
    public void setAnnoScadenza(int annoScadenza){
        this.annoScadenza = annoScadenza;
    }

    /**
     * Restituisce una stringa che rappresenta l'oggetto ProdottoAlimentare.
     * @return Rappresentazione testuale dell'oggetto ProdottoAlimentare
     */
    @Override
    public String toString(){
        return "Anno di Scadenza: " + this.annoScadenza + 
                "\nMese di Scadenza: " + this.meseScadenza;
    }

    /**
     * Controlla la scadenza del prodotto
     * @return true se il prodotto è scaduto, false altrimenti
     */
    public boolean isScaduto(){
        if(this.annoScadenza < anno){
            return true;
        }
        else{
            if(this.meseScadenza < mese)
                return true;
            else
                return false;
        }
    }
    
    /**
     * Applica uno sconto sul prezzo del prodotto Alimentare.
     * <ul>
     *  <li>Se il prodotto è scaduto lo sconto non viene applicato.</li>
     *  <li>Se ci si trova nel mese di scadenza allora applica uno sconto del 50%</li>
     *  <li>Negli altri casi rimane lo sconto del 10%</li>
     * </ul>
     */
    @Override
    public void applicaSconto(){
        if(this.isScaduto())
            return;
        else if(this.meseScadenza == mese && this.annoScadenza == anno)
            this.prezzo /= 2;
        else
            super.applicaSconto();
    }
}
