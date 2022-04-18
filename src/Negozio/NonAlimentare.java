package Negozio;
/**
 * La classe gestisce la tipologia NonAlimentare di Prodotto
 * @author Meratti
 */
public class NonAlimentare extends Prodotto
{
    /**
     * materiale principale costituente del prodotto
     */
    protected String materialePrincipale;
    /**
     * Se il prodotto è riciclabile o meno
     */
    protected boolean riciclabile;

    /**
     * Costruttore Parametrico - Costruisce un oggetto di tipo Prodotto NonAlimentare.
     * @param materialePrincipale Nome del materiale principale
     * @param riciclabile True se riciclabile, False altrimenti
     * @param nome nome da assegnare al nuovo oggetto Prodotto
     * @param prezzo prezzo da assegnare al nuovo oggetto Prodotto
     * @param provenienza nazione di produzione del nuovo oggetto Prodotto
     */
    public NonAlimentare(String materialePrincipale, boolean riciclabile, String nome, double prezzo, String provenienza){
        super(nome, prezzo, provenienza);
        this.materialePrincipale = materialePrincipale;
        this.riciclabile = riciclabile;
    }

    /**
     * Restituisce il nome del materiale principale
     * @return nome del materiale principale
     */
    public String getMaterialePrincipale(){
        return this.materialePrincipale;
    }

    /**
     * Restituisce se il prodotto Non Alimnetare è riciclabile oppure no.
     * @return true se è riciclabile, falso altrimenti
     */
    public boolean isRiciclabile(){
        return this.riciclabile;
    }

    /**
     * Imposta il materiale dell'oggetto.
     * @param materialePrincipale  stringa che rappresenta materiale
     */
    public void setMaterialePrincipale(String materialePrincipale){
        this.materialePrincipale = materialePrincipale;
    }

    /**
     * Imposta vero se l'oggetto è riciclabile, falso altrimenti
     * @param riciclabile vero/falso
     */
    public void setRiciclabile(boolean riciclabile){
        this.riciclabile = riciclabile;
    }

    /**
     * Applica uno sconto sul prodotto Non Alimentare.
     * <ul>
     *  <li>Se il prodotto è riciclabile viene applicato uno sconto del 15% </li>
     *  <li>Altrimenti sconto del 10% </li>
     * </ul>
     */
    @Override
    public void applicaSconto(){
        if(isRiciclabile())
            this.prezzo *= 0.85;
        else
            super.applicaSconto();
    }
}
