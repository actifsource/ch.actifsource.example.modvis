package ch.actifsource.example.modvis.target;

import ch.actifsource.solution.modvis.server.core.util.JsonAnimationHelper;

/**
 *  Define the modul context
 *  In this system we only have one module with the id []
 */
public class ModulContext {

	private JsonAnimationHelper.JsonId fModulId;
	
	private boolean 				fInitComplete;
	
	private int		 				fNextActiveState;
	
	private int 					fSequenceNumber;
	
	public ModulContext(JsonAnimationHelper.JsonId modulId) {
		fModulId = modulId;
		fInitComplete = false;
		fSequenceNumber = 1;
		fNextActiveState = 1;
	}
	
	public JsonAnimationHelper.JsonId getModulId() {
		return fModulId;
	}
	
	public boolean isInitComplte() {
		return fInitComplete;
	}
	
	public void setInitComplete() {
		fInitComplete = true;
	}
	
	public int getNextActiveState() {
		fNextActiveState++;
		if (fNextActiveState > 3) {
			fNextActiveState = 1;
		}
		return fNextActiveState;
	}
	
	public int getNewSequenceNumber() {
		fSequenceNumber++;
		return fSequenceNumber;
	}
	
	public int getCurrentSequenceNumber() {
		return fSequenceNumber;
	}
	
	public void setInitSequenceNumber(int seq) {
		fSequenceNumber = seq;
	}
	
	@Override
    public int hashCode() {
      final int prime = 31;
      int result = getClass().hashCode();
      result = prime * result + fModulId.hashCode();
      return result;
    }
	
	@Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      ModulContext other = (ModulContext)obj;
      if (!fModulId.equals(other.fModulId)) return false;
      return true;
    }
}
