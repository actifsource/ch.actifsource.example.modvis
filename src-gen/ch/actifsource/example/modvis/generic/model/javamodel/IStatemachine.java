package ch.actifsource.example.modvis.generic.model.javamodel;

import ch.actifsource.util.collection.IMultiMapOrdered;

public interface IStatemachine extends ch.actifsource.core.javamodel.INamedResource {

  public static final ch.actifsource.core.INode TYPE_ID = new ch.actifsource.core.Resource("e5aaede8-894f-11ee-bd0f-cd4c7b5a6846");
  
  // relations
  
  public java.util.List<? extends ch.actifsource.example.modvis.generic.model.javamodel.IState> selectState();
  
  public java.util.List<? extends ch.actifsource.diagram.javamodel.IDomainDiagram> selectDiagram();
  
}

/* Actifsource ID=[3ca9f967-db37-11de-82b8-17be2e034a3b,e5aaede8-894f-11ee-bd0f-cd4c7b5a6846,EqZju+I/xwAPL0zFFgB8G4DcgXE=] */
