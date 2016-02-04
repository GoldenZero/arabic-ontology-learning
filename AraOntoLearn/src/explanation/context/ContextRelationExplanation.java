package explanation.context;

import evidence.context.ContextVector;
import pom.POMAbstractObject;

import explanation.AbstractExplanation;


public class ContextRelationExplanation extends AbstractExplanation {

	private ContextVector m_domainContext;
	
	private ContextVector m_rangeContext;
	
	
	public ContextRelationExplanation( POMAbstractObject object, Object source ){
		m_object = object;
		m_source = source;
		m_timestamp = System.currentTimeMillis();
	}

	public void setDomainContext( ContextVector domainContext ){
		m_domainContext = domainContext;
	}
	
	public void setRangeContext( ContextVector rangeContext ){
		m_rangeContext = rangeContext;
	}
	
	public ContextVector getDomainContext(){
		return m_domainContext;
	}
	
	public ContextVector getRangeContext(){
		return m_rangeContext;
	}
	
	public boolean equals( Object object ){
		if( !( object instanceof ContextRelationExplanation )
			|| !super.equals( object ) )
		{
			return false;
		}
		ContextRelationExplanation Explanation = (ContextRelationExplanation)object;
		return ( super.equals( object )
			&& Explanation.getDomainContext().equals( getDomainContext() )
			&& Explanation.getRangeContext().equals( getRangeContext() ) );
	} 
}