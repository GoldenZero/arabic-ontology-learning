package pom;

public class POMHasARelation extends POMObject implements POMTaxonomicRelation {
	private POMConcept m_domain;

	private POMConcept m_range;
	
	protected POMHasARelation(){
		m_sLabel = "has-a";
	}

	public void setDomain( POMConcept domain ){
		m_domain = domain;
	}

	public POMConcept getDomain(){
		return m_domain;
	}
 
	public void setRange( POMConcept range ){
		m_range = range;
	} 
	
	public POMConcept getRange(){
		return m_range;
	}

	public Object clone(){
		POMHasARelation rel = new POMHasARelation();
		rel.setDomain( (POMConcept)m_domain.clone() );
		rel.setRange( (POMConcept)m_range.clone() );
		return rel;
	}

	public boolean equals( Object object ){
		return ( object instanceof POMHasARelation ) 
			&& ((POMHasARelation)object).getLabel().equals( m_sLabel )
			&& ((POMHasARelation)object).getDomain().equals( m_domain )
			&& ((POMHasARelation)object).getRange().equals( m_range );
	}

	public int hashCode(){
		return ( getClass().getName() + getLabel() 
			+ m_domain.getLabel() + m_range.getLabel() ).hashCode(); 
	}

	public String toString(){
		return m_sLabel +"( "+ m_domain.getLabel() +", "+ m_range.getLabel() +" )"; 
	}

	
}
