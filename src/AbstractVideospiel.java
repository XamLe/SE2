abstract class AbstractVideospiel extends AbstractMedium
{
	private final String _system;
	private static final int BASIS_PREIS = 200;
	
	/**
	 *  * Initialisiert eine Videospiel mit den gegebenen Daten.
     * 
     * @param titel Das Titel von der Videospiel.
     * @param kommentar Einen Kommentar zu der Videospiel.
     * @param system Der System der Videospiel.
     * 
     * @require titel != null
     * @require kommentar != null
     * @require system != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getSystem() == system
     */
	protected AbstractVideospiel(String titel, String kommentar, String system)
	{
		super(titel, kommentar);
        assert system != null : "Vorbedingung verletzt: system != null";
		_system = system;
	}

	@Override
	public String getMedienBezeichnung() 
	{
		return "Videospiel";
	}

	/**
     * Gibt den System der Videospiel zurück
     * 
     * @return Den System der Videospiel
     * 
     * @ensure result != null
     */
	public String getSystem() 
	{
		return _system;
	}

	@Override
	public String getFormatiertenString() 
	{
		return super.getFormatiertenString() + getSystem();
	}
	
	@Override
	public Geldbetrag berechneMietgebuehr(int mietTage)
	{
		return new Geldbetrag(this.BASIS_PREIS + getPreisNachTagen(mietTage));
	}
	
	abstract int getPreisNachTagen(int tage);
}
