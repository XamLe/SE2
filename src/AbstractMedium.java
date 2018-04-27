
public abstract class AbstractMedium implements Medium {
	private String _kommentar;
	private String _titel;
	
	 /**
     * Initialisiert ein neues Exemplar.
     * 
     * @param titel Der Titel der CD
     * @param kommentar Ein Kommentar zu der CD
     * 
     * @require titel != null
     * @require kommentar != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     */
	protected AbstractMedium(String titel, String kommentar)
	{
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
		_titel = titel;
		_kommentar = kommentar;
	}
	
	public String getKommentar()
    {
        return _kommentar;
    }

    public String getTitel()
    {
        return _titel;
    }
    
    /**
     * Setze den Kommentar
     * 
     * @require kommentar != null
     */
    public void setKommentar(String kommentar)
    {
    	assert kommentar != null : "Vorbedingung verletzt: null";
    	_kommentar = kommentar;
    }
    
    /**
     * Setze den Titel
     * 
     * @require titel != null
     */
    public void setTitel(String titel)
    {
    	assert titel != null : "Vorbedingung verletzt: null";
    	_titel = titel;
    }
    

	public String getFormatiertenString() 
	{
		return getTitel() + " " + getKommentar() + " ";
	}
	
	public Geldbetrag berechneMietgebuehr(int mietTage)
	{
		return new Geldbetrag(mietTage * 300);
	}
}