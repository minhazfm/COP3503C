
public class LinearProbeHashTable 
{
	int m_nTableSize = 10000;
	DataObject[] m_ObjectArray;
	
	public LinearProbeHashTable()
	{
		m_ObjectArray = new DataObject[m_nTableSize];
	}
	
	public LinearProbeHashTable( int nTableSize )
	{
		m_nTableSize = nTableSize;
		m_ObjectArray = new DataObject[m_nTableSize];
	}
	
	public void Expand()
	{
	}
	
	public void put( DataObject objData )
	{
	}

	public DataObject get( String strKey )
	{
		return( null );
	}
	
}
